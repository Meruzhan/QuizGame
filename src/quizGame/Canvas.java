package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by levon on 6/8/16.
 */
public abstract class Canvas extends JPanel {
    protected ModeActivity changeMode = ModeActivity.START_PAGE;
    protected Image image;
    protected Frame frame;
    public Canvas(Frame frame ){
        setBackground(Color.blue);
        setVisible(true);
        this.frame=frame;

        addMouseListener(new MouseListener() {
                             @Override
                             public void mouseClicked(MouseEvent e) {

                                 mouseClickedPerformed(e);

                             }

                             @Override
                             public void mousePressed(MouseEvent e) {

                             }

                             @Override
                             public void mouseReleased(MouseEvent e) {

                             }

                             @Override
                             public void mouseEntered(MouseEvent e) {

                             }

                             @Override
                             public void mouseExited(MouseEvent e) {

                             }
                         }

        );



    }


    public   boolean isBelong(MouseEvent e, int x, int y, int width, int height) {
        return e.getX() > x && e.getY() > y &&
                e.getX() < x + width && e.getY() < y + height;
    }



    private void mouseClickedPerformed(MouseEvent e) {
        initButtons(e);
        startActivityButtonsClick();
        subjectItemsButtonClick();

    }

    protected abstract void initButtons(MouseEvent e);

    protected abstract void startActivityButtonsClick();

    protected abstract void subjectItemsButtonClick();

    protected void setChangeMode(ModeActivity mode){
        switch (mode){
            case START_PAGE:
                frame.setCanvas(new StartPageCanvas(frame));
                break;
            case SUBJECT_SELECT_PAGE:
                frame.setCanvas(new SubjectPageCanvas(frame));
                 break;
            case QUESTION_PAGE:
                break;
            case RESULT_PAGE:
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
