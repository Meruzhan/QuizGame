package quizGame;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifMenuBarUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.swing.plaf.synth.SynthComboBoxUI;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;

/**
 * Created by levon on 6/7/16.
 */
public class StartPageCanvas extends Canvas {


    private static final int LOGO_SIZE = 150;
    private static final int LOGO_NAME_HEIGHT = 80;
    private static final int LOGO_NAME_WIDTH = 400;
    private static final int START_ACTIVITY_BUTTON_HEIGHT = 50;
    private static final int START_ACTIVITY_BUTTON_WIDTH = 150;
    private static final int LOGO_X = 325;
    private static final int LOGO_Y = 220;
    private static final int LOGO_NAME_Y = 70;
    private static final int LOGO_NAME_X = 200;
    private static final int PLAY_BUTTON_Y = 450;
    private static final int PLAY_BUTTON_X = 200;
    private static final int EXIT_BUTTON_Y = 450;
    private static final int EXIT_BUTTON_X = 450;

   private JButton playButton= new JButton("PLAY");
   private JButton exitButton= new JButton("EXIT");





    public StartPageCanvas() {


//        ButtonUI componentUI= new SynthButtonUI();
//        ButtonUI componentsUI= new SynthButtonUI();
//        playButton.setUI(componentUI);
//        exitButton.setUI(componentsUI);

//
        playButton.setBackground(new Color(153, 135, 255));
        exitButton.setBackground(new Color(153, 135, 255));

        LookAndFeel lookAndFeel= new javax.swing.plaf.nimbus.NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        playButton.setUI( new SynthButtonUI());

        add(playButton);
        add(exitButton);


//        playButton.setUI(new SynthButtonUI());
//        exitButton.setUI(new SynthButtonUI());

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPlayButtonClick();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExitButtonClick();
            }
        });

    }

    private void onExitButtonClick() {

        System.exit(0);
    }

    private void onPlayButtonClick() {
        changeMode=ModeActivity.SUBJECT_SELECT_PAGE;
        repaint();
    }


    private void startPage(Graphics g) {//draw logo name
            image = new ImageIcon(getClass().getResource("icons/logoName.png")).getImage();
            g.drawImage(image, LOGO_NAME_X, LOGO_NAME_Y, LOGO_NAME_WIDTH, LOGO_NAME_HEIGHT, null);

            //draw logo
            image = new ImageIcon(getClass().getResource("icons/logo.png")).getImage();
            g.drawImage(image, LOGO_X, LOGO_Y, LOGO_SIZE, LOGO_SIZE, null);



            //draw play button

            playButton.setBounds(PLAY_BUTTON_X, PLAY_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT);

            //draw exit button
            exitButton.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, START_ACTIVITY_BUTTON_WIDTH, START_ACTIVITY_BUTTON_HEIGHT);



            g.drawRect(10, 10, 775, 555);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        startPage(g);


    }
}

