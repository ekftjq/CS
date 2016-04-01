package Chess;

/**
 * CS 242 Chess Project
 * Spring 2016
 * Created by Moonadsfasdf
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
    public Player white = new Player(true);
    public Player black = new Player(false);
    public static int CurrentPlayer;
    public static int CurrentState;

    public static final int NOACTION = -1;
    public static final int ONGOING = 0;
    public static final int BLACKWIN = 1;
    public static final int WHITEWIN = 2;
    public static final int WHITE = 0;
    public static final int BLACK = 1;

    public Board() {
        blocks = new Block[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                blocks[r][c] = new Block();
            }
        }
        initializeRook();
        initializePawn();
        initializeKnight();
        initializeBishop();
        initializeKing();
        initializeQueen();
        CurrentPlayer = WHITE;
        CurrentState = NOACTION;
    }

    public Board(Board b) { //copy constructor
        blocks = b.blocks;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                blocks[r][c] = b.blocks[r][c];
            }
        }
    }

    public Board(boolean RookKnight, boolean SuperPawn) {
        blocks = new Block[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                blocks[r][c] = new Block();
            }
        }
        if(SuperPawn) {
            initializeSuperPawn();
        }
        else {
            initializePawn();
        }
        if(RookKnight) {
            initializeRookKnight();
        }
        else {
            initializeKnight();
        }
        initializeRook();
        initializeBishop();
        initializeKing();
        initializeQueen();
    }

    private void initializeSuperPawn() {
        for (int r = 0; r < row; r++) {
            blocks[r][1].setPiece(new SuperPawn(black, GamePiece.PieceType.SUPERPAWN, r, 1));
        }

        for (int r = 0; r < row; r++) {
            blocks[r][6].setPiece(new SuperPawn(white, GamePiece.PieceType.SUPERPAWN, r, 6));
        }
    }

    private void initializeRookKnight() {
        blocks[1][0].setPiece(new RookKnight(black, GamePiece.PieceType.ROOKKNIGHT, 1, 0));
        blocks[6][0].setPiece(new RookKnight(black, GamePiece.PieceType.ROOKKNIGHT, 6, 0));
        blocks[1][7].setPiece(new RookKnight(white, GamePiece.PieceType.ROOKKNIGHT, 1, 7));
        blocks[6][7].setPiece(new RookKnight(white, GamePiece.PieceType.ROOKKNIGHT, 6, 7));
    }

    private void initializeQueen() {
        blocks[3][0].setPiece(new Queen(black, GamePiece.PieceType.QUEEN, 3, 0));
        blocks[3][7].setPiece(new Queen(white, GamePiece.PieceType.QUEEN, 3, 7));
    }

    private void initializeKing() {
        blocks[4][0].setPiece(new King(black, GamePiece.PieceType.KING, 4, 0));
        blocks[4][7].setPiece(new King(white, GamePiece.PieceType.KING, 4, 7));
    }

    private void initializeKnight() {
        blocks[1][0].setPiece(new Knight(black, GamePiece.PieceType.KNIGHT, 1, 0));
        blocks[6][0].setPiece(new Knight(black, GamePiece.PieceType.KNIGHT, 6, 0));
        blocks[1][7].setPiece(new Knight(white, GamePiece.PieceType.KNIGHT, 1, 7));
        blocks[6][7].setPiece(new Knight(white, GamePiece.PieceType.KNIGHT, 6, 7));
    }

    private void initializePawn() {
        for (int r = 0; r < row; r++) {
            blocks[r][1].setPiece(new Pawn(black, GamePiece.PieceType.PAWN, r, 1));
        }

        for (int r = 0; r < row; r++) {
            blocks[r][6].setPiece(new Pawn(white, GamePiece.PieceType.PAWN, r, 6));
        }
    }

    private void initializeRook() {
        blocks[0][0].setPiece(new Rook(black, GamePiece.PieceType.ROOK, 0, 0));
        blocks[7][0].setPiece(new Rook(black, GamePiece.PieceType.ROOK, 7, 0));
        blocks[0][7].setPiece(new Rook(white, GamePiece.PieceType.ROOK, 0, 7));
        blocks[7][7].setPiece(new Rook(white, GamePiece.PieceType.ROOK, 7, 7));
    }

    private void initializeBishop() {
        blocks[2][0].setPiece(new Bishop(black, GamePiece.PieceType.BISHOP, 2, 0));
        blocks[5][0].setPiece(new Bishop(black, GamePiece.PieceType.BISHOP, 5, 0));
        blocks[2][7].setPiece(new Bishop(white, GamePiece.PieceType.BISHOP, 2, 7));
        blocks[5][7].setPiece(new Bishop(white, GamePiece.PieceType.BISHOP, 5, 7));
    }

    /**
     * Moves the Piece from one block to another
     * @param currentx Current location of x
     * @param currenty Current location of y
     * @param newx New location of x
     * @param newy New location of y
     * @return Whether move was successful or not
     */
    public boolean move(int currentx, int currenty, int newx, int newy) {
        if (this.blocks[currentx][currenty].getPiece() != null) {
            if (this.blocks[currentx][currenty].getPiece().ValidMove(this.blocks, currentx, currenty, newx, newy)) {
                this.blocks[newx][newy].setPiece(this.blocks[currentx][currenty].getPiece());
                this.blocks[newx][newy].getPiece().setCurrentx(newx);
                this.blocks[newx][newy].getPiece().setCurrenty(newy);
                this.blocks[currentx][currenty].setPiece(null);
                return true;
            }
        }
        return false;
    }

    public void switchPlayer() {
        if(CurrentPlayer == WHITE) {
            CurrentPlayer = BLACK;
        }
        else {
            CurrentPlayer = WHITE;
        }
    }

}