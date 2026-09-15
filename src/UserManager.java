import java.util.*;

public class UserManager {
    private static Set<String> activeUsers = Collections.synchronizedSet(new HashSet<>());

    public static synchronized boolean registerUser(String username) {
        if (username == null || username.trim().isEmpty() || activeUsers.contains(username)) {
            return false;
        }
        activeUsers.add(username);
        return true;
    }

    public static synchronized void removeUser(String username) {
        activeUsers.remove(username);
    }
}