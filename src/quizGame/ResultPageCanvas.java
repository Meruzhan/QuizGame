package quizGame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static quizGame.Frame.music;
import static quizGame.QuestionPageCanvas.currentTime;
import static quizGame.QuestionPageCanvas.getSpendTime;
import static quizGame.QuestionPageCanvas.time;
import static quizGame.SubjectPageCanvas.timeLimit;

/**
 * Created by levon on 6/12/16.
 */
public class ResultPageCanvas extends Canvas {
    private static final int HEADER_CONTENT_X = 100;
    private static final int HEADER_CONTENT_Y = 1;
    private static final int HEADER_CONTENT_W = 600;
    private static final int HEADER_CONTENT_H = 100;


    private static final int TIME_IS_OUT_X = 270;
    private static final int TIME_IS_OUT_Y = 150;
    private static final int TIME_IS_OUT_W = 250;
    private static final int TIME_IS_OUT_H = 50;


    private static final int BUTTONS_HEIGHT = 50;
    private static final int BUTTONS_WIDTH = 150;
    private static final int RESTART_BUTTON_Y = 450;
    private static final int RESTART_BUTTON_X = 200;
    private static final int QUIT_BUTTON_Y = 450;
    private static final int QUIT_BUTTON_X = 450;

    private static final int RESULT_AREA_X = 175;
    private static final int RESULT_AREA_Y = 200;
    private static final int RESULT_AREA_W = 450;
    private static final int RESULT_AREA_H = 200;

    private static final int SOCIAL_ICONS_X = 10;
    private static final int TWITTER_Y = 150;
    private static final int FACEBOOK_Y = 210;
    private static final int GOOGLE_Y = 270;
    private static final int SOCIAL_ICONS_W = 50;
    private static final int SOCIAL_ICONS_H = 50;


    private JButton restart;
    private JButton quit;

    private JButton twitter;
    private JButton facebook;
    private JButton google;

    private String resultMessage;
    int currentQuestionNumber;

    public ResultPageCanvas(Frame frame) {
        super(frame);
        restart = new JButton();
        quit = new JButton();

        twitter = new JButton();
        facebook = new JButton();
        google = new JButton();

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

        restart.addActionListener(e -> {
            setChangeMode(ModeActivity.SUBJECT_SELECT_PAGE);
            correctAnswersCount = 0;
            music();
        });
        quit.addActionListener(e -> {
            music();
            System.exit(0);

        });
        twitter.addActionListener(e -> {
            music();
            try {
                Desktop.getDesktop().browse(new URL("https://twitter.com/").toURI());
            } catch (Exception ex) {
            }
        });
        facebook.addActionListener(e -> {
            music();
            try {
                Desktop.getDesktop().browse(new URL("https://www.facebook.com/").toURI());
            } catch (Exception ex) {
            }
        });

        google.addActionListener(e -> {
            music();
            try {
                Desktop.getDesktop().browse(new URL("https://plus.google.com/").toURI());
            } catch (Exception ex) {
            }
        });
    }

    private void getResultMessage(Graphics g) {
        if (correctAnswersCount < 3) {
            image = new ImageIcon(getClass().getResource("../icons/badT.png")).getImage();
            g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);
        } else if (correctAnswersCount < 5) {
            image = new ImageIcon(getClass().getResource("../icons/notGoodT.png")).getImage();
            g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);

        } else if (correctAnswersCount < 9) {
            image = new ImageIcon(getClass().getResource("../icons/goodT.png")).getImage();
            g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);

        } else {
            image = new ImageIcon(getClass().getResource("../icons/excellentT.png")).getImage();
            g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);
        }
    }


    void setCurrentQuestionNumber(int number) {
        currentQuestionNumber = number;
    }


    @Override
    protected void setButtonBounds(Graphics g) {
        restart.setBounds(RESTART_BUTTON_X, RESTART_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT);
        quit.setBounds(QUIT_BUTTON_X, QUIT_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT);
        twitter.setBounds(SOCIAL_ICONS_X, TWITTER_Y, SOCIAL_ICONS_W, SOCIAL_ICONS_H);
        facebook.setBounds(SOCIAL_ICONS_X, FACEBOOK_Y, SOCIAL_ICONS_W, SOCIAL_ICONS_H);
        google.setBounds(SOCIAL_ICONS_X, GOOGLE_Y, SOCIAL_ICONS_W, SOCIAL_ICONS_H);
    }

    private void drawResultPage(Graphics g) {
        drawBackground(g);
        setButtonBounds(g);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        if (currentTime < 0) {

            image = new ImageIcon(getClass().getResource("../icons/timeisout.png")).getImage();
            g.drawImage(image, TIME_IS_OUT_X, TIME_IS_OUT_Y, TIME_IS_OUT_W, TIME_IS_OUT_H, null);

        }

        image = new ImageIcon(getClass().getResource("../icons/header.png")).getImage();
        String checkResult = "";
        getResultMessage(g);
        image = new ImageIcon(getClass().getResource("../icons/questionArea.png")).getImage();
        g.drawImage(image, RESULT_AREA_X, RESULT_AREA_Y, RESULT_AREA_W, RESULT_AREA_H, null);
        g.setColor(new Color(0x611400));
        g.drawString(userName, RESULT_AREA_X + 150, RESULT_AREA_Y + 70);
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        if ((checkResult = checkTime()).equals("GAME OVER")) {
            g.drawString(checkResult, RESULT_AREA_X + 120, RESULT_AREA_Y + 110);
        } else {
            g.drawString("you have " + correctAnswersCount + " right", RESULT_AREA_X + 60, RESULT_AREA_Y + 110);
            g.drawString("answers at " + checkTime() + " second", RESULT_AREA_X + 60, RESULT_AREA_Y + 150);
        }
        image = new ImageIcon(getClass().getResource("../icons/restart.png")).getImage();
        g.drawImage(image, RESTART_BUTTON_X, RESTART_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("../icons/quit.png")).getImage();
        g.drawImage(image, QUIT_BUTTON_X, QUIT_BUTTON_Y, BUTTONS_WIDTH, BUTTONS_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("../icons/twitter.png")).getImage();
        g.drawImage(image, SOCIAL_ICONS_X, TWITTER_Y, SOCIAL_ICONS_W, SOCIAL_ICONS_H, null);

        image = new ImageIcon(getClass().getResource("../icons/facebook.png")).getImage();
        g.drawImage(image, SOCIAL_ICONS_X, FACEBOOK_Y, SOCIAL_ICONS_W, SOCIAL_ICONS_H, null);

        image = new ImageIcon(getClass().getResource("../icons/google.png")).getImage();
        g.drawImage(image, SOCIAL_ICONS_X, GOOGLE_Y, SOCIAL_ICONS_W, SOCIAL_ICONS_H, null);


    }

//    private int checkTime() {
//        if (currentTime == 0) {
//            return time;
//        }
//
//        return getSpendTime();
//
//    }

    private String checkTime() {
        if (currentQuestionNumber < 10 && currentTime == -1) {
            return "GAME OVER";
        } else if (currentQuestionNumber == 10 && currentTime > 0) {
            return Integer.toString(getSpendTime());
        }
        return "";
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawResultPage(g);
    }
}
