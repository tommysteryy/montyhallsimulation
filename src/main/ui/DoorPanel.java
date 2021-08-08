package ui;

import model.Door;
import model.GameShow;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/*
A panel where all doors are displayed. Can be 3 doors (standard) but can also be an arbitrary number

Door img: http://clipart-library.com/clip-art/41-415526_door-png-download-png-image-with-transparent-background.htm
 */

public class DoorPanel extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1500;
    private static final int DOORHEIGHT = 175;
    private static final int DOORWIDTH = 100;
    private static final int DOOR_START_XPOS = 90;
    private static final int DOOR_START_YPOS = 90;
    private GameShow gameshow;
    private ButtonsPanel buttonsPanel;

//    private List<JLabel> doorImages;
//    private JLabel testDoorImage;
//    private ImageIcon doorIcon;
//    private JScrollPane scrollPane;

    public DoorPanel(GameShow gameshow) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.gray);
        setLayout(null);
        this.gameshow = gameshow;

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        testDoorImage = new JLabel();
//        doorIcon = new ImageIcon("src/main/ui/doorfinal.png");
//        testDoorImage.setIcon(doorIcon);
//        testDoorImage.setBounds(90,90,71, 96);
//        add(testDoorImage);
//        placeAllDoors();

        drawDoors(g);
//        drawRectangles(g);
//        drawGraph(g, new Float(0.5), new Float(0.9));
    }

    private void drawGraph(Graphics g, Float switchWinProbability, Float dontSwitchWinProbability) {
        g.drawRect(630, 90, 50, (int) (switchWinProbability * 100));
        g.fillRect(630, 90, 50, (int) (switchWinProbability * 100));
        g.drawRect(700, 90, 50, (int) (dontSwitchWinProbability * 100));
        g.fillRect(700, 90, 50, (int) (dontSwitchWinProbability * 100));
        g.setColor(Color.green);

    }


//    public void drawRectangles(Graphics g) {
//        int numberOfRectangles = gameshow.getSize() - 1;
//        for (int i = 0; i < numberOfRectangles; i++) {
//
//            JPanel panel = new JPanel(); //create a panel
//            panel.setPreferredSize(new Dimension(DOORWIDTH, DOORHEIGHT)); //size it
//            if ((i % 2) == 0) { //color it
//                Door doorToDraw = gameshow.find((i + 1) / 2);
//                doorToDraw.draw(g);
//            } else {
//                panel.setBackground(Color.BLACK);
//            }
//
//            add(panel);//add it
//
//
//        }
//    }

    public void drawDoors(Graphics g) {
//        for (Door d: gameshow.getDoors()) {
//            drawDoor(g, d)
//            add(Box.createHorizontalStrut(50));
//        }
        int separation = 180;
        int numFullRows = gameshow.getSize() / 4;


        for (int i = 0; i < numFullRows; i++) {
            List<Door> doorsToDraw = gameshow.getDoors().subList((i * 4), ((i + 1) * 4));
            drawSubListOfDoors(doorsToDraw, g, i * 250 + 90);
        }

        int numberOfLeftoverDoors = gameshow.getSize() % 4;
        List<Door> doorsLeftoverToDraw = gameshow.getDoors().subList(gameshow.getSize() - numberOfLeftoverDoors,
                gameshow.getSize());
        drawSubListOfDoors(doorsLeftoverToDraw, g, numFullRows * 250 + 90);

    }

    private void drawSubListOfDoors(List<Door> doorsToDraw, Graphics g, int ypos) {
        for (int i = 0; i < (doorsToDraw.size()); i++) {
            Door doorToDraw = doorsToDraw.get(i);
            drawDoor(g, doorToDraw, 90 + i * 180, ypos);
        }
    }

    private void drawDoor(Graphics g, Door d, int xpos, int ypos) {
        g.drawRect(xpos, ypos, DOORWIDTH, DOORHEIGHT);
        g.fillRect(xpos, ypos, DOORWIDTH, DOORHEIGHT);
        if (d.prizeIsGoat()) {
            g.setColor(new Color(176, 129, 89));

//            g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
//            g.drawString("Goat",(topLeftCoordinate + DOORWIDTH) / 2, (90 + DOORHEIGHT) / 2);
        } else {
            g.setColor(Color.cyan);
        }


    }

//    public void placeAllDoors() {
////        for (Door d: gameshow.getDoors()) {
////            drawDoor(g, d)
////            add(Box.createHorizontalStrut(50));
////        }
//        int separation = 180;
//        int numFullRows = gameshow.getSize() / 4;
//
//
//        for (int i = 0; i < numFullRows; i++) {
//            List<Door> doorsToDraw = gameshow.getDoors().subList((i * 4), ((i + 1) * 4));
//            placeSubListOfDoors(doorsToDraw, i * 250 + 90);
//        }
//
//        int numberOfLeftoverDoors = gameshow.getSize() % 4;
//        List<Door> doorsLeftoverToDraw = gameshow.getDoors().subList(gameshow.getSize() - numberOfLeftoverDoors,
//                gameshow.getSize());
//        placeSubListOfDoors(doorsLeftoverToDraw, numFullRows * 250 + 90);
//
//    }
//
//    private void placeSubListOfDoors(List<Door> doorsToDraw, int ypos) {
//        for (int i = 0; i < (doorsToDraw.size()); i++) {
//            Door doorToDraw = doorsToDraw.get(i);
//            placeDoor(doorToDraw, 90 + i * 180, ypos);
//        }
//    }
//
//
//    private void placeDoor(Door d, int xpos, int ypos) {
//
//        testDoorImage = new JLabel();
//        doorIcon = new ImageIcon("src/main/ui/doorfinal.png");
//        testDoorImage.setIcon(doorIcon);
//        testDoorImage.setBounds(xpos, ypos, 71, 96);
//        add(testDoorImage);
//
//        if (d.prizeIsGoat()) {
//            Border border = BorderFactory.createLineBorder(Color.green);
//            testDoorImage.setBorder(border);
//        } else {
//            Border border = BorderFactory.createLineBorder(Color.cyan);
//            testDoorImage.setBorder(border);
//        }
//
//
//    }

    public void setSidePanel(ButtonsPanel buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public void showProbabilityResults(Float switchWinProbability, Float dontSwitchWinProbability) {

    }
}

