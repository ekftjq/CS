package TextGame.GUI;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Moon on 4/8/2016.
 * This is the controller
 */
public class ScreenController {
    private Screen model;
    private ScreenView view;

    public ScreenController(Screen m, ScreenView v){
        this.model = m;
        this.view = v;
    }

    public void setImage(BufferedImage img) {
        model.setImg(img);
    }

    public void setText(String s) {
        model.setText(s);
    }

    public void setMusic(File file) {
        model.setSound(file);
    }

    public String getText() {
        return model.getText();
    }

    public BufferedImage getImage() {
        return model.getImg();
    }

    public File getSound() {
        return model.getSound();
    }


}
