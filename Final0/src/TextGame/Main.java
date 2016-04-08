package TextGame;

import TextGame.GUI.Screen;
import TextGame.GUI.ScreenController;
import TextGame.GUI.ScreenView;

public class Main {

    public static void main(String[] args) {
        Screen s = new Screen();
        ScreenView v = new ScreenView(s.getImg(), s.getText());

        ScreenController controller = new ScreenController(s, v);

    }
}
