package ui;


/*
The full game panel you'll see here
 */

import model.GameShow;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private GameShow gameShow;
    private DoorPanel doorPanel;
    private TextPanel textPanel;
    private ButtonsPanel buttonsPanel;
    private JScrollPane scrollPane;
    private GraphPanel graphPanel;

    public MainGUI() {
        super("Monty Hall Simulation App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);

        gameShow = new GameShow();
        gameShow.setupStandardGameShow();
//        for (int i = 4; i < 15; i++) {
//            gameShow.addDoor(new Door(i, new Goat()));
//        }
        doorPanel = new DoorPanel(gameShow);
        textPanel = new TextPanel();
        buttonsPanel = new ButtonsPanel(gameShow);
        graphPanel = new GraphPanel(gameShow);

        doorPanel.setSidePanel(buttonsPanel);
        buttonsPanel.setDoorPanel(doorPanel);
        buttonsPanel.setGraphPanel(graphPanel);
        graphPanel.setButtonsPanel(buttonsPanel);

        scrollPane = new JScrollPane(doorPanel);
        scrollPane.setPreferredSize(new Dimension(800, 800));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);
        add(buttonsPanel, BorderLayout.SOUTH);
        add(graphPanel, BorderLayout.EAST);
        pack();
        centreOnScreen();
        setVisible(true);
    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }


    public static void main(String[] args) {
        new MainGUI();
    }


}

