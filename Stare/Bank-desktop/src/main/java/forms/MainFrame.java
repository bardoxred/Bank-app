package forms;

import controller.MainFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MainFrame extends JFrame {

    private final String title = "Bank Application";
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JPanel mainPanel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private final MainFrameController mainFrameController;

    @Autowired
    public MainFrame(MainFrameController mainFrameController) {
        this.mainFrameController = mainFrameController;

        this.setTitle(title);
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

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
                String password = new String(passwordField.getPassword());
                System.out.println(emailAdress);
                System.out.println(password);

                mainFrameController.login(emailAdress, password);

                new HomeFrame();
                dispose();
            }
        });
    }
}