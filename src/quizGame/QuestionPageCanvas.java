package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    private int currentQuestionScore=0;
    private static final String url ="jdbc:sqlserver://localhost:1433;databaseName=demo";
    private static final String login ="root";
    private static final String password = "root";
    private ArrayList<String> questions = new ArrayList<>();
    JButton button_A = new JButton("A:");
    JButton button_B = new JButton("B:");
    JButton button_C = new JButton("C:");
    JButton button_D = new JButton("D:");

//    JLabel question= new JLabel();
//    JLabel answer_A= new JLabel();
//    JLabel answer_B= new JLabel();
//    JLabel answer_C= new JLabel();
//    JLabel answer_D= new JLabel();
    String subjectName;
    ResultSet result;
    Statement statement;
    String question;
    String answerCorrect;
    String answer_b;
    String answer_c;
    String answer_d;
    ArrayList<String> answers = new ArrayList<>();



    public QuestionPageCanvas(Frame frame,String subjectName) {
        super(frame);
        this.subjectName = subjectName;
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

        button_A.addActionListener(e -> {
            if(answerCorrect.equals(answers.get(0)))correctAnswersCount++ ;
            questionScore();
            repaint();

        });
        button_B.addActionListener(e ->{
            if(answerCorrect.equals(answers.get(1)))correctAnswersCount++ ;
            questionScore();
            repaint();
        });
        button_C.addActionListener(e ->{
            if(answerCorrect.equals(answers.get(2)))correctAnswersCount++ ;
            questionScore();
            repaint();
        });
        button_D.addActionListener(e ->{
            if(answerCorrect.equals(answers.get(3)))correctAnswersCount++ ;
            questionScore();
            repaint();

        });

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

            connection = DriverManager.getConnection(url,login,password);

             statement = connection.createStatement();
          result =  statement.executeQuery("SELECT TOP 10 *,NEWID()AS id FROM questions " +
                  "inner JOIN dbo.subjects ON dbo.subjects.subjectsId = dbo.questions.subjectsId WHERE dbo.subjects.subjectsName LIKE '"+subjectName+"' ORDER BY id DESC");
            while (result.next()){
                questions.add(result.getString(2));

            }

            curentResultAnswer();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void questionScore(){
        if (currentQuestionScore>=9){
            setChangeMode(ModeActivity.RESULT_PAGE);
        }else{

            curentResultAnswer();
           currentQuestionScore++;
        }

    }

    private  void curentResultAnswer(){
        try {
            answers.clear();
            question = questions.remove(0);
            result= statement.executeQuery("SELECT TOP 10 *,NEWID()AS id FROM dbo.answers " +
                    "inner JOIN dbo.questions ON dbo.questions.questionsId = dbo.answers.questionsId" +
                    " WHERE dbo.questions.questionsName LIKE '"+question+"' ORDER BY id DESC");

            while (result.next()){
               answers.add( result.getString(2));
                if(result.getInt(4)==1){
                    answerCorrect = answers.get(answers.size()-1);
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
    }


    private void drawQuestionsPage(Graphics g) {
        drawBackground(g);
        setButtonBounds(g);
        g.setFont(new Font("TimesRoman",Font.PLAIN,40));
        image = new ImageIcon(getClass().getResource("icons/header.png")).getImage();
        g.drawImage(image, HEADER_CONTENT_X, HEADER_CONTENT_Y, HEADER_CONTENT_W, HEADER_CONTENT_H, null);
        g.drawString(subjectName,HEADER_CONTENT_X+75,HEADER_CONTENT_Y+85);


        g.setFont(new Font("TimesRoman",Font.PLAIN,20));
        image = new ImageIcon(getClass().getResource("icons/questionArea.png")).getImage();
        g.drawImage(image, QUESTION_AREA_PAGE_X, QUESTION_AREA_PAGE_Y, QUESTION_AREA_PAGE_WIDTH, QUESTION_AREA_PAGE_HEIGHT, null);
//        g.drawString(question,QUESTION_AREA_PAGE_X+100,QUESTION_AREA_PAGE_Y+100);
        checkQuestionLength(g);

        g.setFont(new Font("TimesRoman",Font.PLAIN,30));
        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, LEFT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(0),LEFT_ANSWERS_X+30,A_ANSWERS_Y+30);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, RIGHT_ANSWERS_X, A_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(1),RIGHT_ANSWERS_X+30,A_ANSWERS_Y+30);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, LEFT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(2),LEFT_ANSWERS_X+30,C_ANSWERS_Y+30);

        image = new ImageIcon(getClass().getResource("icons/answersbutton.png")).getImage();
        g.drawImage(image, RIGHT_ANSWERS_X, C_ANSWERS_Y, ANSWERS_BUTTON_WIDTH, ANSWERS_BUTTON_HEIGHT, null);
        g.drawString(answers.get(3),RIGHT_ANSWERS_X+30,C_ANSWERS_Y+30);

    }

    private void checkQuestionLength(Graphics g){
        int index=0;
        if (question.length()>51){
            for (int i = 45; i <question.length() ; i++) {
                if(question.charAt(i)==' '){
                index=i;
                break;
                }
            }
            g.drawString(question.substring(0,index),QUESTION_AREA_PAGE_X+100,QUESTION_AREA_PAGE_Y+100);
            g.drawString(question.substring(index,question.length()),QUESTION_AREA_PAGE_X+100,QUESTION_AREA_PAGE_Y+130);

        }else
        g.drawString(question,QUESTION_AREA_PAGE_X+100,QUESTION_AREA_PAGE_Y+100);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawQuestionsPage(g);
        System.out.println("hellllo");
        System.out.println(subjectName);

    }
}
