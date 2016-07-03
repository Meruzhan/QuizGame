package quizGame;

import javax.swing.*;
import java.awt.*;

abstract class Canvas extends JPanel {
    protected ModeActivity changeMode = ModeActivity.START_PAGE;
    Image image;
    Frame frame;
    static String userName;
    static int correctAnswersCount = 0;

    Canvas(Frame frame) {

        setSize(400, 400);
        setVisible(true);
        this.frame = frame;


    }

    protected void setChangeMode(ModeActivity mode) {
        switch (mode) {
            case START_PAGE:
                frame.setCanvas(new StartPageCanvas(frame));
                break;
            case SUBJECT_SELECT_PAGE:
                frame.setCanvas(new SubjectPageCanvas(frame));
                break;
            case QUESTION_PAGE:
                frame.setCanvas(new QuestionPageCanvas(frame, "secert"));
                break;
            case RESULT_PAGE:
                frame.setCanvas(new ResultPageCanvas(frame));
                break;
        }


    }

    void drawBackground(Graphics g) {
        Image bgImage = new ImageIcon(getClass().getResource("../icons/background.jpg")).getImage();
        g.drawImage(bgImage, 0, 0, 800, 600, null);
    }

    protected abstract void setButtonBounds(Graphics g);


    enum ModeActivity {
        START_PAGE,
        SUBJECT_SELECT_PAGE,
        QUESTION_PAGE,
        RESULT_PAGE
    }

}
