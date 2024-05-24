package com.bank.app.forms;

import com.bank.app.controllers.RegisterFrameController;
import com.toedter.calendar.JDateChooser;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RegisterFrame extends JFrame {

    private final String title = "Rejestracja";

    private JPanel registerPanel;
    private JTextField firstNameField;
    private JTextField secondNameField;
    private JTextField lastNameField;
    private JDateChooser birthField;
    private JPanel phoneNumberPanel;
    private JComboBox<String> countryCodes;
    private JTextField phoneNumberField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JCheckBox showPasswordCheckBox;
    private RegisterFrameController registerFrameController;

    public RegisterFrame(RegisterFrameController registerFrameController) {

        this.setTitle(title);
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(10, 1));
        add(registerPanel);

        registerPanel.add(new JLabel("Imię: "));
        firstNameField = new JTextField();
        registerPanel.add(firstNameField);

        registerPanel.add(new JLabel("Drugie Imię: "));
        secondNameField = new JTextField();
        registerPanel.add(secondNameField);

        registerPanel.add(new JLabel("Nazwisko: "));
        lastNameField = new JTextField();
        registerPanel.add(lastNameField);

        registerPanel.add(new JLabel("Data urodzenia: "));
        birthField = new JDateChooser();
        birthField.setDateFormatString("yyyy-MM-dd");
        registerPanel.add(birthField);

        phoneNumberPanel = new JPanel(new GridLayout(1, 1));
        registerPanel.add(new JLabel("Numer telefonu"));
        registerPanel.add(phoneNumberPanel);
        countryCodes = new JComboBox<>(new String[]{"+48", "+44"});
        phoneNumberPanel.add(countryCodes);
        phoneNumberField = new JTextField();
        phoneNumberPanel.add(phoneNumberField);

        registerPanel.add(new JLabel("Email: "));
        emailField = new JTextField();
        registerPanel.add(emailField);

        registerPanel.add(new JLabel("Hasło: "));
        passwordField = new JPasswordField();
        registerPanel.add(passwordField);

        registerPanel.add(new JLabel("Powtórz hasło: "));
        confirmPasswordField = new JPasswordField();
        registerPanel.add(confirmPasswordField);

        showPasswordCheckBox = new JCheckBox("Pokaż hasło");
        registerPanel.add(showPasswordCheckBox);
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                    confirmPasswordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                    confirmPasswordField.setEchoChar('*');
                }
            }
        });

        registerButton = new JButton("Zarejestruj się");
        registerPanel.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String secondName = secondNameField.getText();
                String lastName = lastNameField.getText();
                Date birthDate = birthField.getDate();
                String phoneNumber = countryCodes.getSelectedItem() + phoneNumberField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Hasła się nie zgadzają");
                    return;
                }
                registerFrameController.registerUser(firstName, secondName, lastName, birthDate, phoneNumber, email, password);
                JOptionPane.showMessageDialog(null, "Pomyślnie zarejestrowano użytkownika");
                dispose();
            }
        });


        this.setVisible(true);
    }
}
