import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private Set<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket, Set<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Enter your username:");
            username = in.readLine();

            if (!UserManager.registerUser(username)) {
                out.println("Username taken. Disconnecting.");
                socket.close();
                return;
            }

            Logger.log(username + " connected.");
            broadcast(username + " has joined the chat.", this);

                         String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
                if (message.trim().isEmpty()) {
                    continue;
                }
                Logger.log(username + ": " + message);
                broadcast(username + ": " + message, this);
            }
       } catch (IOException e) {
            Logger.log("Connection error: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private void broadcast(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.out.println(message);
                }
            }
        }
    }

    private void disconnect() {
        try {
            clients.remove(this);
            Server.removeClient(this);
            if (username != null) {
                UserManager.removeUser(username);
                broadcast(username + " has left the chat.", this);
                Logger.log(username + " disconnected.");
            }
            socket.close();
        } catch (IOException e) {
            Logger.log("Error during disconnect: " + e.getMessage());
        }
    }
}