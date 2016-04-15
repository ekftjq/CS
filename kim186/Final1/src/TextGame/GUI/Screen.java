package TextGame.GUI;
import TextGame.FlowChart;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Moon on 4/8/2016.
 * Creating a GUI with MVC Pattern
 * This is the Model
 */
public class Screen {
    //a screen has a image and a text
    BufferedImage img;
    String text;
    File sound;

    public Screen(FlowChart f){
        img = null;
        try {
            img = ImageIO.read(getClass().getResource(f.getImagePath()));
            //img = ImageIO.read(getClass().getResource());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try (Stream<String> lines = Files.lines(Paths.get("src/TextGame/texts/scene1.txt"))) {
        try (Stream<String> lines = Files.lines(Paths.get(f.getTextPath()))) {
                lines.forEach(s -> text = s);
        } catch (IOException e) {
                e.printStackTrace();
        }

        try {
            sound = new File(f.getMusicPath());
            //Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public BufferedImage getImg() {
        return this.img;
    }

    public String getText() {
        return this.text;
    }

    public File getSound() {
        return sound;
    }

    public void setText(String t) {
        this.text = t;
    }

    public void setImg(BufferedImage i) {
        this.img = i;
    }

    public void setSound(File sound) {
        this.sound = sound;
    }
}
