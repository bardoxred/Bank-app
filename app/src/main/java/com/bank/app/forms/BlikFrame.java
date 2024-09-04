package com.bank.app.forms;

import com.bank.app.controllers.BlikFrameController;
import com.bank.app.controllers.PrzelewBlikFrameController;
import com.bank.app.utils.WindowProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlikFrame extends JFrame {

    private JButton przelewBlikButton;
    private JButton cofnijButton;
    private JButton skopiujKodButton;
    private JPanel generowanieKoduBlikPanel;
    private JPanel blikPanel;
    private final BlikFrameController blikFrameController;
    private final HomeFrame homeFrame;
    private PrzelewBlikFrame przelewBlikFrame;
    private PrzelewBlikFrameController przelewBlikFrameController;
    private LoginFrame loginFrame;

    public BlikFrame(BlikFrameController blikFrameController,
                     HomeFrame homeFrame) {

        this.blikFrameController = blikFrameController;
        this.homeFrame = homeFrame;

        this.setTitle("BLIK");
        this.setSize(WindowProperties.SIZE_X, WindowProperties.SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        blikPanel = new JPanel();
        blikPanel.setLayout(new GridLayout(4, 1));
        add(blikPanel);

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

        generowanieKoduBlikPanel = new JPanel();
        generowanieKoduBlikPanel.setLayout(new GridLayout(2, 1));

        skopiujKodButton = new JButton("Skopiuj kod");

        przelewBlikButton = new JButton("Przelew BLIK na tel.");
        przelewBlikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new PrzelewBlikFrame(przelewBlikFrameController, BlikFrame.this).setVisible(true);
                    setEnabled(false);
                });
            }
        });

        blikPanel.add(cofnijButton);
        blikPanel.add(generowanieKoduBlikPanel);
        blikPanel.add(skopiujKodButton);
        blikPanel.add(przelewBlikButton);

        this.setVisible(true);
    }
}
