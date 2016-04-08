package TextGame;

import TextGame.GUI.Screen;
import TextGame.GUI.ScreenController;
import TextGame.GUI.ScreenView;

public class Main {

    public static void main(String[] args) {
        String ImagePathA = "/resources/images/rand.png";
        String ImagePathB = "/resources/images/rand2.jpg";
        String TextPathA = "src/TextGame/texts/test.txt";
        String TextPathB = "src/TextGame/texts/scene1.txt";
        Screen s = new Screen(ImagePathB, TextPathA);
        ScreenView v = new ScreenView(s.getImg(), s.getText());

        ScreenController controller = new ScreenController(s, v);

    }
}
