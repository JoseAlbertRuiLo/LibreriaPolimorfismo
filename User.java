package libreria;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User {
    private Profile profile;
    private String username;
    private String hashedPassword;

    public User(Profile profile, String username, String password) {
        this.profile = profile;
        this.username = username;
        setPassword(password);
    }

    public Profile getProfile() {
        return profile;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.hashedPassword.equals(hashPassword(password));
    }

    protected void setPassword(String password) {
        this.hashedPassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al aplicar SHA-256", e);
        }
    }
}

