package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by moons on 2/12/2016.
 * This is a Custom Piece that is just like a Pawn.
 * But this can move 2 units forward at anytime
 * Moving 2 units is not bound to being the first move
 */
public class SuperPawn extends GamePiece {
    public SuperPawn(Player p, PieceType type, int r, int c) {
        super(p, type, r, c);
    }

    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        Pawn pawn = new Pawn(board[currentx][currenty].getPiece().getPlayer(), PieceType.PAWN, currentx, currenty);

        if(pawn.ValidMove(board, currentx, currenty, newx, newy)) {
            //pawn.moved = false;
            return true;
        }

        return false;
    }

}
