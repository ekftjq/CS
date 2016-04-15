package TextGame.Tests;

import TextGame.FlowChart;
import TextGame.GUI.Screen;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Moon on 4/15/2016.
 */
public class FlowChartTest {

    String ImagePathA = "/resources/images/rand.png";
    String TextPathA = "src/resources/texts/test.txt";
    String SoundPathA = "src/resources/sounds/sound1.wav";
    FlowChart f = new FlowChart(TextPathA, ImagePathA, SoundPathA);
    Screen s = new Screen(f);

    private BufferedImage loadimg() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource(ImagePathA));
            //img = ImageIO.read(getClass().getResource());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    private File loadsound() {
        File file = null;
        try {
            file = new File(SoundPathA);
            //Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return file;
    }

    @Test
    //Checks if the text is same when loading from the FlowChart and directly loading the text
    public void TestText() throws Exception {
        String test = s.getText();
        assertEquals(test, "World.");
    }

    @Test
    //Compares if the image is same when loading from the FlowChart and directly loading the image
    public void TestImg() throws Exception {
        BufferedImage testimg = s.getImg();
        assertEquals(testimg.getRGB(1,1), loadimg().getRGB(1,1));
    }

    @Test
    //Checks if the music is same when loading from the FlowChart and directly loading the music
    public void TestMusic() throws Exception {
        File file = s.getSound();
        assertEquals(file, loadsound());
    }

}
