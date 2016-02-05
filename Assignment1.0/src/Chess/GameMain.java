package Chess;

/**
 * Created by Moon on 2/1/2016.
 * Game has two players and a board
 */
public class GameMain {
    Player white;
    Player black;
    Board board;

    //initialize pieces for both white and black
    //initialize the board
    public GameMain() {
        white = new Player(true);
        black = new Player(false);
        board = new Board();
    }





    public static void main(String[] args) {
        GameMain game = new GameMain();
        System.out.println(game.toString());
    }
}
