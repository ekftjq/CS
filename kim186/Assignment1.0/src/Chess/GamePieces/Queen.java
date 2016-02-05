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

        if (newy > currenty && newx > currentx) {
            return goNorthEast(board, currentx, currenty, newx, newy);
        }

        if (newy < currenty && newx < currentx) {
            return goSouthWest(board, currentx, currenty, newx, newy);
        }

        if (newx > currentx && newy < currenty) {
            return goSouthEast(board, currentx, currenty, newx, newy);
        }

        if (newx < currentx && newy > currenty) {
            return goNorthWest(board, currentx, currenty, newx, newy);
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

    public boolean goNorthEast(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempx = currentx;
        int tempy = currenty;
        while (tempx + 1 <= newx && tempy + 1 <= newy) {
            //if destination is not empty and has a piece with different color, capture it
            if (tempx + 1 == newx && tempy + 1 == newy && board[tempx + 1][tempy + 1].getPiece() != null && board[tempx + 1][tempy + 1].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[tempx + 1][tempy + 1].getPiece() != null) { //go one up right, if empty, move on
                return false;
            }
            if (tempx + 1 == newx && tempy + 1 == newy) {
                return true;
            }
            tempx++;
            tempy++;
        }
        return false;
    }

    public boolean goSouthWest(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempx = currentx;
        int tempy = currenty;
        while (tempx - 1 >= newx && tempy - 1 >= newy) {
            if (tempx - 1 == newx && tempy - 1 == newy && board[tempx - 1][tempy - 1].getPiece() != null && board[tempx - 1][tempy - 1].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[tempx - 1][tempy - 1].getPiece() != null) { //go one down left, if empty move on
                return false;
            }
            if (tempx - 1 == newx && tempy - 1 == newy) {
                return true;
            }
            tempx--;
            tempy--;
        }
        return false;
    }

    public boolean goNorthWest(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempy = currenty;
        int tempx = currentx;
        while (tempy + 1 <= newy && tempx - 1 >= newx) {
            if (tempx - 1 == newx && tempy + 1 == newy && board[tempx - 1][tempy + 1].getPiece() != null && board[tempx - 1][tempy + 1].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[tempx - 1][tempy + 1].getPiece() != null) { //go one up left
                return false;
            }
            if (tempx - 1 == newx && tempy + 1 == newy) {
                return true;
            }
            tempx--;
            tempy++;
        }
        return false;
    }

    public boolean goSouthEast(Block[][] board, int currentx, int currenty, int newx, int newy) {
        int tempx = currentx;
        int tempy = currenty;
        while (tempy - 1 >= newy && tempx + 1 <= newx) {
            if (tempy - 1 == newy && tempx + 1 == newx && board[tempx + 1][tempy - 1].getPiece() != null && board[tempx + 1][tempy - 1].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                player.captured(board[newx][newy].getPiece());
                return true;
            }
            if (board[tempx + 1][tempy - 1].getPiece() != null) { //go one down right
                return false;
            }
            if (tempx + 1 == newx && tempy - 1 == newy) {
                return true;
            }
            tempx++;
            tempy--;
        }
        return false;
    }
}
