package Chess;

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
}