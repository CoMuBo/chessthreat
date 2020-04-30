import misc.Board;
import misc.Position;
import misc.Scenario;
import piece.Piece;
import misc.COLOR;
import piece.TYPE;

import java.util.ArrayList;
import java.util.List;

public class TryAndErrorGenerator {

    /**
     * This method generates all possible scenarios for the defined board-size for two pieces (of same or different type)
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

        // run over all possible positions on the board (for the white piece)
        for (Position positionWhite : Board.getAllPositions()) {

            // run over all possible positions on the board (for the black piece)
            for (Position positionBlack : Board.getAllPositions()) {
                if (positionWhite.equals(positionBlack)) {
                    // both can't have the same position
                    continue;
                }
                // get two new instances by the given types
                Piece whitePiece = whitePieceType.getNewInstance(positionWhite);
                Piece blackPiece = whitePieceType.getNewInstance(positionBlack);

                // check if both moves (white->black and black->white) are allowed
                if (whitePiece.isMoveAllowed(blackPiece)
                        && blackPiece.isMoveAllowed(whitePiece)) {

                    // put positions in a scenario and add it to the result
                    Scenario scenario = new Scenario();
                    scenario.addPiece(COLOR.WHITE, whitePiece);
                    scenario.addPiece(COLOR.BLACK, blackPiece);
                    resultList.add(scenario);
                }
            }
        }
        return resultList;
    }
}
