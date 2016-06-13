package quizGame;

import javax.swing.*;
import java.awt.*;

public class SubjectPageCanvas extends Canvas {
    private static final int SUBJECT_PAGE_TITLE_X = 200;
    private static final int SUBJECT_PAGE_TITLE_Y = 10;
    private static final int SUBJECT_PAGE_TITLE_WIDTH = 400;
    private static final int SUBJECT_PAGE_TITLE_HEIGHT = 60;

    private static final int FIRST_COLUMN_SUBJECT_X = 50;
    private static final int SECOND_COLUMN_SUBJECT_X = 450;
    private static final int SUBJECT_1_Y = 80;
    private static final int SUBJECT_2_Y = 180;
    private static final int SUBJECT_3_Y = 280;
    private static final int SUBJECT_4_Y = 380;
    private static final int SUBJECT_5_Y = 480;
    private static final int SUBJECT_WIDTH = 300;
    private static final int SUBJECT_HEIGHT = 80;


    private JButton math;
    private JButton physic;
    private JButton biology;
    private JButton chemistry;
    private JButton geography;
    private JButton sport;
    private JButton literature;
    private JButton history;
    private JButton informatics;
    private JButton secret;

    public SubjectPageCanvas(Frame frame) {
        super(frame);

        math = new JButton();
        physic = new JButton();
        history = new JButton();
        informatics = new JButton();
        biology = new JButton();
        chemistry = new JButton();
        literature = new JButton();
        secret = new JButton();
        sport = new JButton();
        geography = new JButton();

        math.setOpaque(false);
        physic.setOpaque(false);
        history.setOpaque(false);
        informatics.setOpaque(false);
        biology.setOpaque(false);
        chemistry.setOpaque(false);
        literature.setOpaque(false);
        secret.setOpaque(false);
        sport.setOpaque(false);
        geography.setOpaque(false);

        add(math);
        add(physic);
        add(history);
        add(informatics);
        add(biology);
        add(chemistry);
        add(literature);
        add(secret);
        add(sport);
        add(geography);

        physic.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        math.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        informatics.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        history.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        chemistry.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        literature.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        secret.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        sport.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        geography.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));
        biology.addActionListener(e -> setChangeMode(ModeActivity.QUESTION_PAGE));


    }

    @Override
    protected void setButtonBounds(Graphics g) {
        math.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        biology.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        chemistry.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        geography.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        history.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        informatics.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        literature.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        physic.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        sport.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        secret.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

    }


    private void drawSbjectSelectPage(Graphics g) { //draw subject items
        drawBackground(g);
        setButtonBounds(g);

        image = new ImageIcon(getClass().getResource("icons/theme.png")).getImage();
        g.drawImage(image, SUBJECT_PAGE_TITLE_X, SUBJECT_PAGE_TITLE_Y, SUBJECT_PAGE_TITLE_WIDTH, SUBJECT_PAGE_TITLE_HEIGHT, null);

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


        image = new ImageIcon(getClass().getResource("icons/inform.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/literature.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/physics.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/sport.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("icons/secret.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        g.drawRect(10, 10, 775, 555);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawSbjectSelectPage(g);
        System.out.println("hsd");
    }
}
