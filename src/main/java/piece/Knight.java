package piece;

import misc.Board;
import misc.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private static int[][] possibleSteps = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public Knight(Position position) {
        super(position);
    }

    public List<Position> getPossibleDestinations() {
        List<Position> resultList = new ArrayList();

        // go over static defined steps
        for (int i = 0; i < possibleSteps.length; i++) {
            // calculate the new positon based on the current step
            Position position = new Position(this.x + possibleSteps[i][0], this.y + possibleSteps[i][1]);
            // check if the calculated position is still on the board
            if (Board.isOnTheBoard(position)) {
                resultList.add(position);
            }
        }
        return resultList;
    }

    public boolean isMoveAllowed(Position newPosition) {
        // calculate steps per directed (based on the current position)
        int moveX = this.x - newPosition.getX();
        int moveY = this.y - newPosition.getY();

        // go over all (static defined) allowed steps and check if this move is allowed
        for (int i = 0; i < possibleSteps.length; i++) {
            if (possibleSteps[i][0] == moveX && possibleSteps[i][1] == moveY) {
                return true;
            }
        }
        return false;
    }
}
