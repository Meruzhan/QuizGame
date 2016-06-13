package quizGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {


    Canvas canvas = new StartPageCanvas(this);
    Image image;
    Label label;

    public Frame() {
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

        image = new ImageIcon(getClass().getResource("icons/background.png")).getImage();
//        setIconImage(new ImageIcon(getClass().getResource("icons/background.png")).getImage());
//        try {
//            add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("icons/background.png")))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        add(canvas, BorderLayout.CENTER);

        setSize(800, 600);
        setResizable(true);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }


    public void setCanvas(Canvas can) {
        canvas.setVisible(false);
        canvas = can;
        System.out.println("hi");
        add(can, BorderLayout.CENTER);
        // canvas.update(getGraphics());
//        canvas.setVisible(true);


    }


//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//
//        g.drawImage(image, 0, 0, 800, 600, this);
//    }

    public static void main(String[] args) {
        new Frame();
    }
}
