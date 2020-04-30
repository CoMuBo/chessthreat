package piece;

import misc.Board;
import misc.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    // +/- factor to get the different directions
    private static int[] directionArray = {1, -1};

    public Bishop(Position position) {
        super(position);
    }

    public List<Position> getPossibleDestinations() {
        List<Position> resultList = new ArrayList();

        // go over both direction for x
        for (int xDirection : directionArray) {
            // go over both direction for y
            for (int yDirection : directionArray) {
                // for each direction go from the current position  til the end of the board and add them to the result
                for (int i = 1; x + xDirection * i >= 0 && x + xDirection * i < Board.getXSize()
                        && y + yDirection * i >= 0 && y + yDirection * i < Board.getXSize(); i++) {
                    resultList.add(new Position(x + xDirection * i, y + yDirection * i));
                }
            }
        }
        return resultList;
    }

    public boolean isMoveAllowed(Position newPosition) {
        int moveX = this.x - newPosition.getX();
        int moveY = this.y - newPosition.getY();
        // regardless in which direction, x and y needs to have the same (absolute) value
        return Math.abs(moveX) == Math.abs(moveY);
    }
}
