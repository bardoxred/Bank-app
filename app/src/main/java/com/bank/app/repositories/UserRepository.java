package com.bank.app.repositories;

import com.bank.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByHashedEmail(String hashedEmail);
}
