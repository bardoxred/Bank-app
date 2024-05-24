package com.bank.app.services;

import com.bank.app.models.User;
import com.bank.app.models.UserData;
import com.bank.app.repositories.UserDataRepository;
import com.bank.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class RegisterFormService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;

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

    public String hashEmail(String email) {
        return hash256(email);
    }

    public String hashPassword(String password) {
        return hash256(password);
    }

    @Transactional
    public void registerUser(User user, UserData userData) {
        user = userRepository.save(user);
        userData.setUser(user);
        userDataRepository.save(userData);
    }
}
