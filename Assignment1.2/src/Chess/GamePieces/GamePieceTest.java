package Chess.GamePieces;

import Chess.Board;
import Chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moons on 2/5/2016.
 */
public class GamePieceTest {

    @Test
    public void testValidMovePawn() throws Exception {
        Board b = new Board();
        assertEquals(b.blocks[0][1].Piece.ValidMove(b.blocks, 0, 1, 0, 3), true);
        assertEquals(b.blocks[0][1].getPiece().getType(), GamePiece.PieceType.PAWN);
    }

    @Test
    public void testValidMovePawnInvalid() throws Exception {
        Board b = new Board();
        assertEquals(b.blocks[0][1].Piece.ValidMove(b.blocks, 0, 1, 0, 4), false);
    }

    @Test
    public void testValidMoveKnight() throws Exception {
        Board b = new Board();
        assertEquals(b.blocks[1][0].Piece.ValidMove(b.blocks, 1, 0, 0, 2), true);
        assertEquals(b.blocks[1][0].Piece.ValidMove(b.blocks, 1, 0, 2, 2), true);
    }

    @Test
    public void testValidMoveBishop() throws Exception {
        Board b = new Board();
        assertEquals(b.blocks[2][0].getPiece().getType(), GamePiece.PieceType.BISHOP);
        assertEquals(b.blocks[2][0].Piece.ValidMove(b.blocks, 2, 0, 1, 1), false);
    }

    @Test
    public void testValidMoveKing() throws Exception {
        Board b = new Board();
        assertEquals(b.blocks[4][0].getPiece().getType(), GamePiece.PieceType.KING);
        assertEquals(b.blocks[4][0].Piece.ValidMove(b.blocks, 4, 0, 4, 1), false);
        b.move(4, 1, 4, 3);
        assertEquals(b.blocks[4][0].Piece.ValidMove(b.blocks, 4, 0, 4, 1), true);
    }

    @Test
    public void testValidMoveQueen() throws Exception {
        Board b = new Board();
        assertEquals(b.blocks[3][0].getPiece().getType(), GamePiece.PieceType.QUEEN);
        b.move(3, 1, 3, 3);
        assertEquals(b.blocks[3][0].Piece.ValidMove(b.blocks, 3, 0, 3, 2), true);
        b.move(3, 0, 3, 2);
        assertEquals(b.blocks[3][2].Piece.ValidMove(b.blocks, 3, 2, 6, 5), true);
    }

    @Test
    public void testValidMoveSuperPawn() throws Exception {
        Board custom = new Board(true, true);
        assertEquals(custom.blocks[0][1].Piece.ValidMove(custom.blocks, 0, 1, 0, 3), true);
        custom.move(0, 1, 0, 3);
        assertEquals(custom.blocks[0][3].Piece.ValidMove(custom.blocks, 0, 3, 0, 5), true);
        custom.move(0, 3, 0, 5);
    }

    @Test
    public void testValidMoveRookKnight() throws Exception {
        Board custom = new Board(true, true);
        assertEquals(custom.blocks[1][0].Piece.ValidMove(custom.blocks, 1, 0, 2, 2), true);
        custom.move(1, 0, 2, 2);
        assertEquals(custom.blocks[2][2].Piece.ValidMove(custom.blocks, 2, 2, 2, 5), true);
        custom.move(2, 2, 2, 5);
    }
}