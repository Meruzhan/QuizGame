package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;

/**
 * Created by levon on 6/7/16.
 */
public class StartPageCanvas extends Canvas {


    private static final int LOGO_SIZE = 150;
    private static final int LOGO_NAME_HEIGHT = 80;
    private static final int LOGO_NAME_WIDTH = 400;
    private static final int START_ACTIVITY_BUTTON_HEIGHT = 50;
    private static final int START_ACTIVITY_BUTTON_WIDTH = 150;
    private static final int LOGO_X = 325;
    private static final int LOGO_Y = 220;
    private static final int LOGO_NAME_Y = 70;
    private static final int LOGO_NAME_X = 200;
    private static final int PLAY_BUTTON_Y = 450;
    private static final int PLAY_BUTTON_X = 200;
    private static final int EXIT_BUTTON_Y = 450;
    private static final int EXIT_BUTTON_X = 450;


    private boolean isPlayButtonClicked;
    private boolean isExitButtonClicked;





    //private ButtonClick buttonclicked= ButtonClick.PLAY_BUTTON;


    public StartPageCanvas(Frame frame) {
    super(frame);

    }




    private void startPage(Graphics g) {//draw logo name
            image = new ImageIcon(getClass().getResource("icons/logoName.png")).getImage();
            g.drawImage(image, LOGO_NAME_X, LOGO_NAME_Y, LOGO_NAME_WIDTH, LOGO_NAME_HEIGHT, null);

            //draw logo
            image = new ImageIcon(getClass().getResource("icons/logo.png")).getImage();
            g.drawImage(image, LOGO_X, LOGO_Y, LOGO_SIZE, LOGO_SIZE, null);

            //draw play button
            image = new ImageIcon(getClass().getResource("icons/playButton.png")).getImage();
            g.drawImage(image, PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT, null);

            //draw exit button
            image = new ImageIcon(getClass().getResource("icons/exitButton.png")).getImage();
            g.drawImage(image, EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT, null);
            g.drawRect(10, 10, 775, 555);

    }



    private void questionsPage(Graphics g) {

    }

    private void resultPage(Graphics g) {

    }






    @Override
    public void initButtons(MouseEvent e) {
        isPlayButtonClicked = isBelong(e, PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT);
        isExitButtonClicked = isBelong(e, EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT);
        }

    @Override
    public void startActivityButtonsClick() {
        if (isPlayButtonClicked && changeMode == ModeActivity.START_PAGE) {
            changeMode = ModeActivity.SUBJECT_SELECT_PAGE;
            setChangeMode(changeMode);

        } else if (isExitButtonClicked && changeMode == ModeActivity.START_PAGE) {
            System.exit(0);
        }
    }

    @Override
    public void subjectItemsButtonClick() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        startPage(g);


    }
}


//enum ButtonClick{
//    PLAY_BUTTON,
//    EXIT_BUTTON,
//    SUBJECT_1,
//    SUBJECT_2,
//    SUBJECT_3,
//    SUBJECT_4,
//    SUBJECT_5,
//    SUBJECT_6,
//    SUBJECT_7,
//    SUBJECT_8,
//    SUBJECT_9,
//    SUBJECT_10,
//
//}
//





