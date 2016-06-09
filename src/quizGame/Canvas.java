package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by levon on 6/8/16.
 */
public abstract class Canvas extends JPanel {

    Canvas canvas1= new StartPageCanvas();
    Canvas canvas4= new SubjectPageCanvas();
    Canvas canvas2= new QuestionPageCanvas();
    Canvas canvas3= new ResultPageCanvas();

    protected ModeActivity changeMode = ModeActivity.START_PAGE;
    protected Image image;
    protected Frame frame;

    public Canvas() {
        setBackground(Color.blue);
        setVisible(true);


    }


    public void setChangeMode() {
        switch (changeMode) {
            case START_PAGE:
                canvas1.paint(getGraphics());
                break;
            case SUBJECT_SELECT_PAGE:
                canvas2.paint(getGraphics());
                break;

            case QUESTION_PAGE:
                canvas3.paint(getGraphics());
                break;

            case RESULT_PAGE:
                canvas4.paint(getGraphics());
                break;
        }
    }


    enum ModeActivity {
        START_PAGE,
        SUBJECT_SELECT_PAGE,
        QUESTION_PAGE,
        RESULT_PAGE
    }

}
