package com.bank.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users_data", schema = "bank_app")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userData_id")
    private Long userDataId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public UserData(String firstName, String secondName, String lastName, Date birth, String phoneNumber, User user) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

}
