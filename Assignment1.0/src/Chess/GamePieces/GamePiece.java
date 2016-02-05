package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by Moon on 2/1/2016.
 * A GamePiece will have a Type,
 * Whether the piece is controlled by the white or black player
 * and the current Position of the Piece on the board
 */

public class GamePiece {

    public enum PieceType {
        PAWN,
        ROOK,
        KNIGHT,
        BISHOP,
        QUEEN,
        KING
    }

    int currentx;
    int currenty;
    Player player;
    PieceType type;

    public GamePiece(Player p, PieceType type, int currentx, int currenty) {
        this.player = p;
        this.type = type;
        this.currentx = currentx;
        this.currenty = currenty;
    }

    //check if the block is within boundaries, check if movement is real, and check if color is same
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if(currentx < 0 || newx > board.length || currenty < 0 || newy > board.length) {
            return false;
        }
        if(currentx == newx && currenty == newy) {
            return false;
        }

        if(board[newx][newy].getPiece() != null) {
            if(board[newx][newy].getPiece().getPlayer().getColor() == board[currentx][currenty].getPiece().getPlayer().getColor()) {
                return false;
            }
        }

        return true;
    }

    public PieceType getType() {
        return type;
    }

    public int getCurrentx() {
        return currentx;
    }

    public int getCurrenty() {
        return currenty;
    }

    public Player getPlayer() {
        return player;
    }
}


