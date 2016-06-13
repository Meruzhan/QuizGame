package quizGame;

import javax.swing.*;
import java.awt.*;

public class QuestionPageCanvas extends Canvas {

    private static final int HEADER_CONTENT_X=200;
    private static final int HEADER_CONTENT_Y=-20;
    private static final int HEADER_CONTENT_W=400;
    private static final int HEADER_CONTENT_H=100;


    private static final int QUESTION_AREA_PAGE_X = 50;
    private static final int QUESTION_AREA_PAGE_Y = 80;
    private static final int QUESTION_AREA_PAGE_WIDTH = 700;
    private static final int QUESTION_AREA_PAGE_HEIGHT = 250;

    private static final int LEFT_ANSWERS_X = 20;
    private static final int A_ANSWERS_Y = 370;
    private static final int C_ANSWERS_Y = 450;
    private static final int RIGHT_ANSWERS_X = 440;
    private static final int ANSWERS_BUTTON_WIDTH = 340;
    private static final int ANSWERS_BUTTON_HEIGHT = 50;

    JButton button_A = new JButton("A:");
    JButton button_B = new JButton("B:");
    JButton button_C = new JButton("C:");
    JButton button_D = new JButton("D:");

    JLabel question= new JLabel();
    JLabel answer_A= new JLabel();
    JLabel answer_B= new JLabel();
    JLabel answer_C= new JLabel();
    JLabel answer_D= new JLabel();

    public QuestionPageCanvas(Frame frame) {
        super(frame);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        button_A.setOpaque(false);
        button_B.setOpaque(false);
        button_C.setOpaque(false);
        button_D.setOpaque(false);

        add(button_A);
        add(button_B);
        add(button_C);
        add(button_D);

        button_A.addActionListener(e -> setChangeMode(ModeActivity.RESULT_PAGE));
        button_B.addActionListener(e -> setChangeMode(ModeActivity.RESULT_PAGE));
        button_C.addActionListener(e -> setChangeMode(ModeActivity.RESULT_PAGE));
        button_D.addActionListener(e -> setChangeMode(ModeActivity.RESULT_PAGE));

    }

    @Override
    protected void setButtonBounds(Graphics g) {
        button_A.setBounds(LEFT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        button_B.setBounds(RIGHT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        button_C.setBounds(LEFT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
        button_D.setBounds(RIGHT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT);
    }


    private void drawQuestionsPage(Graphics g) {
        drawBackground(g);
        setButtonBounds(g);

        image = new ImageIcon(getClass().getResource("icons/header.png")).getImage();
        g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);

        image = new ImageIcon(getClass().getResource("icons/questionArea.png")).getImage();
        g.drawImage(image, QUESTION_AREA_PAGE_X, QUESTION_AREA_PAGE_Y, QUESTION_AREA_PAGE_WIDTH, QUESTION_AREA_PAGE_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, LEFT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, RIGHT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, LEFT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, RIGHT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawQuestionsPage(g);
        System.out.println("hellllo");
    }
}
