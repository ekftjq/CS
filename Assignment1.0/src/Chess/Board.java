package Chess;

/**
 * CS 242 Chess Project
 * Spring 2016
 * Created by Moon
 */

import Chess.GamePieces.*;

/** 8 by 8 board initialized with starting positions
 * Board is a collection of blocks
 *
 */
public class Board {
    int row = 8;
    int column = 8;
    public Block[][] blocks;
    public Player white;
    public Player black;
    //Player black = new Player(false);

    public Board() {
        blocks = new Block[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                blocks[r][c] = new Block();
            }
        }
        initializeBoard();
    }

    private void initializeBoard() {
        white = new Player(true);
        for (int r = 0; r < row; r++) {
            blocks[r][1].Piece = new Pawn(white, GamePiece.PieceType.PAWN, r, 1);
        }
        blocks[0][0].Piece = new Rook(white, GamePiece.PieceType.ROOK, 0, 0);
        blocks[1][0].Piece = new Knight(white, GamePiece.PieceType.KNIGHT, 1, 0);
        blocks[2][0].Piece = new Bishop(white, GamePiece.PieceType.BISHOP, 2, 0);
        blocks[3][0].Piece = new King(white, GamePiece.PieceType.KING, 3, 0);
        blocks[4][0].Piece = new Queen(white, GamePiece.PieceType.QUEEN, 4, 0);
        blocks[5][0].Piece = new Bishop(white, GamePiece.PieceType.BISHOP, 5, 0);
        blocks[6][0].Piece = new Knight(white, GamePiece.PieceType.KNIGHT, 6, 0);
        blocks[7][0].Piece = new Rook(white, GamePiece.PieceType.ROOK, 7, 0);

        black = new Player(false);
        for (int r = 0; r < row; r++) {
            blocks[r][6].Piece = new Pawn(black, GamePiece.PieceType.PAWN, r, 6);
        }
        blocks[0][7].Piece = new Rook(black, GamePiece.PieceType.ROOK, 0, 7);
        blocks[1][7].Piece = new Knight(black, GamePiece.PieceType.KNIGHT, 1, 7);
        blocks[2][7].Piece = new Bishop(black, GamePiece.PieceType.BISHOP, 2, 7);
        blocks[3][7].Piece = new King(black, GamePiece.PieceType.KING, 3, 7);
        blocks[4][7].Piece = new Queen(black, GamePiece.PieceType.QUEEN, 4, 7);
        blocks[5][7].Piece = new Bishop(black, GamePiece.PieceType.BISHOP, 5, 7);
        blocks[6][7].Piece = new Knight(black, GamePiece.PieceType.KNIGHT, 6, 7);
        blocks[7][7].Piece = new Rook(black, GamePiece.PieceType.ROOK, 7, 7);
    }

    public boolean move(Block[][] board, int currentx, int currenty, int newx, int newy) {
        if (board[currentx][currenty].getPiece() != null) {
            if (board[currentx][currenty].Piece.ValidMove(board, currentx, currenty, newx, newy)) {
                board[newx][newy].Piece = board[currentx][currenty].Piece;
                board[currentx][currenty].Piece = null;
                return true;
            }
        }
        return false;
    }

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

    public boolean CheckChecker(Board b, Player p) {
        if (p.getColor()) {
            //check if any Piece can land on the King's position
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (b.blocks[r][c].getPiece() != null && b.blocks[r][c].getPiece().ValidMove(b.blocks, r, c, WhiteKing(b)[0], WhiteKing(b)[1])) {
                        return true;
                    }
                }
            }
        }
        if (!p.getColor()) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (b.blocks[r][c].getPiece() != null && b.blocks[r][c].getPiece().ValidMove(b.blocks, r, c, BlackKing(b)[0], BlackKing(b)[1])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean CheckMate(Board b, Player p, boolean check) {
        if (check && p.getColor()) {
            if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] + 1, WhiteKing(b)[1] + 1)) {
                if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] - 1, WhiteKing(b)[1] - 1)) {
                    if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] + 1, WhiteKing(b)[1] - 1)) {
                        if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] - 1, WhiteKing(b)[1] + 1)) {
                            if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0], WhiteKing(b)[1] + 1)) {
                                if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0], WhiteKing(b)[1] - 1)) {
                                    if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] - 1, WhiteKing(b)[1])) {
                                        if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] + 1, WhiteKing(b)[1])) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (check && !p.getColor()) {
            if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] + 1, BlackKing(b)[1] + 1)) {
                if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] - 1, BlackKing(b)[1] - 1)) {
                    if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] + 1, BlackKing(b)[1] - 1)) {
                        if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] - 1, BlackKing(b)[1] + 1)) {
                            if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0], BlackKing(b)[1] + 1)) {
                                if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0], BlackKing(b)[1] - 1)) {
                                    if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] - 1, BlackKing(b)[1])) {
                                        if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] + 1, BlackKing(b)[1])) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean StaleMate(Board b, Player p, boolean check) {
        if (!check && p.getColor()) {
            if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] + 1, WhiteKing(b)[1] + 1)) {
                if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] - 1, WhiteKing(b)[1] - 1)) {
                    if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] + 1, WhiteKing(b)[1] - 1)) {
                        if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] - 1, WhiteKing(b)[1] + 1)) {
                            if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0], WhiteKing(b)[1] + 1)) {
                                if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0], WhiteKing(b)[1] - 1)) {
                                    if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] - 1, WhiteKing(b)[1])) {
                                        if (!b.blocks[WhiteKing(b)[0]][WhiteKing(b)[1]].getPiece().ValidMove(b.blocks, WhiteKing(b)[0], WhiteKing(b)[1], WhiteKing(b)[0] + 1, WhiteKing(b)[1])) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!check && !p.getColor()) {
            if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] + 1, BlackKing(b)[1] + 1)) {
                if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] - 1, BlackKing(b)[1] - 1)) {
                    if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] + 1, BlackKing(b)[1] - 1)) {
                        if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] - 1, BlackKing(b)[1] + 1)) {
                            if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0], BlackKing(b)[1] + 1)) {
                                if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0], BlackKing(b)[1] - 1)) {
                                    if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] - 1, BlackKing(b)[1])) {
                                        if (!b.blocks[BlackKing(b)[0]][BlackKing(b)[1]].getPiece().ValidMove(b.blocks, BlackKing(b)[0], BlackKing(b)[1], BlackKing(b)[0] + 1, BlackKing(b)[1])) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}