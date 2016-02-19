package Chess.GamePieces;

import Chess.Board;
import Chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moons on 2/5/2016.
 */
public class GamePieceTest {

    Board b = new Board();
    Board custom = new Board(true, true);

    @Test
    public void testValidMovePawn() throws Exception {
        assertEquals(b.blocks[0][1].Piece.ValidMove(b.blocks, 0, 1, 0, 3), true);
        assertEquals(b.blocks[0][1].getPiece().getType(), GamePiece.PieceType.PAWN);
    }

    @Test
    public void testValidMovePawnInvalid() throws Exception {
        assertEquals(b.blocks[0][1].Piece.ValidMove(b.blocks, 0, 1, 0, 4), false);
    }

    @Test
    public void testValidMoveKnight() throws Exception {
        assertEquals(b.blocks[1][0].Piece.ValidMove(b.blocks, 1, 0, 0, 2), true);
        assertEquals(b.blocks[1][0].Piece.ValidMove(b.blocks, 1, 0, 2, 2), true);
    }

    @Test
    public void testValidMoveBishop() throws Exception {
        assertEquals(b.blocks[2][0].getPiece().getType(), GamePiece.PieceType.BISHOP);
        assertEquals(b.blocks[2][0].Piece.ValidMove(b.blocks, 2, 0, 1, 1), false);
    }

    @Test
    public void testValidMoveKing() throws Exception {
        assertEquals(b.blocks[3][0].getPiece().getType(), GamePiece.PieceType.KING);
        assertEquals(b.blocks[3][0].Piece.ValidMove(b.blocks, 3, 0, 3, 1), false);
        b.move(b.blocks, 3, 1, 3, 3);
        assertEquals(b.blocks[3][0].Piece.ValidMove(b.blocks, 3, 0, 3, 1), true);
    }

    @Test
    public void testValidMoveQueen() throws Exception {
        assertEquals(b.blocks[4][0].getPiece().getType(), GamePiece.PieceType.QUEEN);
        b.move(b.blocks, 4, 1, 4, 3);
        assertEquals(b.blocks[4][0].Piece.ValidMove(b.blocks, 4, 0, 4, 2), true);
        b.move(b.blocks, 4, 0, 4, 2);
        assertEquals(b.blocks[4][2].Piece.ValidMove(b.blocks, 4, 2, 7, 5), true);
    }

    @Test
    public void testValidMoveSuperPawn() throws Exception {
        assertEquals(custom.blocks[0][1].Piece.ValidMove(custom.blocks, 0, 1, 0, 3), true);
        custom.move(custom.blocks, 0, 1, 0, 3);
        assertEquals(custom.blocks[0][3].Piece.ValidMove(custom.blocks, 0, 3, 0, 5), true);
        custom.move(custom.blocks, 0, 3, 0, 5);
    }

    @Test
    public void testValidMoveRookKnight() throws Exception {
        assertEquals(custom.blocks[1][0].Piece.ValidMove(custom.blocks, 1, 0, 2, 2), true);
        custom.move(custom.blocks, 1, 0, 2, 2);
        assertEquals(custom.blocks[2][2].Piece.ValidMove(custom.blocks, 2, 2, 2, 5), true);
        custom.move(custom.blocks, 2, 2, 2, 5);
    }
}