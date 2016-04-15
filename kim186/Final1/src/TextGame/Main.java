package TextGame;

import TextGame.GUI.Screen;
import TextGame.GUI.ScreenController;
import TextGame.GUI.ScreenView;

public class Main {

    public static void main(String[] args) {
        String ImagePathA = "/resources/images/rand.png";
        String ImagePathB = "/resources/images/rand2.jpg";
        String ImagePathC = "/resources/images/rand3.jpg";
        String TextPathA = "src/resources/texts/test.txt";
        String TextPathB = "src/resources/texts/scene1.txt";
        String TextPathC = "src/resources/texts/scene2.txt";
        String SoundPathA = "src/resources/sounds/sound1.wav";
        String SoundPathB = "src/resources/sounds/sound2.wav";
        String SoundPathC = "src/resources/sounds/sound3.wav";
        FlowChart f = new FlowChart(TextPathA, ImagePathA, SoundPathA);
        f.addChild(TextPathB, ImagePathB, SoundPathB);
        f.getChildren().get(0).addChild(TextPathC, ImagePathC, SoundPathC);

        Screen s = new Screen(f);
        //Screen s2 = new Screen(f.getChildren().get(0));
        ScreenView v = new ScreenView(s.getImg(), s.getText(), s.getSound(), f.getChildren().get(0));
        //ScreenView v2 = new ScreenView(s2.getImg(), s2.getText(), s2.getSound());

        ScreenController controller = new ScreenController(s, v);
    }
}
