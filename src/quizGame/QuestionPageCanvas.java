package quizGame;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.audio.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.sql.*;
import java.util.*;

import static quizGame.Frame.audioStream;
import static quizGame.Frame.music;
import static quizGame.SubjectPageCanvas.order;


class QuestionPageCanvas extends Canvas {

    private static final int HEADER_CONTENT_X = 200;
    private static final int HEADER_CONTENT_Y = 0;
    private static final int HEADER_CONTENT_W = 400;
    private static final int HEADER_CONTENT_H = 100;

    private static final int SCORE_X = 200;
    private static final int SCORE_Y = 120;
    private static final int SCORE_W = 150;
    private static final int SCORE_H = 50;

    private static final int QUESTION_AREA_PAGE_X = 50;
    private static final int QUESTION_AREA_PAGE_Y = 150;
    private static final int QUESTION_AREA_PAGE_WIDTH = 700;
    private static final int QUESTION_AREA_PAGE_HEIGHT = 250;


    private static final int QUESTION_NUMBER_X = 695;
    private static final int QUESTION_NUMBER_Y = 72;


    private static final int LEFT_ANSWERS_X = 20;
    private static final int A_ANSWERS_Y = 450;
    private static final int C_ANSWERS_Y = 530;
    private static final int RIGHT_ANSWERS_X = 440;
    private static final int ANSWERS_BUTTON_WIDTH = 340;
    private static final int ANSWERS_BUTTON_HEIGHT = 50;
    private static final int STOPWATCH_X = 5;
    private static final int STOPWATCH_Y = 5;
    private static final int STOPWATCH_W = 105;
    private static final int STOPWATCH_H = 105;
    private static final int TIME_Y = 77;
    private int currentQuestionNumber = 1;
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=demo";
    private static final String login = "root";
    private static final String password = "root";
    private ArrayList<String> questions = new ArrayList<>();
    private JButton button_A;
    private JButton button_B;
    private JButton button_C;
    private JButton button_D;
    private JButton muteButton;


    private String subjectName;
    private ResultSet result;
    private Statement statement;
    private String question;
    private String correctAnswers;
    String answer_b;
    String answer_c;
    String answer_d;
    private ArrayList<String> answers = new ArrayList<>();
    static int currentTime = 0;
    static int time = 0;


