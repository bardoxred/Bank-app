package com.bank.app.services;

import com.bank.app.models.User;
import com.bank.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import static com.bank.app.utils.AppUtil.hash256;

@Service
public class LoginFrameService {

    @Autowired
    private final UserRepository userRepository;

    public LoginFrameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isAutorized(String email, String password) {
        String hashedEmail = hash256(email);
        User user = userRepository.findByHashedEmail(hashedEmail);
        if (user != null && BCrypt.checkpw(password, user.getHashedPassword())) {
            System.out.println("Poprawnie znaleziono użytkownika");
            return true;
        } else {
            System.out.println("Nima");
            return false;
        }
    }
}