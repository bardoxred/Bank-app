package forms;

import controllers.MainFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final String title = "Bank Application";
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JPanel mainPanel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private MainFrameController mainFrameController = new MainFrameController();

    public MainFrame() {
        this.setTitle(title); // tytuł
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y); // wielkość okna
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wyjscie po wyłączeniu
        this.setVisible(true);  // wyświetlanie okienka
        this.setLocationRelativeTo(null); // ustawienie okna na środku

        // Panel główny
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));
        add(mainPanel);

        emailLabel = new JLabel("Wpisz adres email:");
        emailField = new JTextField();
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);

        passwordLabel = new JLabel("Hasło:");
        passwordField = new JPasswordField();
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);

        showPasswordCheckBox = new JCheckBox("Pokaż hasło");
        mainPanel.add(showPasswordCheckBox);
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        loginButton = new JButton("Zaloguj się");
        mainPanel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailAdress = emailField.getText();
                String passwordAdress = passwordField.getText();

                System.out.println(emailAdress);
                System.out.println(passwordAdress);

                String hashedEmail = mainFrameController.hashEmail(emailAdress);
                String hashedPassword = mainFrameController.hashPassword(passwordAdress);
                // To do poprawić szyfrowanie i dodac komentarze
                System.out.println();
                System.out.println(hashedEmail);
                System.out.println(hashedPassword);

                new HomeFrame();
                dispose();

            }
        });
    }
}