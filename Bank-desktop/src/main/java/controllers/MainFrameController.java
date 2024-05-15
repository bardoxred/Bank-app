package controllers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainFrameController {
    public String hash256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashArray = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashArray) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(hex);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Nie wykonano szyfrowania");
        }
    }
    public String hashEmail(String email){
        return hash256(email);
    }
    public String hashPassword(String password){
        return hash256(password);
    }
}
