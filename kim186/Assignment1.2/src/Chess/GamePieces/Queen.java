package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by Moon on 2/4/2016.
 */
public class Queen extends GamePiece {
    public Queen(Player p, PieceType type, int r, int c) {
        super(p, type, r, c);
    }

    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        Bishop bis = new Bishop(board[currentx][currenty].getPiece().getPlayer(), PieceType.BISHOP, currentx, currenty);
        Rook rook = new Rook(board[currentx][currenty].getPiece().getPlayer(), PieceType.ROOK, currentx, currenty);

        if(bis.ValidMove(board, currentx, currenty, newx, newy)) {
            return true;
        }

        if(rook.ValidMove(board, currentx, currenty, newx, newy)) {
            return  true;
        }

        return false;
    }
}
