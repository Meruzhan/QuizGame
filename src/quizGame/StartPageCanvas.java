package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPageCanvas extends Canvas {


    private static final int LOGO_SIZE = 150;
    private static final int LOGO_NAME_HEIGHT = 80;
    private static final int LOGO_NAME_WIDTH = 400;
    private static final int START_ACTIVITY_BUTTON_HEIGHT = 50;
    private static final int START_ACTIVITY_BUTTON_WIDTH = 150;
    private static final int LOGO_X = 325;
    private static final int LOGO_Y = 220;
    private static final int MAIN_X=50;
    private static final int MAIN_Y=20;
    private static final int MAIN_WIDTH=700;
    private static final int MAIN_HEIGHT=200;
    private static final int LOGO_NAME_Y = 70;
    private static final int LOGO_NAME_X = 200;
    private static final int PLAY_BUTTON_Y = 450;
    private static final int PLAY_BUTTON_X = 200;
    private static final int EXIT_BUTTON_Y = 450;
    private static final int EXIT_BUTTON_X = 450;

    JButton playButton;
    JButton exitButton;



    public StartPageCanvas(Frame frame) {
        super(frame);
//        ImageIcon imageIcon= new ImageIcon(getClass().getResource("icons/butwood.png"));
        playButton = new JButton();
        exitButton = new JButton();
        exitButton.setOpaque(false);
        playButton.setOpaque(false);


//        playButton.setContentAreaFilled(false);

//        playButton.setBorderPainted(false);

        add(playButton);
        add(exitButton);

        exitButton.addActionListener(e ->  System.exit(0));
        playButton.addActionListener(e -> {JOptionPane.showInputDialog("Enter your name, please");setChangeMode(ModeActivity.SUBJECT_SELECT_PAGE);});

    }


    @Override
    protected  void setButtonBounds(Graphics g){
        playButton.setBounds(PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT - 10);
        exitButton.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT);

    }


    private void drawStartPage(Graphics g) {//draw logo name
drawBackground(g);

setButtonBounds(g);

        //draw main
        image = new ImageIcon(getClass().getResource("icons/main.png")).getImage();
        g.drawImage(image, MAIN_X, MAIN_Y, MAIN_WIDTH, MAIN_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/logo.png")).getImage();
        g.drawImage(image, LOGO_X, LOGO_Y, LOGO_SIZE, LOGO_SIZE, null);
        //draw play button
           image = new ImageIcon(getClass().getResource("icons/play.png")).getImage();
            g.drawImage(image, PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT, null);

        //draw exit button
        image = new ImageIcon(getClass().getResource("icons/exit.png")).getImage();
        g.drawImage(image, EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT, null);

        g.drawRect(10, 10, 775, 530);


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawStartPage(g);


    }
}

