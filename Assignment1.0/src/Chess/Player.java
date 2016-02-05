package Chess;

import Chess.GamePieces.GamePiece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moon on 2/4/2016.
 * A Player is either White or Black
 * Has 16 Pieces per player
 * White = true
 * Black = false
 * DeadPieces go into the List array in order
 */
public class Player {
    boolean color;
    List<GamePiece> DeadPieces = new ArrayList<>();

    public Player(boolean isWhite) {
        this.color = isWhite;
    }

    public boolean getColor() {
        return this.color;
    }

    public void captured(GamePiece piece){
        DeadPieces.add(piece);
    }

    @Override
    public String toString(){
        if(color == true) {
            return "White";
        }
        else return "Black";
    }

    public List<GamePiece> getDeadPieces() {
        return DeadPieces;
    }
}
