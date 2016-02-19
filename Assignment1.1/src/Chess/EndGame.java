package Chess;

import Chess.GamePieces.GamePiece;

/**
 * Created by moons on 2/19/2016.
 */

public class EndGame {
    int row = 8;
    int column = 8;

    /**
     * Finds the x and y of the White King's location
     * @param b The board we are playing on
     * @return x,y position of the White King
     */
    public int[] WhiteKing(Board b) {
        int[] whiteking = new int[2];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (b.blocks[r][c].getPiece() != null && b.blocks[r][c].getPiece().getPlayer().getColor()) {
                    if (b.blocks[r][c].getPiece().getType().equals(GamePiece.PieceType.KING)) {
                        whiteking[0] = b.blocks[r][c].getPiece().getCurrentx();
                        whiteking[1] = b.blocks[r][c].getPiece().getCurrenty();
                    }
                }
            }
        }
        return whiteking;
    }

    /**
     * Finds the x and y of the Black King's location
     * @param b The board we are playing on
     * @return x,y position of the Black King
     */
    public int[] BlackKing(Board b) {
        int[] blackking = new int[2];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (b.blocks[r][c].getPiece() != null && b.blocks[r][c].getPiece().getType().equals(GamePiece.PieceType.KING)) {
                    if (!b.blocks[r][c].getPiece().getPlayer().getColor()) {
                        blackking[0] = b.blocks[r][c].getPiece().getCurrentx();
                        blackking[1] = b.blocks[r][c].getPiece().getCurrenty();
                    }
                }
            }
        }
        return blackking;
    }

    /**
     * Checks if white or black is on check
     * @param b The board we are playing on
     * @param p The player we are checking for
     * @return If player is black and true, that means that black is current on check
     */
    public boolean CheckChecker(Board b, Player p) {
        int WhiteKingx = WhiteKing(b)[0];
        int WhiteKingy = WhiteKing(b)[1];
        int BlackKingx = BlackKing(b)[0];
        int BlackKingy = BlackKing(b)[1];

        if (p.getColor()) {
            //check if any Black Piece can land on the White King's position
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (b.blocks[r][c].getPiece() != null && !b.blocks[r][c].getPiece().getPlayer().getColor() && b.blocks[r][c].getPiece().ValidMove(b.blocks, r, c, WhiteKingx, WhiteKingy)) {
                        return true;
                    }
                }
            }
        }
        if (!p.getColor()) {
            //check if any White Piece can land on the Black King's position
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (b.blocks[r][c].getPiece() != null && b.blocks[r][c].getPiece().getPlayer().getColor() && b.blocks[r][c].getPiece().ValidMove(b.blocks, r, c, BlackKingx, BlackKingy)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean CheckMate(Board b, Player p, boolean check) {//if player is white and checkmate is true, that means white is in checkmate
        int WhiteKingx = WhiteKing(b)[0];
        int WhiteKingy = WhiteKing(b)[1];
        int BlackKingx = BlackKing(b)[0];
        int BlackKingy = BlackKing(b)[1];

        if (check && p.getColor()) {
            //currently in check and color is white
            for (int horizontal = -1; horizontal < 2; horizontal++) {
                for (int vertical = -1; vertical < 2; vertical++) {
                    if (b.blocks[WhiteKingx][WhiteKingy].getPiece().ValidMove(b.blocks, WhiteKingx, WhiteKingy, WhiteKingx + horizontal, WhiteKingy + vertical)) {
                        /* Check which blocks the king can move to.
                         * If the king can move, check if that block still puts the king on check
                         * If all of them yield check, then see if there is a piece that can move to prevent the check
                         */
                        b.move(WhiteKingx, WhiteKingy, WhiteKingx + horizontal, WhiteKingy + vertical);
                        if(!CheckChecker(b, p)) {
                            b.move(WhiteKingx + horizontal, WhiteKingy + vertical, WhiteKingx, WhiteKingy);
                            return false;
                        }
                        b.move(WhiteKingx + horizontal, WhiteKingy + vertical, WhiteKingx, WhiteKingy);
                    }
                }
            }
        }
        if (check && !p.getColor()) {
            for(int horizontal = -1; horizontal < 2; horizontal++) {
                for(int vertical = -1; vertical < 2; vertical ++) {
                    if(b.blocks[BlackKingx][BlackKingy].getPiece().ValidMove(b.blocks, BlackKingx, BlackKingy, BlackKingx + horizontal, BlackKingy + vertical)) {
                        b.move(BlackKingx, BlackKingy, BlackKingx + horizontal, BlackKingy + vertical);
                        if(!CheckChecker(b, p)) {
                            b.move(BlackKingx + horizontal, BlackKingy + vertical, BlackKingx, BlackKingy);
                            return false;
                        }
                        b.move(BlackKingx + horizontal, BlackKingy + vertical, BlackKingx, BlackKingy);
                    }
                }
            }
        }
        return true;
    }

    public boolean StaleMate(boolean check, boolean checkmate) {
        if (!check && checkmate) {
            return true;
        }
        return false;
    }
}
