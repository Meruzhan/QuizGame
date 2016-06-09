package quizGame;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifButtonUI;
import com.sun.java.swing.plaf.motif.MotifCheckBoxUI;
import com.sun.java.swing.plaf.motif.MotifToggleButtonUI;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.plaf.multi.MultiButtonUI;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Levon on 6/9/2016.
 */
public class QuestionPageCanvas extends Canvas {

    private static final int QUESTION_AREA_PAGE_X=150;
    private static final int QUESTION_AREA_PAGE_Y=50;
    private static final int QUESTION_AREA_PAGE_WIDTH=500;
    private static final int QUESTION_AREA_PAGE_HEIGHT=250;

    private static final int LEFT_ANSWERS_X=20;
    private static final int A_ANSWERS_Y=350;
    private static final int C_ANSWERS_Y=430;
    private static final int RIGHT_ANSWERS_X=440;
    private static final int ANSWERS_BUTTON_WIDTH=340;
    private static final int ANSWERS_BUTTON_HEIGHT=50;

    JTextArea textArea= new JTextArea();
    JButton button_A=new JButton("A:");
    JButton button_B=new JButton("B:");
    JButton button_C=new JButton("C:");
    JButton button_D=new JButton("D:");


    public QuestionPageCanvas() {



        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setText("Who are you?");

        textArea.setFont(new Font("myfont",Font.CENTER_BASELINE,24));
        button_A.setBackground(new Color(0x4859AD));
        button_B.setBackground(new Color(0x4859AD));
        button_C.setBackground(new Color(0x4859AD));
        button_D.setBackground(new Color(0x4859AD));

LookAndFeel lookAndFeel= new javax.swing.plaf.nimbus.NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(textArea);
        add(button_A);
        add(button_B);
        add(button_C);
        add(button_D);

    }


    private void questionsPage(Graphics g) {

        image= new ImageIcon(getClass().getResource("icons/question.png")).getImage();
        g.drawImage(image,QUESTION_AREA_PAGE_X,QUESTION_AREA_PAGE_Y,QUESTION_AREA_PAGE_WIDTH,QUESTION_AREA_PAGE_HEIGHT,null);
        textArea.setBounds(QUESTION_AREA_PAGE_X,QUESTION_AREA_PAGE_Y+2,QUESTION_AREA_PAGE_WIDTH,QUESTION_AREA_PAGE_HEIGHT-30);
        textArea.setEditable(false);
        textArea.setBackground(Color.lightGray);

        button_A.setBounds(LEFT_ANSWERS_X,A_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT);
        button_B.setBounds(RIGHT_ANSWERS_X,A_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT);
        button_C.setBounds(LEFT_ANSWERS_X,C_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT);
        button_D.setBounds(RIGHT_ANSWERS_X,C_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT);

//
//        image= new ImageIcon(getClass().getResource("icons/A.png")).getImage();
//        g.drawImage(image,LEFT_ANSWERS_X,A_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT,null);
//
//        image= new ImageIcon(getClass().getResource("icons/C.png")).getImage();
//        g.drawImage(image,LEFT_ANSWERS_X,C_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT,null);
//
//        image= new ImageIcon(getClass().getResource("icons/B.png")).getImage();
//        g.drawImage(image,RIGHT_ANSWERS_X,A_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT,null);
//
//        image= new ImageIcon(getClass().getResource("icons/D.png")).getImage();
//        g.drawImage(image,RIGHT_ANSWERS_X,C_ANSWERS_Y,ANSWERS_BUTTON_WIDTH,ANSWERS_BUTTON_HEIGHT,null);


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        questionsPage(g);
        System.out.println("hellllo");
    }
}
