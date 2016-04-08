package TextGame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Moon on 4/8/2016.
 * This is the View
 */
public class ScreenView extends JPanel {
    JFrame frame;
    JTextArea textbox;

    public ScreenView(BufferedImage img, String s) { //In the future, the String will be replaced with a file of text
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel image = new JLabel(new ImageIcon(img));
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(500, 500);
        //frame.getContentPane().setLayout(new FlowLayout());

        textbox = new JTextArea(s, 5, 15);
        textbox.setEditable(false);

        /*
        //image section of the GUI
        Panel panel1 = new Panel();
        panel1.add(image);
        */

        //text section of the GUI
        Panel panel2 = new Panel();
        panel2.add(textbox);

        /*
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, image, panel2);
        frame.getContentPane().add(splitPane);
        */
        mainPanel.add(image, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    public void printImg(BufferedImage img) {

    }

    public void printText(String t) {

    }
}
