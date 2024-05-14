package forms;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    private final String title = "Bank Application - Home Screen";

    private JPanel homePanel;
    private JPanel balancePanel;
    private JLabel accountBalance;
    private JTextField accountBalanceTextField;
    private JPanel actionPanel;
    private JButton blik;
    private JButton moneyTransfer;
    private JButton history;


    public HomeFrame() {

        this.setTitle(title); // Tytuł
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y); // wielkość okna
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wyjście po wyłaczneiu
        this.setVisible(true); // wyświatlanie okienka
        this.setLocationRelativeTo(null); // ustawienie okna na środku

        // Panel Główny
        homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        balancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Ustawienie panelu z stanem konta

        // PAnel
        accountBalance = new JLabel("Stan konta:");
        accountBalanceTextField = new JTextField();
        accountBalanceTextField.setText("12345678901234567890"); // nadanie wartości stanu konta (TEMP)
        accountBalanceTextField.setFont(new Font("Consolas", Font.BOLD, 35)); // nadalnie czcionki dla wartości stanu konta
        accountBalanceTextField.setEditable(false);
        balancePanel.add(accountBalance);
        balancePanel.add(accountBalanceTextField);
        homePanel.add(balancePanel, BorderLayout.NORTH);

        blik = new JButton("BLIK");
        moneyTransfer = new JButton("Przelew");
        history = new JButton("Historia");

        actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Ustawienie panelu dla paska akcji
        actionPanel.add(blik);
        actionPanel.add(moneyTransfer);
        actionPanel.add(history);
        homePanel.add(actionPanel);

        this.add(homePanel);
    }

}
