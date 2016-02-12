package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by moons on 2/12/2016.
 * This is a Custom Piece that is a combination of a Rook and a Knight
 * It can move wherever a Rook and Knight can move
 */
public class RookKnight extends GamePiece {
    public RookKnight(Player p, PieceType type, int r, int c) {
        super(p, type, r, c);
    }

    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        Knight knight = new Knight(board[currentx][currenty].getPiece().getPlayer(), PieceType.KNIGHT, currentx, currenty);
        Rook rook = new Rook(board[currentx][currenty].getPiece().getPlayer(), PieceType.ROOK, currentx, currenty);

        if(knight.ValidMove(board, currentx, currenty, newx, newy)) {
            return true;
        }

        if(rook.ValidMove(board, currentx, currenty, newx, newy)) {
            return true;
        }

        return false;
    }
}
