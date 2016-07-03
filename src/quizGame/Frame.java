package quizGame;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class Frame extends JFrame {
    static AudioStream audioStream;

    private Canvas canvas = new StartPageCanvas(this);
    Label label;

    private Frame() {
        super("Quiz Game");


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setIconImage(new ImageIcon(getClass().getResource("../icons/logoIcon.png")).getImage());
        try {
            add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("../icons/background.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(canvas, BorderLayout.CENTER);

        setSize(800, 630);
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        InputStream is;
        is = getClass().getClassLoader().getResourceAsStream("./audio/soundTrack.wav");
        try {

            audioStream = new AudioStream(is);
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }


    void setCanvas(Canvas can) {
        int currentQuestionNumber;
        if (can instanceof ResultPageCanvas) {
            currentQuestionNumber = ((QuestionPageCanvas) canvas).getCurrentQuestionNumber();
            ((ResultPageCanvas) can).setCurrentQuestionNumber(currentQuestionNumber);
        }

        canvas.setVisible(false);
        canvas = can;

        add(can, BorderLayout.CENTER);
    }

    static void music() {
        AudioClip click;
        URL urlClick = Frame.class.getResource("../audio/buttonSound.wav");
        click = Applet.newAudioClip(urlClick);
        click.play();

    }


    public static void main(String[] args) {
        new Frame();
    }
}
