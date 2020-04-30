import misc.Board;
import misc.Position;
import misc.Scenario;
import piece.Piece;
import misc.COLOR;
import piece.TYPE;

import java.util.ArrayList;
import java.util.List;

public class LogicalGenerator {
    /**
     * This method generates all possible scenarios for the defined board-sice for two pieces (of same or different type)
     * In this implementation the white piece is set on each field on the board, on each field all possible moves are
     * generated. In case the pieces don't are from the same type, also the other way arround is checked
     *
     * @param whitePieceType type of the white piece
     * @param blackPieceType type of the black piece
     * @return a list with all Scenarios which are possible for this combination of pieces
     */
    public List<Scenario> run(TYPE whitePieceType, TYPE blackPieceType) {
        if (whitePieceType == null || blackPieceType == null) {
            throw new IllegalArgumentException("Type must not be null");
        }

        List<Scenario> resultList = new ArrayList();

        // run over all positions on the full board
        for (Position positionWhite : Board.getAllPositions()) {

            // get a new instance of the given type for the white piece and set it to the current position
            Piece whitePiece = whitePieceType.getNewInstance(positionWhite);

            // generate all possible destinations for this piece on the specific position (depending on the type)
            List<Position> possibleDestinations = whitePiece.getPossibleDestinations();

            // go over all possible destinations for the white piece
            for (Position position : possibleDestinations) {

                // create a new instance of the given type for the black piece and check the way back
                Piece blackPiece = blackPieceType.getNewInstance(position);
                if (!blackPiece.isMoveAllowed(positionWhite)) {
                    // the way back (black-> white) doesn't work
                    continue;
                }

                // put positions into a scenario, add it to result
                Scenario scenario = new Scenario();
                scenario.addPiece(COLOR.WHITE, whitePiece);
                scenario.addPiece(COLOR.BLACK, blackPiece);
                resultList.add(scenario);
            }
        }
        return resultList;
    }
}
