package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by levon on 6/8/16.
 */
public class SubjectPageCanvas extends Canvas {
    private boolean isSubject_1_ButtonClicked;
    private boolean isSubject_2_ButtonClicked;
    private boolean isSubject_3_ButtonClicked;
    private boolean isSubject_4_ButtonClicked;
    private boolean isSubject_5_ButtonClicked;
    private boolean isSubject_6_ButtonClicked;
    private boolean isSubject_7_ButtonClicked;
    private boolean isSubject_8_ButtonClicked;
    private boolean isSubject_9_ButtonClicked;
    private boolean isSubject_10_ButtonClicked;

    private static final int SUBJECT_PAGE_TITLE_X=100;
    private static final int SUBJECT_PAGE_TITLE_Y=10;
    private static final int SUBJECT_PAGE_TITLE_WIDTH=600;
    private static final int SUBJECT_PAGE_TITLE_HEIGHT=50;

    private static final int FIRST_COLUMN_SUBJECT_X = 50;
    private static final int SECOND_COLUMN_SUBJECT_X = 450;
    private static final int SUBJECT_1_Y = 80;
    private static final int SUBJECT_2_Y = 180;
    private static final int SUBJECT_3_Y = 280;
    private static final int SUBJECT_4_Y = 380;
    private static final int SUBJECT_5_Y = 480;
    private static final int SUBJECT_WIDTH = 300;
    private static final int SUBJECT_HEIGHT = 80;

    public SubjectPageCanvas(Frame frame) {
        super(frame);

    }


    @Override
    protected void initButtons(MouseEvent e) {
        isSubject_1_ButtonClicked = isBelong(e, FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_2_ButtonClicked = isBelong(e, FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_3_ButtonClicked = isBelong(e, FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_4_ButtonClicked = isBelong(e, FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_5_ButtonClicked = isBelong(e, FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_6_ButtonClicked = isBelong(e, SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_7_ButtonClicked = isBelong(e, SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_8_ButtonClicked = isBelong(e, SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_9_ButtonClicked = isBelong(e, SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        isSubject_10_ButtonClicked = isBelong(e, SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
    }

    @Override
    protected void startActivityButtonsClick() {


    }

    @Override
    protected void subjectItemsButtonClick() {
        if (isSubject_1_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_2_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_3_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_4_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_5_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_6_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_7_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_8_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_9_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        } else if (isSubject_10_ButtonClicked && changeMode == ModeActivity.SUBJECT_SELECT_PAGE) {
            changeMode = ModeActivity.QUESTION_PAGE;
            setChangeMode(changeMode);
        }

    }


    private void subjectSelectPage(Graphics g) { //draw subject items

        image= new ImageIcon(getClass().getResource("icons/subject.png")).getImage();
        g.drawImage(image,SUBJECT_PAGE_TITLE_X,SUBJECT_PAGE_TITLE_Y,SUBJECT_PAGE_TITLE_WIDTH,SUBJECT_PAGE_TITLE_HEIGHT,null);

        image = new ImageIcon(getClass().getResource("icons/math.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/biology.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/chemistry.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/geography.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/history.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/Informatics.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/literature.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/physics.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/artHistory.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/secret.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        g.drawRect(10, 10, 775, 555);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        subjectSelectPage(g);
        System.out.println("hsd");
    }
}
