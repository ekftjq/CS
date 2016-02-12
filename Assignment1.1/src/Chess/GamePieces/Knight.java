package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by Moon on 2/4/2016.
 */
public class Knight extends GamePiece {
    public Knight(Player p, PieceType type, int r, int c) {
        super(p, type, r, c);
    }

    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        if(newx > currentx && newy > currenty) {
            if (newx == currentx + 2 && newy == currenty + 1) {
                if (board[newx][newy].getPiece() == null) {
                    //if new block is empty
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    //if new block is occupied but by a different color, capture
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }

            if (newx == currentx + 1 && newy == currenty + 2) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    //if new block is occupied but by a different color
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }
        }

        if(newx > currentx && newy < currenty) {
            if(newx == currentx + 2 && newy == currenty - 1) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }

            if(newx == currentx + 1 && newy == currenty - 2) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }
        }

        if(newx < currentx && newy < currenty) {
            if(newx == currentx - 2 && newy == currenty - 1) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }
            if(newx == currentx - 1 && newy == currenty - 2) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }
        }

        if(newx < currentx && newy > currenty) {
            if(newx == currentx - 2 && newy == currenty + 1) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }

            if(newx == currentx - 1 && newy == currenty + 2) {
                if (board[newx][newy].getPiece() == null) {
                    return true;
                }
                if (board[newx][newy].getPiece() != null && board[newx][newy].getPiece().getPlayer().getColor() != board[currentx][currenty].getPiece().getPlayer().getColor()) {
                    player.captured(board[newx][newy].getPiece());
                    return true;
                }
            }
        }

        return false;
    }

}
