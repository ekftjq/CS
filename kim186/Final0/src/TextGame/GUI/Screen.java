package TextGame.GUI;
import sun.reflect.generics.tree.Tree;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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

    public Screen(){
        img = null;
        try {
            img = ImageIO.read(getClass().getResource("/resources/images/rand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(Paths.get("src/TextGame/texts/scene1.txt"))) {
            lines.forEach(s -> text = s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Screen(Tree t) { //to be implemented
        //img = t.getImg();
        //text = t.getText();
    }

    public BufferedImage getImg() {
        return this.img;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String t) {
        this.text = t;
    }

    public void setImg(BufferedImage i) {
        this.img = i;
    }

}
