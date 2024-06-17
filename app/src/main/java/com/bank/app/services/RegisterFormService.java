package com.bank.app.services;

import com.bank.app.models.User;
import com.bank.app.models.UserData;
import com.bank.app.repositories.UserDataRepository;
import com.bank.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.bank.app.utils.AppUtil.hash256;

@Service
public class RegisterFormService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    public String hashEmail(String email) {
        return hash256(email);
    }

    public String hashPassword(String password) {
        return hash256(password);
    }

    @Transactional
    public void registerUser(User user, UserData userData) {
        userRepository.save(user);
        userDataRepository.save(userData);
    }
}
