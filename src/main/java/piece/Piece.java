package piece;

import misc.Position;

import java.util.List;

public abstract class Piece extends Position {

    /**
     * Constructor to create a new piece with the given position
     *
     * @param position
     */
    public Piece(Position position) {
        super(position.getX(), position.getY());
    }

    /**
     * method to get for the specific piece all possible destinations which can be reached from the current position
     * this method is used for the LogicalGenerator
     *
     * @return a list of new possible positions
     */
    public abstract List<Position> getPossibleDestinations();

    /**
     * method which checks for the specific piece if the move to the given position is allowed (based on current position)
     * this method is used for the TryAndErrorGenerator
     *
     * @param newPosition which should be checked
     * @return true if the move is allowed, false if not
     */
    public abstract boolean isMoveAllowed(Position newPosition);
}
