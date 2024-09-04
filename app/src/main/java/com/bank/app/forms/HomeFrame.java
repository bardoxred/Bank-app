package com.bank.app.forms;

import com.bank.app.controllers.BlikFrameController;
import com.bank.app.controllers.HistoriaFrameController;
import com.bank.app.controllers.PrzelewFrameController;
import com.bank.app.utils.WindowProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {

    private final String title = "Strona Główna";

    private JPanel homePanel;
    private JPanel balancePanel;
    private JLabel accountBalance;
    private JTextField accountBalanceTextField;
    private JPanel actionPanel;
    private JButton blikButton;
    private JButton przelewButton;
    private JButton historiaButton;

    private BlikFrameController blikFrameController;
    private PrzelewFrameController przelewFrameController;
    private HistoriaFrameController historiaFrameController;
    private final LoginFrame loginFrame;


    public HomeFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;

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

        blikButton = new JButton("BLIK");
        blikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new BlikFrame(blikFrameController, HomeFrame.this).setVisible(true);
                    dispose();
                });
            }
        });

        przelewButton = new JButton("Przelew");
        przelewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new PrzelewFrame(przelewFrameController, HomeFrame.this).setVisible(true);
                    dispose();
                });
            }
        });

        historiaButton = new JButton("Historia");
        historiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new HistoriaFrame(historiaFrameController, HomeFrame.this).setVisible(true);
                    dispose();
                });
            }
        });

        actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Ustawienie panelu dla paska akcji
        actionPanel.add(blikButton);
        actionPanel.add(przelewButton);
        actionPanel.add(historiaButton);
        homePanel.add(actionPanel);

        this.add(homePanel);
    }

}