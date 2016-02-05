package Chess;

import Chess.GamePieces.GamePiece;

/**
 * Created by Moon on 2/4/2016
 * Each Block in the board will either have a GamePiece or be empty
 *
 */
public class Block {
    GamePiece Piece;

    public Block(GamePiece piece) {
        this.Piece = piece;
    }

}
