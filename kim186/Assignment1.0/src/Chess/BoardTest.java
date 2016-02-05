package Chess;

import Chess.GamePieces.GamePiece;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moons on 2/5/2016.
 */
public class BoardTest {

    Board b = new Board();

    @Test
    public void testmove() throws Exception {
        //move pawn in 1,1 to 1,3
        b.move(b.blocks, 1, 1, 1, 3);
        assertEquals(b.blocks[1][1].getPiece(), null);
        assertEquals(b.blocks[1][3].getPiece().getType(), GamePiece.PieceType.PAWN);
        assertEquals(b.blocks[1][3].Piece.ValidMove(b.blocks, 1, 3, 1, 4), true);
        assertEquals(b.blocks[1][3].Piece.ValidMove(b.blocks, 1, 3, 1, 5), false);
        //move bishop after pawn has moved
        assertEquals(b.blocks[2][0].Piece.ValidMove(b.blocks, 2, 0, 0, 2), true);
    }

    @Test
    public void testCapture() throws Exception {
        b.move(b.blocks, 4, 1, 4, 3);
        b.move(b.blocks, 4, 0, 4, 2);
        b.move(b.blocks, 4, 2, 7, 5);
        assertEquals(b.blocks[7][5].Piece.ValidMove(b.blocks, 7, 5, 7, 6), true);
        boolean whiteempty = b.white.getDeadPieces() == null;
        assertEquals(whiteempty, false);
    }

    @Test
    public void testCheck() throws Exception {
        b.move(b.blocks, 3, 1, 3, 3);
        b.move(b.blocks, 4, 6, 4, 4);
        b.move(b.blocks, 4, 7, 4, 5);
        b.move(b.blocks, 4, 5, 2, 5);
        b.move(b.blocks, 2, 5, 2, 2);
        b.move(b.blocks, 2, 2, 3, 2);
        assertEquals(b.CheckChecker(b, b.white), true);
    }

    @Test
    public void testCheckMate() throws Exception {
        b.move(b.blocks, 3, 1, 3, 3);
        b.move(b.blocks, 4, 6, 4, 4);
        b.move(b.blocks, 4, 7, 4, 5);
        b.move(b.blocks, 4, 5, 2, 5);
        b.move(b.blocks, 2, 5, 2, 2);
        b.move(b.blocks, 2, 2, 3, 1);
        assertEquals(b.CheckMate(b, b.white, b.CheckChecker(b, b.white)), false);

        b.move(b.blocks, 3, 1, 3, 3);
        b.move(b.blocks, 4, 6, 4, 4);
        b.move(b.blocks, 4, 7, 4, 5);
        b.move(b.blocks, 4, 5, 2, 5);
        b.move(b.blocks, 2, 5, 2, 2);
        b.move(b.blocks, 2, 2, 3, 2);
        //assertEquals(b.CheckMate(b, b.white, b.CheckChecker(b, b.white)), true);
    }
}