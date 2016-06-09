package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by levon on 6/8/16.
 */
public class SubjectPageCanvas extends Canvas {


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
    private static final int SUBJECT_HEIGHT = 60;


    JButton button1= new JButton();
    JButton button2= new JButton();
    JButton button3= new JButton();
    JButton button4= new JButton();
    JButton button5= new JButton();
    JButton button6= new JButton();
    JButton button7= new JButton();
    JButton button8= new JButton();
    JButton button9= new JButton();
    JButton button10= new JButton();


    public SubjectPageCanvas() {

        super();
        LookAndFeel lookAndFeel= new javax.swing.plaf.nimbus.NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);


    }









    private void subjectSelectPage(Graphics g) { //draw subject items

        image= new ImageIcon(getClass().getResource("icons/title.png")).getImage();
        g.drawImage(image,SUBJECT_PAGE_TITLE_X,SUBJECT_PAGE_TITLE_Y,SUBJECT_PAGE_TITLE_WIDTH,SUBJECT_PAGE_TITLE_HEIGHT,null);

        button1.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button2.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button3.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button4.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button5.setBounds(FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button6.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button7.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button8.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button9.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

        button10.setBounds(SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT);

//
//        image = new ImageIcon(getClass().getResource("icons/math.png")).getImage();
//        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//        image = new ImageIcon(getClass().getResource("icons/biology.png")).getImage();
//        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/chemistry.png")).getImage();
//        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/geography.png")).getImage();
//        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/history.png")).getImage();
//        g.drawImage(image, FIRST_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/Informatics.png")).getImage();
//        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_1_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/literature.png")).getImage();
//        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_2_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/physics.png")).getImage();
//        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_3_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/artHistory.png")).getImage();
//        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_4_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//
//
//        image = new ImageIcon(getClass().getResource("icons/secret.png")).getImage();
//        g.drawImage(image, SECOND_COLUMN_SUBJECT_X, SUBJECT_5_Y, SUBJECT_WIDTH, SUBJECT_HEIGHT, null);
//

        g.drawRect(10, 10, 775, 555);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        subjectSelectPage(g);
        System.out.println("hsd");
    }
}
