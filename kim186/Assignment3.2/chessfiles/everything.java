<p id="p1">package Chess;

           import Chess.GamePieces.GamePiece;

           /**
            * Created by Moon on 2/4/2016
            * Each Block in the board will either have a GamePiece or be empty
            * Each block has its position x and yasdfasdfsa
            *
            */
           public class Block {
               public GamePiece Piece;

               public Block() {

               }

               public GamePiece getPiece() {
                   return this.Piece;
               }

               public void setPiece(GamePiece piece) {
                   this.Piece = piece;
               }
           }
</p>
<p id="p2">package Chess;

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

           }</p>
<p id="p3">package Chess;

           import Chess.GamePieces.GamePiece;
           import org.junit.Test;

           import static org.junit.Assert.*;

           /**
            * Created by moons on 2/5/2016.
            */
           public class BoardTest {

               @Test
               public void testmove() throws Exception {
                   Board b = new Board();
                   //move pawn in 1,1 to 1,3
                   b.move(1, 1, 1, 3);
                   assertEquals(b.blocks[1][1].getPiece(), null);
                   assertEquals(b.blocks[1][3].getPiece().getType(), GamePiece.PieceType.PAWN);
                   assertEquals(b.blocks[1][3].Piece.ValidMove(b.blocks, 1, 3, 1, 4), true);
                   assertEquals(b.blocks[1][3].Piece.ValidMove(b.blocks, 1, 3, 1, 5), false);
                   //move bishop after pawn has moved
                   assertEquals(b.blocks[2][0].Piece.ValidMove(b.blocks, 2, 0, 0, 2), true);
               }

               @Test
               public void testCapture() throws Exception {
                   Board b = new Board();
                   b.move(3, 1, 3, 3);
                   b.move(3, 0, 3, 2);
                   b.move(3, 2, 7, 6);
                   boolean deadpawn = b.white.getDeadPieces().get(0).getType().equals(GamePiece.PieceType.PAWN);
                   assertEquals(deadpawn, true);
               }

               @Test
               public void testCheck() throws Exception {
                   Board b = new Board();
                   EndGame End = new EndGame();
                   b.move(4, 6, 4, 4);
                   b.move(3, 1, 3, 3);
                   b.move(3, 3, 4, 4);
                   b.move(3, 6, 3, 5);
                   b.move(4, 4, 3, 5);
                   b.move(3, 0, 3, 2);
                   //b.move(b, 3, 7, 4, 6);
                   b.move(4, 7, 4, 6);
                   //b.move(b, 4, 6, 5, 5);
                   assertEquals(End.CheckChecker(b, b.white), true);
                   assertEquals(End.CheckMate(b, b.white, End.CheckChecker(b, b.white)), false);
               }

               @Test
               public void testCheckMate() throws Exception {
                   Board b = new Board();
                   EndGame End = new EndGame();
                   b.move(5, 6, 5, 5);
                   b.move(4, 1, 4, 3);
                   b.move(6, 6, 6, 4);
                   b.move(3, 0, 7, 4);
                   assertEquals(End.CheckMate(b, b.white, End.CheckChecker(b, b.white)), true);
               }

               @Test
               public void testStaleMate() throws Exception {
                   Board b = new Board();
                   EndGame End = new EndGame();
                   b.move(2, 6, 2, 4);
                   b.move(7, 1, 7, 3);
                   b.move(7, 6, 7, 4);
                   b.move(0, 1, 0, 3);
                   b.move(3, 7, 0, 4);
                   b.move(0, 0, 0, 2);
                   b.move(0, 4, 0, 3);
                   b.move(0, 2, 7, 2);
                   b.move(0, 3, 2, 1);
                   b.move(5, 1, 5, 2);
                   b.move(2, 1, 3, 1);
                   b.move(4, 0, 5, 1);
                   b.move(3, 1, 1, 1);
                   b.move(3, 0, 3, 5);
                   b.move(1, 1, 1, 0);
                   b.move(3, 5, 7, 1);
                   b.move(1, 0, 2, 0);
                   b.move(5, 1, 6, 2);
                   b.move(2, 0, 4, 2);
                   assertEquals(End.StaleMate(End.CheckChecker(b, b.black), End.CheckMate(b, b.black, End.CheckChecker(b, b.black))), true);
               }
           }</p>
<p id="p4"package Chess;

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
</p>