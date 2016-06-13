package quizGame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by levon on 6/12/16.
 */
public class ResultPageCanvas extends Canvas {
    private static final int HEADER_CONTENT_X=100;
    private static final int HEADER_CONTENT_Y=1;
    private static final int HEADER_CONTENT_W=600;
    private static final int HEADER_CONTENT_H=100;

    private static final int BUTTONS_HEIGHT = 50;
    private static final int BUTTONS_WIDTH = 150;
    private static final int RESTART_BUTTON_Y = 450;
    private static final int RESTART_BUTTON_X = 200;
    private static final int QUIT_BUTTON_Y = 450;
    private static final int QUIT_BUTTON_X = 450;

    private static final int RESULT_AREA_X = 175;
    private static final int RESULT_AREA_Y = 150;
    private static final int RESULT_AREA_W = 450;
    private static final int RESULT_AREA_H = 200;

    private static final int SOCIAL_ICONS_X=10;
    private static final int TWITTER_Y=150;
    private static final int FACEBOOK_Y=210;
    private static final int GOOGLE_Y=270;
    private static final int SOCIAL_ICONS_W=50;
    private static final int SOCIAL_ICONS_H=50;


    private JButton restart;
    private JButton quit;

    private JButton twitter;
    private JButton facebook;
    private JButton google;


    public ResultPageCanvas(Frame frame) {
        super(frame);
        restart = new JButton();
        quit = new JButton();

        twitter= new JButton();
        facebook= new JButton();
        google= new JButton();

        restart.setOpaque(false);
        quit.setOpaque(false);
        twitter.setOpaque(false);
        facebook.setOpaque(false);
        google.setOpaque(false);

        add(restart);
        add(quit);
        add(twitter);
        add(google);
        add(facebook);

        restart.addActionListener(e -> setChangeMode(ModeActivity.SUBJECT_SELECT_PAGE));
        quit.addActionListener(e -> System.exit(0));
        twitter.addActionListener(e -> {try {
            Desktop.getDesktop().browse(new URL("https://twitter.com/").toURI());
        } catch (Exception ex) {}});
        facebook.addActionListener(e ->{try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/").toURI());
        } catch (Exception ex) {}});

        google.addActionListener(e -> {try {
            Desktop.getDesktop().browse(new URL("https://plus.google.com/").toURI());
        } catch (Exception ex) {}});
    }


    @Override
    protected void setButtonBounds(Graphics g) {
        restart.setBounds(RESTART_BUTTON_X, RESTART_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT);
        quit.setBounds(QUIT_BUTTON_X, QUIT_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT);
        twitter.setBounds(SOCIAL_ICONS_X,TWITTER_Y,SOCIAL_ICONS_W,SOCIAL_ICONS_H);
        facebook.setBounds(SOCIAL_ICONS_X,FACEBOOK_Y,SOCIAL_ICONS_W,SOCIAL_ICONS_H);
        google.setBounds(SOCIAL_ICONS_X,GOOGLE_Y,SOCIAL_ICONS_W,SOCIAL_ICONS_H);
    }

    private void drawResultPage(Graphics g) {
        drawBackground(g);
        setButtonBounds(g);

        image = new ImageIcon(getClass().getResource("icons/header.png")).getImage();
        g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);

        image = new ImageIcon(getClass().getResource("icons/questionArea.png")).getImage();
        g.drawImage(image, RESULT_AREA_X, RESULT_AREA_Y, RESULT_AREA_W, RESULT_AREA_H, null);

        image = new ImageIcon(getClass().getResource("icons/restart.png")).getImage();
        g.drawImage(image, RESTART_BUTTON_X, RESTART_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/quit.png")).getImage();
        g.drawImage(image,QUIT_BUTTON_X, QUIT_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT,null);

        image = new ImageIcon(getClass().getResource("icons/twitter.png")).getImage();
        g.drawImage(image, SOCIAL_ICONS_X,TWITTER_Y,SOCIAL_ICONS_W,SOCIAL_ICONS_H, null);

        image = new ImageIcon(getClass().getResource("icons/facebook.png")).getImage();
        g.drawImage(image, SOCIAL_ICONS_X,FACEBOOK_Y,SOCIAL_ICONS_W,SOCIAL_ICONS_H, null);

        image = new ImageIcon(getClass().getResource("icons/google.png")).getImage();
        g.drawImage(image, SOCIAL_ICONS_X,GOOGLE_Y,SOCIAL_ICONS_W,SOCIAL_ICONS_H, null);



    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawResultPage(g);
        System.out.println("hellllo");
    }
}
