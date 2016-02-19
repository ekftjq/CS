package Chess.GamePieces;

import Chess.Block;
import Chess.Player;

/**
 * Created by Moon on 2/4/2016.
 */
public class Pawn extends GamePiece {
    boolean moved = false;

    public Pawn(Player p, PieceType type, int r, int c) {
        super(p, type, r ,c);
    }

    //if I am moving forward, I can go 2 or 1 steps depending whether it is my first move or not
    //after my first move, I can only move forward 1 or diagonal 1 if there is another player's piece
    @Override
    public boolean ValidMove(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if(!super.ValidMove(board, currentx, currenty, newx, newy)) {
            return false;
        }

        if(!moved) {
            this.moved = true;
            if(this.getPlayer().getColor()) { //white
                if(newx == currentx) { //same x
                    if(newy - currenty == 1) { //1 step
                        if(board[newx][newy].getPiece() == null) { //no piece on destination
                            return true; //can move
                        }
                    }
                    if(newy - currenty == 2) { //2 steps
                        if(board[newx][newy].getPiece() == null && board[newx][newy-1].getPiece() == null) { //no piece on destination and between
                            return true;
                        }
                    }
                }
            }

            if(!this.getPlayer().getColor()) { //black
                if(newx == currentx) { //same x
                    if(currenty - newy == 1) { //1 step
                        if(board[newx][newy].getPiece() == null) { //no piece on destination
                            return true; //can move
                        }
                    }
                    if(currenty - newy == 2) { //2 steps
                        if(board[newx][newy].getPiece() == null && board[newx][newy+1].getPiece() == null){
                            return true;
                        }
                    }
                }
            }
        }

        if(this.getPlayer().getColor()) { //white
            if (newx == currentx) { //same x
                if (newy - currenty == 1) { //1 step
                    if (board[newx][newy].getPiece() == null) { //no piece on destination
                        return true; //can move
                    }
                }
            }
        }

        if(!this.getPlayer().getColor()) { //black
            if (newx == currentx) { //same x
                if (currenty - newy == 1) { //1 step
                    if (board[newx][newy].getPiece() == null) { //no piece on destination
                        return true; //can move
                    }
                }
            }
        }

        //if the diagonal piece is opposite color, capture
        if(this.getPlayer().getColor()) { //white
            if (currentx + 1 == newx && currenty + 1 == newy && !board[newx][newy].getPiece().getPlayer().getColor()) {
                this.getPlayer().captured(board[newx][newy].getPiece());
                return true;
            }
            if (currentx - 1 == newx && currenty + 1 == newy && !board[newx][newy].getPiece().getPlayer().getColor()) {
                this.getPlayer().captured(board[newx][newy].getPiece());
                return true;
            }
        }

        if(!this.getPlayer().getColor()) { //black
            if (currentx - 1 == newx && currenty - 1 == newy && board[newx][newy].getPiece().getPlayer().getColor()) {
                this.getPlayer().captured(board[newx][newy].getPiece());
                return true;
            }
            if (currentx + 1 == newx && currenty - 1 == newy && board[newx][newy].getPiece().getPlayer().getColor()) {
                this.getPlayer().captured(board[newx][newy].getPiece());
                return true;
            }
        }

        return false;

    }



}
