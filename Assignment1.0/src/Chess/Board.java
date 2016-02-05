package Chess;

/**
 * CS 242 Chess Project
 * Spring 2016
 * Created by Moon
 */

import Chess.GamePieces.*;

/** 8 by 8 board initialized with starting positions
 *
 *
 */
public class Board {
    int row = 8;
    int column = 8;
    public Block[][] board;

    public Board() {
        board = new Block[row][column];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int r = 0; r < row; r++) {
            board[r][1].Piece = new Pawn();
        }
        board[0][0].Piece = new Rook();
        board[1][0].Piece = new Knight();
        board[2][0].Piece = new Bishop();
        board[3][0].Piece = new King();
        board[4][0].Piece = new Queen();
        board[5][0].Piece = new Bishop();
        board[6][0].Piece = new King();
        board[7][0].Piece = new Rook();

        for (int r = 0; r < row; r++) {
            board[r][6].Piece = new Pawn();
        }
        board[0][7].Piece = new Rook();
        board[1][7].Piece = new Knight();
        board[2][7].Piece = new Bishop();
        board[3][7].Piece = new King();
        board[4][7].Piece = new Queen();
        board[5][7].Piece = new Bishop();
        board[6][7].Piece = new King();
        board[7][7].Piece = new Rook();
    }


}
