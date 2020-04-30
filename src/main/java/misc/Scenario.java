package misc;

import piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Scenario {

    public final List<Piece> whitePieces = new ArrayList();
    public final List<Piece> blackPieces = new ArrayList();

    /**
     * simple method to add a piece to a specific color
     */
    public void addPiece(COLOR color, Piece piece) {
        switch (color) {
            case BLACK:
                blackPieces.add(piece);
                return;
            case WHITE:
                whitePieces.add(piece);
                return;
            default:
                return;
        }
    }

    /**
     * simple method which return the color of the piece which occupied the given position
     *
     * @param position position which should be checked
     * @return the color of the piece which currently occupied the given field..returns NONE if the field is empty
     */
    public COLOR whoOccupied(Position position) {
        if (whitePieces.contains(position)) {
            return COLOR.WHITE;
        } else if (blackPieces.contains(position)) {
            return COLOR.BLACK;
        } else {
            return COLOR.NONE;
        }
    }

    /**
     * Overrides the toString-Methods so it can be used for the visualisation
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Board.getXSize(); i++) {
            for (int j = 0; j < Board.getYSize(); j++) {
                switch (whoOccupied(new Position(i, j))) {
                    case WHITE:
                        sb.append("/ ");
                        break;
                    case BLACK:
                        sb.append("\\ ");
                        break;
                    case NONE:
                    default:
                        sb.append("o ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
