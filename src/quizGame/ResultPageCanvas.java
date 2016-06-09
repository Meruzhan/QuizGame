package quizGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by levon on 6/9/16.
 */
public class ResultPageCanvas extends Canvas {


    public ResultPageCanvas() {
        super();
        LookAndFeel lookAndFeel= new javax.swing.plaf.nimbus.NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void paint(Graphics g) {

    }
}
