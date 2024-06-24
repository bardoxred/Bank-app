package com.bank.app.services;

import com.bank.app.models.User;
import com.bank.app.models.UserData;
import com.bank.app.repositories.UserDataRepository;
import com.bank.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.bank.app.utils.AppUtil.hash256;

@Service
public class RegisterFormService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    private String errorPasswordMessage;

    public String hashEmail(String email) {
        return hash256(email);
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPasswordMessage() {
        return errorPasswordMessage;
    }

    public boolean registerUser(String firstName, String secondName, String lastName, Date birthDate, String phoneNumber, String email, String password, String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            errorPasswordMessage = "Hasła się nie zgadzają";
            return false;
        }
        String hashedEmail = hashEmail(email);
        String hashedPassword = hashPassword(password);

        if (isEmailTaken(email)) {
            return false;
        }

        User user = new User(hashedEmail, hashedPassword);
        UserData userData = new UserData(firstName, secondName, lastName, birthDate, phoneNumber, user);
        saveUser(user, userData);

        return true;
    }

    public boolean isEmailTaken(String email) {
        return false;
    }

    public void saveUser(User user, UserData userData) {
        userRepository.save(user);
        userDataRepository.save(userData);
    }
}
