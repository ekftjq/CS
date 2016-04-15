package TextGame.GUI;

import TextGame.FlowChart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Moon on 4/8/2016.
 * This is the View
 */
public class ScreenView extends JPanel {
    JFrame frame;
    JTextArea textbox;

    public ScreenView(BufferedImage img, String s, File sound) {
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel image = new JLabel(new ImageIcon(img));
        frame.add(mainPanel, BorderLayout.CENTER);
        //frame.getContentPane().setLayout(new FlowLayout());
        textbox = new JTextArea(s, 10, 45);
        textbox.setEditable(false);
        /*
        //image section of the GUI
        Panel panel1 = new Panel();
        panel1.add(image);
        */

        //text section of the GUI
        Panel panel2 = new Panel();
        panel2.add(textbox);
        playMusic(sound);
        //button.addActionListener(new AL());

        /*
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, image, panel2);
        frame.getContentPane().add(splitPane);
        */
        mainPanel.add(image, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);
        frame.setSize(1000, 1000);
        //frame.pack();
        frame.setVisible(true);
    }

    public ScreenView(BufferedImage img, String s, File sound, FlowChart flow) {
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel image = new JLabel(new ImageIcon(img));
        frame.add(mainPanel, BorderLayout.CENTER);
        //frame.getContentPane().setLayout(new FlowLayout());
        textbox = new JTextArea(s, 10, 45);
        textbox.setEditable(false);

        /*
        //image section of the GUI
        Panel panel1 = new Panel();
        panel1.add(image);
        */

        //text section of the GUI
        Panel panel2 = new Panel();
        panel2.add(textbox);
        playMusic(sound);
        JButton nextbutton = new JButton("next");

        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen s1 = new Screen(flow);
                if(flow.getChildren().size() == 0) {
                    ScreenView sv = new ScreenView(s1.getImg(), s1.getText(), s1.getSound());
                }
                else {
                    ScreenView sv = new ScreenView(s1.getImg(), s1.getText(), s1.getSound(), flow.getChildren().get(0));
                }
            }
        });

        panel2.add(nextbutton);
        //button.addActionListener(new AL());
        /*
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, image, panel2);
        frame.getContentPane().add(splitPane);
        */
        mainPanel.add(image, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);
        frame.setSize(1000, 1000);
        //frame.pack();
        frame.setVisible(true);
    }

    /*
    public class AL implements ActionListener{
        public final void actionPerformed(ActionEvent e) {
            move();
        }
    }

    public void move(){

    }
    */

    public void playMusic(File file) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            //Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void printImg(BufferedImage img) {

    }

    public void printText(String t) {

    }
}
