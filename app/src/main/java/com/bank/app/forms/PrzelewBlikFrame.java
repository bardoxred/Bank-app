package com.bank.app.forms;

import com.bank.app.controllers.PrzelewBlikFrameController;
import com.bank.app.utils.WindowProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzelewBlikFrame extends JFrame {

    private JPanel przelewBlikPanel;
    private JPanel przyciskiPanel;
    private JTextField stanKontaTextField;
    private JTextField przelewDoTextField;
    private JTextField kwotaPrzelewuTextField;
    private JButton anulujPrzelewButton;
    private JButton zlecPrzelewButton;
    private final PrzelewBlikFrameController przelewBlikFrameController;
    private final BlikFrame blikFrame;

    public PrzelewBlikFrame(PrzelewBlikFrameController przelewBlikFrameController, BlikFrame blikFrame) {

        this.przelewBlikFrameController = przelewBlikFrameController;
        this.blikFrame = blikFrame;

        this.setTitle("Przelew BLIK na telefon");
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        przelewBlikPanel = new JPanel();
        przelewBlikPanel.setLayout(new GridLayout(4, 1));
        add(przelewBlikPanel);

        przelewBlikPanel.add(new JLabel("Stan Konta: "));
        stanKontaTextField = new JTextField();
        stanKontaTextField.setText("12345678901234567890");
        stanKontaTextField.setFont(new Font("Consolas", Font.BOLD, 35));
        stanKontaTextField.setEditable(false);
        przelewBlikPanel.add(stanKontaTextField);

        przelewBlikPanel.add(new JLabel("Przelew do / nr tel."));
        przelewDoTextField = new JTextField();
        przelewBlikPanel.add(przelewDoTextField);

        przelewBlikPanel.add(new JLabel("Kwota przelewu"));
        kwotaPrzelewuTextField = new JTextField();
        przelewBlikPanel.add(kwotaPrzelewuTextField);

        przyciskiPanel = new JPanel();
        przyciskiPanel.setLayout(new GridLayout(1, 2));

        anulujPrzelewButton = new JButton("Anuluj");
        anulujPrzelewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    blikFrame.setEnabled(true);
                    dispose();
                });
            }
        });
        przyciskiPanel.add(anulujPrzelewButton);

        zlecPrzelewButton = new JButton("Zleć przelew");
        przyciskiPanel.add(zlecPrzelewButton);

        przelewBlikPanel.add(przyciskiPanel);

        this.setVisible(true);
    }
}
