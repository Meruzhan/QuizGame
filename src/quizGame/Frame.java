package quizGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by levon on 6/7/16.
 */
public class Frame extends JFrame {

    Canvas canvas= new StartPageCanvas(this);

    public Frame(){
        super("Quiz Game");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //JMenu Items

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveAsFile = new JMenuItem("SaveAs");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem exitFile = new JMenuItem("Exit");


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //Add Menu
        JMenu mFile = new JMenu("File");

        mFile.add(newFile);
        mFile.add(openFile);
        mFile.add(saveFile);
        mFile.add(saveAsFile);
        mFile.add(exitFile);
        menuBar.add(mFile);



        add(canvas, BorderLayout.CENTER);
        setBackground(Color.blue);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public void setCanvas(Canvas can){
        canvas.setVisible(false);
        canvas = can;
        System.out.println("hi");
        add(can, BorderLayout.CENTER);
       // canvas.update(getGraphics());
//        canvas.setVisible(true);


    }

    public static void main(String[] args) {
        new Frame();
    }
}
