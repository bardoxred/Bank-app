package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final String title = "Bank Application";
    private JTextField emailField;
    private JTextField passwordField;
    private JPanel mainPanel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton loginButton;

    public MainFrame() {
        this.setTitle(title); // tytuł
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y); // wielkość okna
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wyjscie po wyłączeniu
        this.setVisible(true);  // wyświetlanie okienka
        this.setLocationRelativeTo(null); // ustawienie okna na środku

        // Panel główny
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        add(mainPanel);

        emailLabel = new JLabel("Wpisz adres email:");
        emailField = new JTextField();
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);

        passwordLabel = new JLabel("Hasło:");
        passwordField = new JTextField();
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);

        loginButton = new JButton("Zaloguj się");
        mainPanel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailAdress = emailField.getText();
                String passwordAdress = passwordField.getText();

                System.out.println(emailAdress);
                System.out.println(passwordAdress);

                new HomeFrame();
                dispose();

            }
        });
    }
}