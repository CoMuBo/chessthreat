package piece;

import misc.Board;
import misc.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Position position) {
        super(position);
    }

    public List<Position> getPossibleDestinations() {
        List<Position> resultList = new ArrayList();
        // go over all possible x-positions
        for (int x = 0; x < Board.getXSize(); x++) {
            if (x == this.getX()) {
                // current x-position: ignore
                continue;
            }
            resultList.add(new Position(x, this.getY()));
        }
        // go over all possible y-positions
        for (int y = 0; y < Board.getYSize(); y++) {
            if (y == this.getY()) {
                // current y-position: ignore
                continue;
            }
            resultList.add(new Position(this.getX(), y));
        }
        return resultList;
    }

    public boolean isMoveAllowed(Position newPosition) {
        // Rook can only move horizontal/vertical, so x or y needs to stay the same
        return this.getX() == newPosition.getX() || this.getY() == newPosition.getY();
    }
}
