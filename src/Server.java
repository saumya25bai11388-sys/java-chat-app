import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());
    private static final int PORT = 5000;

    public static void main(String[] args) {
        Logger.log("Server starting on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket, clients);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            Logger.log("Server error: " + e.getMessage());
        }
    }

    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}