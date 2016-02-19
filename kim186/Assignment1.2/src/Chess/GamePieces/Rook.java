package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by Moon on 2/4/2016.
 */
public class Rook extends GamePiece {

    public Rook(Player p, PieceType type, int r, int c) {
        super(p, type, r ,c);
    }

    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        //must be in the same line horizontally or vertically
        if(currenty != newy && currentx != newx) {
            return false;
        }

        if(newy == currenty && newx > currentx) {
            return goRight(board, currentx, currenty, newx, newy);
        }

        if(newy == currenty && newx < currentx) {
            return goLeft(board, currentx, currenty, newx, newy);
        }

        if(newx == currentx && newy < currenty) {
            return goDown(board, currentx, currenty, newx, newy);
        }

        if(newx == currentx && newy > currenty) {
            return goUp(board, currentx, currenty, newx, newy);
        }

        return false;

    }

    public boolean goRight(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempx = currentx;
        while (tempx + 1 <= newx) { //if destination is not empty and has a piece with different color, capture it
            if (tempx + 1 == newx && board[tempx + 1][currenty].getPiece() != null && board[tempx + 1][currenty].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[tempx + 1][currenty].getPiece() != null) { //go one right, if empty, move on
                return false;
            }
            tempx++;
        }
        return true;
    }

    public boolean goLeft(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempx = currentx;
        while (tempx - 1 >= newx) {
            if (tempx - 1 == newx && board[tempx - 1][currenty].getPiece() != null && board[tempx - 1][currenty].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[tempx - 1][currenty].getPiece() != null) { //go one left, if empty move on
                return false;
            }
            tempx--;
        }
        return true;
    }

    public boolean goUp(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempy = currenty;
        while (tempy + 1 <= newy) {
            if (tempy + 1 == newy && board[currentx][tempy + 1].getPiece() != null && board[currentx][tempy + 1].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[currentx][tempy + 1].getPiece() != null) { //go one up
                return false;
            }
            tempy++;
        }
        return true;
    }

    public boolean goDown(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempy = currenty;
        while (tempy - 1 <= newy) {
            if (tempy - 1 == newy && board[currentx][tempy - 1].getPiece() != null && board[currentx][tempy - 1].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[currentx][tempy - 1].getPiece() != null) { //go one down
                return false;
            }
            tempy--;
        }
        return true;
    }

}
