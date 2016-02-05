package Chess.GamePieces;

/**
 * Created by Moon on 2/1/2016.
 * A GamePiece will have a Type and a position on the board
 */

public class GamePiece {

    public GamePiece() {

    }

    public enum PieceType {
        PAWN,
        ROOK,
        KNIGHT,
        BISHOP,
        QUEEN,
        KING
    }

    PieceType type;

    public GamePiece(PieceType type) {
        this.type = type;
    }

}


