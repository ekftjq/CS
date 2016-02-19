package Chess.GUI;

import Chess.Board;
import Chess.GamePieces.GamePiece;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GUI implements ActionListener {
    JFrame window = new JFrame("Chess");
    JPanel Maingui = new JPanel();
    JPanel chessBoard = new JPanel(new GridLayout(0,8));
    JButton[][] chessBlocks = new JButton[8][8];

    static Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 60);

    public GUI(Board b) {
        Maingui = initializeBoard(b);
        window.add(Maingui);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel initializeBoard(Board b) {
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        Maingui.add(chessBoard);
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        Maingui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New"));
        tools.add(new JButton("Undo"));

        Insets margin = new Insets(0,0,0,0);
        for (int row = 0; row < chessBlocks.length; row++) {
            for (int column = 0; column < chessBlocks[row].length; column++) {
                JButton block = new JButton();
                block.setMargin(margin);
                block.setFont(font);
                //fill blocks with transparent icons
                //ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                //block.setIcon(icon);
                //System.out.print(row);
                //System.out.print(column);
                //System.out.println((row+column) % 2);
                if(b.blocks[row][column].getPiece() != null) {
                    block.setText(typeChecker(b.blocks[row][column].getPiece().getType(), b.blocks[row][column].getPiece().getPlayer().getColor()));
                    block.setHorizontalAlignment(SwingConstants.CENTER);

                }
                if ((row + column) % 2 == 0) { //odd blocks are black because we start from top left
                    block.setBackground(Color.WHITE);
                }
                else {
                    block.setBackground(Color.GRAY);
                }

                chessBlocks[row][column] = block;
                Action mouseHandler = new Action();
                block.addMouseListener(mouseHandler);
                block.addMouseMotionListener(mouseHandler);
            }
        }

        //fill the board
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                chessBoard.add(chessBlocks[column][row]);
                }
            }

        return Maingui;
    }

    private static class Action implements MouseInputListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    private String typeChecker(GamePiece.PieceType piece, boolean white) {
        if(white) {
            if (piece.equals(GamePiece.PieceType.PAWN)) {
                return "\u2659";
            }
            if (piece.equals(GamePiece.PieceType.ROOK)) {
                return "\u2656";
            }
            if (piece.equals(GamePiece.PieceType.KNIGHT)) {
                return "\u2658";
            }
            if (piece.equals(GamePiece.PieceType.BISHOP)) {
                return "\u2657";
            }
            if (piece.equals(GamePiece.PieceType.KING)) {
                return "\u2654";
            }
            if (piece.equals(GamePiece.PieceType.QUEEN)) {
                return "\u2655";
            }
        }

        if(!white) {
            if (piece.equals(GamePiece.PieceType.PAWN)) {
                return "\u265F";
            }
            if (piece.equals(GamePiece.PieceType.ROOK)) {
                return "\u265C";
            }
            if (piece.equals(GamePiece.PieceType.KNIGHT)) {
                return "\u265E";
            }
            if (piece.equals(GamePiece.PieceType.BISHOP)) {
                return "\u265D";
            }
            if (piece.equals(GamePiece.PieceType.KING)) {
                return "\u265A";
            }
            if (piece.equals(GamePiece.PieceType.QUEEN)) {
                return "\u265B";
            }
        }
        /*if(piece.getType().equals(GamePiece.PieceType.SUPERPAWN)) {
            return GamePiece.PieceType.SUPERPAWN;
        }
        if(piece.getType().equals(GamePiece.PieceType.ROOKKNIGHT)) {
            return GamePiece.PieceType.ROOKKNIGHT;
        }
        Custom Pieces, maybe implemented later
        */
        return "no type";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
