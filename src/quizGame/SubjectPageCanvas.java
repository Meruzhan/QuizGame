package quizGame;

import javax.swing.*;
import java.awt.*;

import static quizGame.Frame.music;
import static quizGame.QuestionPageCanvas.setCurrentTime;
import static quizGame.QuestionPageCanvas.time;

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
    private JButton anatomy;
    private JButton chemistry;
    private JButton geography;
    private JButton sport;
    private JButton literature;
    private JButton history;
    private JButton art;
    private JButton movies;
    private String subjectName;
    static int order;
    static String timeLimit;


    public SubjectPageCanvas(Frame frame) {
        super(frame);

        math = new JButton();
        physic = new JButton();
        history = new JButton();
        art = new JButton();
        anatomy = new JButton();
        chemistry = new JButton();
        literature = new JButton();
        movies = new JButton();
        sport = new JButton();
        geography = new JButton();

        math.setOpaque(false);
        physic.setOpaque(false);
        history.setOpaque(false);
        art.setOpaque(false);
        anatomy.setOpaque(false);
        chemistry.setOpaque(false);
        literature.setOpaque(false);
        movies.setOpaque(false);
        sport.setOpaque(false);
        geography.setOpaque(false);

        add(math);
        add(physic);
        add(history);
        add(art);
        add(anatomy);
        add(chemistry);
        add(literature);
        add(movies);
        add(sport);
        add(geography);

        physic.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "PHYSICS";
            order = 7;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        math.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "secret";
            order = 0;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        art.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "Art";
            order = 5;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        history.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "HISTORY";
            order = 4;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        chemistry.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "CHEMISTRY";
            order = 2;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        literature.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "LITERATURE";
            order = 6;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();

        });
        movies.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "MOVIES";
            order = 9;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        sport.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "SPORT";
            order = 8;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });
        geography.addActionListener(e -> {
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "GEOGRAPHY";
            order = 3;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();

        });
        anatomy.addActionListener(e -> {
            checkInputLimit();
            timeLimit = JOptionPane.showInputDialog(this, "Enter currentTime limit", "Time", JOptionPane.PLAIN_MESSAGE);
            checkInputLimit();
            setCurrentTime(Integer.parseInt(timeLimit));
            subjectName = "ANATOMY";
            order = 1;
            setChangeMode(ModeActivity.QUESTION_PAGE);
            music();
        });


    }



    @Override
    protected void setChangeMode(ModeActivity mode) {
        frame.setCanvas(new QuestionPageCanvas(frame, subjectName));
    }

    @Override
    protected void setButtonBounds(Graphics g) {
        math.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        anatomy.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        chemistry.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        geography.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        history.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        art.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        literature.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        physic.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        sport.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);
        movies.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

    }


    private void drawSbjectSelectPage(Graphics g) { //draw subject items
        drawBackground(g);
        setButtonBounds(g);

        image = new ImageIcon(getClass().getResource("../icons/selectTheme.png")).getImage();
        g.drawImage(image, SUBJECT_PAGE_TITLE_X, SUBJECT_PAGE_TITLE_Y, SUBJECT_PAGE_TITLE_WIDTH, SUBJECT_PAGE_TITLE_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("../icons/math.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("../icons/anatomy.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/chemistry.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/geography.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/history.png")).getImage();
        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/art.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/leterature.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/physics.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/sport.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        image = new ImageIcon(getClass().getResource("../icons/movies.png")).getImage();
        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);


        g.drawRect(10, 10, 775, 580);

    }

    private void checkInputLimit() {
        if (timeLimit.equals("")) {
            timeLimit = "121";
            time = 121;
        }
        for (int i = 0; i < timeLimit.length(); i++) {
            if (timeLimit.charAt(i) < '0' || timeLimit.charAt(i) > '9') {
                JOptionPane.showMessageDialog(this, "Please enter correct data");
                break;
            }
        }
        if (Integer.parseInt(timeLimit) > 500 || Integer.parseInt(timeLimit) < 10) {
            JOptionPane.showMessageDialog(this, "Please enter more then 10 min. and less then 500 min.");

        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawSbjectSelectPage(g);

    }
}