    QuestionPageCanvas(Frame frame, String subjectName) {
        super(frame);
        this.subjectName = subjectName;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        button_A = new JButton("A:");
        button_B = new JButton("B:");
        button_C = new JButton("C:");
        button_D = new JButton("D:");
        muteButton = new JButton();
        button_A.setOpaque(false);
        button_B.setOpaque(false);
        button_C.setOpaque(false);
        button_D.setOpaque(false);
        muteButton.setOpaque(false);

        add(button_A);
        add(button_B);
        add(button_C);
        add(button_D);
        add(muteButton);

        button_A.addActionListener(e -> {
            if (correctAnswers.equals(answers.get(0))) correctAnswersCount++;
            questionScore();
            repaint();
            music();

        });
        button_B.addActionListener(e -> {
            if (correctAnswers.equals(answers.get(1))) correctAnswersCount++;
            questionScore();
            repaint();
            music();
        });
        button_C.addActionListener(e -> {
            if (correctAnswers.equals(answers.get(2))) correctAnswersCount++;
            questionScore();
            repaint();
            music();
        });
        button_D.addActionListener(e -> {
            if (correctAnswers.equals(answers.get(3))) correctAnswersCount++;
            questionScore();
            repaint();
            music();
        });

        muteButton.addActionListener(e -> AudioPlayer.player.stop(audioStream));
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                repaint();
            }
        });

        Connection connection;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(url, login, password);

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT TOP 10 *,NEWID()AS id FROM questions " +
                    "inner JOIN dbo.subjects ON dbo.subjects.subjectsId = dbo.questions.subjectsId WHERE dbo.subjects.subjectsName LIKE '" + subjectName + "' ORDER BY id DESC");
            while (result.next()) {
                questions.add(result.getString(2));

            }

            currentResultAnswer();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void questionScore() {
        if (currentQuestionNumber >= 10) {


            setChangeMode(ModeActivity.RESULT_PAGE);
        } else {

            currentResultAnswer();
            currentQuestionNumber++;
        }

    }

    private void currentResultAnswer() {
        try {
            answers.clear();
            question = questions.remove(0);
            result = statement.executeQuery("SELECT TOP 10 *,NEWID()AS id FROM dbo.answers " +
                    "inner JOIN dbo.questions ON dbo.questions.questionsId = dbo.answers.questionsId" +
                    " WHERE dbo.questions.questionsName LIKE '" + question + "' ORDER BY id DESC");

            while (result.next()) {
                answers.add(result.getString(2));
                if (result.getInt(4) == 1) {
                    correctAnswers = answers.get(answers.size() - 1);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setButtonBounds(Graphics g) {
        button_A.setBounds(LEFT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        button_B.setBounds(RIGHT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        button_C.setBounds(LEFT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        button_D.setBounds(RIGHT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        muteButton.setBounds(15, 400, 30, 30);
    }

    int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    private int getTime() {

        try {
            if (currentTime > 0) {
                Thread.sleep(1000);
                currentTime--;

                return currentTime;

            } else {

                setChangeMode(ModeActivity.RESULT_PAGE);
                currentTime--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;

    }

    static int getSpendTime() {
        return time - currentTime;
    }

    static void setCurrentTime(int minutes) {
        currentTime = minutes;
        time = minutes;
    }

    private void drawTime(Graphics g) {


        int xSize[] = new int[4];
        xSize[3] = 20;
        xSize[2] = 35;
        xSize[1] = 45;
        int digitsCount = Integer.toString(currentTime).length();
        for (int i = 1; i <= 3; i++) {
            if (digitsCount == i && currentTime >= 0) {
                g.drawString("" + getTime(), xSize[i], TIME_Y);
                repaint();
            }
        }
    }

    private void drawSubjectNameHeader(Graphics g) {
        File file = new File("resources/headers");
        String[] images = file.list();
        for (int i = 0; i < 10; i++) {
            if (order == i) {
                image = new ImageIcon(getClass().getResource("../headers/" + images[order])).getImage();
                g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);
                repaint();
            }
        }

    }

    private void drawQuestionsPage(Graphics g) {
        drawBackground(g);
        setButtonBounds(g);
        drawSubjectNameHeader(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        image = new ImageIcon(getClass().getResource("../icons/stopwatch.png")).getImage();
        g.drawImage(image, STOPWATCH_X, STOPWATCH_Y, STOPWATCH_W, STOPWATCH_H, null);

        drawTime(g);

        image = new ImageIcon(getClass().getResource("../icons/cal.png")).getImage();
        g.drawImage(image, STOPWATCH_X + 650, STOPWATCH_Y+10, 100, 100, null);

        image = new ImageIcon(getClass().getResource("../icons/sound-off.png")).getImage();
        g.drawImage(image, 15, 400, 30, 30, null);

        g.drawString(currentQuestionNumber + "", QUESTION_NUMBER_X, QUESTION_NUMBER_Y);

        image = new ImageIcon(getClass().getResource("../icons/scoreField.png")).getImage();
        g.drawImage(image, SCORE_X, SCORE_Y, SCORE_W, SCORE_H, null);


        g.drawString(correctAnswersCount + "", SCORE_X + 155, SCORE_Y + 35);


        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        image = new ImageIcon(getClass().getResource("../icons/questionArea.png")).getImage();
        g.drawImage(image, QUESTION_AREA_PAGE_X, QUESTION_AREA_PAGE_Y, QUESTION_AREA_PAGE_WIDTH, QUESTION_AREA_PAGE_HEIGHT, null);
        g.setColor(new Color(0x3A0604));
        checkQuestionLength(g);
        g.setColor(new Color(0xE9F5A9));


        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        checkAnswersLength(g);
        image = new ImageIcon(getClass().getResource("../icons/answersbutton.png")).getImage();
        g.drawImage(image, LEFT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(0), LEFT_ANSWERS_X + 30, A_ANSWERS_Y + 30);

        image = new ImageIcon(getClass().getResource("../icons/answersbutton.png")).getImage();
        g.drawImage(image, RIGHT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(1), RIGHT_ANSWERS_X + 30, A_ANSWERS_Y + 30);

        image = new ImageIcon(getClass().getResource("../icons/answersbutton.png")).getImage();
        g.drawImage(image, LEFT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(2), LEFT_ANSWERS_X + 30, C_ANSWERS_Y + 30);

        image = new ImageIcon(getClass().getResource("../icons/answersbutton.png")).getImage();
        g.drawImage(image, RIGHT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(3), RIGHT_ANSWERS_X + 30, C_ANSWERS_Y + 30);

    }

    private void checkAnswersLength(Graphics g) {
        for (String answer : answers) {
            if (answer.length() > 20) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            }
        }

    }

    private void checkQuestionLength(Graphics g) {
        int index = 0;
        String line = "";
        int length = question.length();

        if (length <= 30) {
            g.drawString(question, QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 100);
        } else if (length <= 60) {
            for (int i = 25; i < length; i++) {
                if (question.charAt(i) == ' ') {
                    g.drawString(question.substring(0, i), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 100);
                    index = i;
                    break;
                }

            }
            g.drawString(question.substring(index, length), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 130);
        } else if (length < 80) {
            for (int i = 25; i < length; i++) {
                if (question.charAt(i) == ' ') {
                    g.drawString(question.substring(0, i), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 100);
                    index = i;
                    break;
                }

            }
            for (int i = 50; i < length; i++) {
                if (question.charAt(i) == ' ') {
                    g.drawString(question.substring(index, i), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 130);
                    g.drawString(question.substring(i + 1, length), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 160);
                    break;
                }
            }

        } else {
            for (int i = 25; i < length; i++) {
                if (question.charAt(i) == ' ') {
                    g.drawString(question.substring(0, i), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 100);
                    index = i;
                    break;
                }

            }
            for (int i = 50; i < length; i++) {
                if (question.charAt(i) == ' ') {
                    g.drawString(question.substring(index, i), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 130);
                    index = i;
                    break;
                }
            }
            for (int i = 70; i < length; i++) {
                if (question.charAt(i) == ' ') {
                    g.drawString(question.substring(index, i), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 160);
                    g.drawString(question.substring(i, length), QUESTION_AREA_PAGE_X + 100, QUESTION_AREA_PAGE_Y + 190);

                    break;
                }
            }


        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawQuestionsPage(g);


    }
}
