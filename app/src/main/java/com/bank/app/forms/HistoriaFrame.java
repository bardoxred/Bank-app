package com.bank.app.forms;

import com.bank.app.controllers.HistoriaFrameController;
import com.bank.app.utils.WindowProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoriaFrame extends JFrame {

    private JPanel historiaPanel;
    private JButton cofnijButton;
    private LoginFrame loginFrame;
    private final HistoriaFrameController historiaFrameController;
    private final HomeFrame homeFrame;

    public HistoriaFrame(HistoriaFrameController historiaFrameController, HomeFrame homeFrame) {
        this.historiaFrameController = historiaFrameController;
        this.homeFrame = homeFrame;

        this.setTitle("Historia");
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        historiaPanel = new JPanel();
        historiaPanel.setLayout(new GridLayout(1, 1));
        add(historiaPanel);

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
        historiaPanel.add(cofnijButton);

        this.setVisible(true);
    }
}
