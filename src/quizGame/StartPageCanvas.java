package quizGame;

import sun.audio.AudioPlayer;

import javax.swing.*;
import java.awt.*;

import static quizGame.Frame.audioStream;
import static quizGame.Frame.music;

public class StartPageCanvas extends Canvas {


    private static final int LOGO_SIZE = 150;
    private static final int LOGO_NAME_HEIGHT = 80;
    private static final int LOGO_NAME_WIDTH = 400;
    private static final int START_ACTIVITY_BUTTON_HEIGHT = 50;
    private static final int START_ACTIVITY_BUTTON_WIDTH = 150;
    private static final int LOGO_X = 325;
    private static final int LOGO_Y = 220;
    private static final int MAIN_X = 50;
    private static final int MAIN_Y = 20;
    private static final int MAIN_WIDTH = 700;
    private static final int MAIN_HEIGHT = 200;
    private static final int LOGO_NAME_Y = 70;
    private static final int LOGO_NAME_X = 200;
    private static final int PLAY_BUTTON_Y = 450;
    private static final int PLAY_BUTTON_X = 200;
    private static final int EXIT_BUTTON_Y = 450;
    private static final int EXIT_BUTTON_X = 450;

    private JButton playButton;
    private JButton exitButton;
    private JButton muteButton;


    public StartPageCanvas(Frame frame) {
        super(frame);
        playButton = new JButton();
        exitButton = new JButton();
        muteButton = new JButton();
        exitButton.setOpaque(false);
        playButton.setOpaque(false);
        muteButton.setOpaque(false);


        add(playButton);
        add(exitButton);
        add(muteButton);
        muteButton.addActionListener(e -> AudioPlayer.player.stop(audioStream));
        exitButton.addActionListener(e -> System.exit(0));
        playButton.addActionListener(e -> {
            music();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new Color(0xA46611));
            UI.put("Panel.background", new Color(0xA46611));

            userName = JOptionPane.showInputDialog(this, "Enter your name, please", "Player", JOptionPane.PLAIN_MESSAGE);
            if (userName.equals("")) {
                userName = "Player";
            }
            setChangeMode(ModeActivity.SUBJECT_SELECT_PAGE);
        });

    }


    @Override
    protected void setButtonBounds(Graphics g) {
        playButton.setBounds(PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT - 10);
        exitButton.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT);
        muteButton.setBounds(10, 300, 30, 30);

    }


    private void drawStartPage(Graphics g) {//draw logo name
        drawBackground(g);

        setButtonBounds(g);

        //draw main
        image = new ImageIcon(getClass().getResource("../icons/main.png")).getImage();
        g.drawImage(image, MAIN_X, MAIN_Y, MAIN_WIDTH, MAIN_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("../icons/logo.png")).getImage();
        g.drawImage(image, LOGO_X, LOGO_Y, LOGO_SIZE, LOGO_SIZE, null);
        //draw play button
        image = new ImageIcon(getClass().getResource("../icons/play.png")).getImage();
        g.drawImage(image, PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("../icons/sound-off.png")).getImage();
        g.drawImage(image, 15, 300, 30, 30, null);


        //draw exit button
        image = new ImageIcon(getClass().getResource("../icons/exit.png")).getImage();
        g.drawImage(image, EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT, null);

        g.drawRect(10, 10, 775, 580);


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawStartPage(g);


    }
}

