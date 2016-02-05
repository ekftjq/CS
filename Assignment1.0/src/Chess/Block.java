package Chess;

import Chess.GamePieces.GamePiece;

/**
 * Created by Moon on 2/4/2016
 * Each Block in the board will either have a GamePiece or be empty
 * Each block has its position x and y
 *
 */
public class Block {
    public GamePiece Piece;

    public Block() {

    }

    public GamePiece getPiece() {
        return this.Piece;
    }

    public void setPiece(GamePiece piece) {
        this.Piece = piece;
    }
}
