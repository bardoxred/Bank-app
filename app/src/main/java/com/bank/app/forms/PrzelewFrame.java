package com.bank.app.forms;

import com.bank.app.controllers.PrzelewFrameController;
import com.bank.app.utils.WindowProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzelewFrame extends JFrame {

    private JPanel przelewPanel;
    private JButton cofnijButton;
    private LoginFrame loginFrame;
    private final PrzelewFrameController przelewFrameController;
    private final HomeFrame homeFrame;

    public PrzelewFrame(PrzelewFrameController przelewFrameController, HomeFrame homeFrame) {
        this.przelewFrameController = przelewFrameController;
        this.homeFrame = homeFrame;

        this.setTitle("Przelew");
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        przelewPanel = new JPanel();
        przelewPanel.setLayout(new GridLayout(1, 1));
        add(przelewPanel);

        cofnijButton = new JButton("Cofnij");
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new HomeFrame(loginFrame).setVisible(true);
                    dispose();
                });
            }
        });
        przelewPanel.add(cofnijButton);

        this.setVisible(true);
    }
}
