package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by Moon on 2/4/2016.
 */
public class King extends GamePiece {
    public King(Player p, PieceType type, int r, int c) {
        super(p, type, r, c);
    }

    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        if(Math.abs(newx - currentx) > 1 || Math.abs(newy - currenty) > 1) {
            return false;
        }

        if(board[newx][newy].getPiece() == null) {
                return true;
        }

        if(board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
        }

        return false;

    }

    @Override
    public int getCurrenty() {
        return super.getCurrenty();
    }

    @Override
    public int getCurrentx() {
        return super.getCurrentx();
    }
}
