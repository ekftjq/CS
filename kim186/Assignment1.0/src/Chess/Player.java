package Chess;

import Chess.GamePieces.GamePiece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moon on 2/4/2016.
 * A Player is either White or Black
 * Has 16 Pieces per player
 */
public class Player {
    boolean isWhite;
    List<GamePiece> pieces = new ArrayList<>();

    public Player(boolean white) {
        this.isWhite = white;
    }

}
