package Chess;

/**
 * Created by Moon on 2/1/2016.
 * Chess Main Function
 * Currently just showing Piece types for checking
 */
public class GameMain {

    public static void main(String[] args) {
        Board b = new Board();
        /*
        for (int i = 0; i < b.row; i++) {
            for (int j = 0; j < b.column; j++) {
                if(b.blocks[i][j].getPiece() != null) {
                    System.out.println(b.blocks[i][j].getPiece().getType());
                }
            }
        }
        */
        System.out.println(b.blocks[2][0].getPiece().getType());
        System.out.println(b.blocks[2][0].Piece.ValidMove(b.blocks, 2, 0, 1, 1));
        b.move(b.blocks, 1, 1, 1, 3);
        System.out.println(b.blocks[1][3].getPiece().getType());
        System.out.println(b.blocks[2][0].Piece.ValidMove(b.blocks, 2, 0, 1, 1));
        b.move(b.blocks, 2, 6, 2, 4);
        System.out.println(b.blocks[2][4].getPiece().getType());
        System.out.println(b.blocks[1][3].Piece.ValidMove(b.blocks, 1, 3, 2, 4));
        System.out.println(b.white.getDeadPieces());
        }

    }
