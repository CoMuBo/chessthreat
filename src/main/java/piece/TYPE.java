package piece;

import misc.Position;

public enum TYPE {
    KNIGHT, ROOK, BISHOP;

    /**
     * method to fetch a new instance of the current piece-type
     *
     * @param position the position where the new  piece should sit on
     * @return a instance of the current type (extends Piece) with the given position
     */
    public Piece getNewInstance(Position position) {
        switch (this) {
            case KNIGHT:
                return new Knight(position);
            case ROOK:
                return new Rook(position);
            case BISHOP:
                return new Bishop(position);
            default:
                return null;
        }
    }
}
