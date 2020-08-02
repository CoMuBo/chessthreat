package piece;

import misc.Board;
import misc.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Position position) {
        super(position);
    }


    public List<Position> getPossibleDestinations() {
        List<Position> resultList = new ArrayList();

        // go over both direction for x
        for (int xDirection = -1; xDirection <= 1; xDirection++) {
            // go over both direction for y
            for (int yDirection =-1;yDirection<=1; yDirection++) {
                if(xDirection==0 && yDirection==0){
                    // x and y direction is 0 (no change in no direction..just continue)
                    continue;
                }
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
        if(this.x == newPosition.getX() && this.y != newPosition.getY()) {
            //  x keeps like is, move to left/right
            return true;
        }
        if (this.y == newPosition.getY() && this.x != newPosition.getX()) {
            //  y keeps like is, move up/down
            return true;
        }

        if(Math.abs(this.x - newPosition.getX()) == Math.abs(this.y-newPosition.getY())){
            // abs steps in x and y difference are the same
            return true;
        }

        return false;
    }
}
