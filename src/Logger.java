import java.io.*;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "server_log.txt";

    public static synchronized void log(String message) {
        String entry = "[" + LocalDateTime.now() + "] " + message;
        System.out.println(entry);
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(entry);
        } catch (IOException e) {
            System.out.println("Failed to write log: " + e.getMessage());
        }
    }
}