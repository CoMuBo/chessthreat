import misc.Board;
import misc.Scenario;
import piece.TYPE;

import java.util.List;

public class ChessThreat {

    public static void main(String[] args) {

        // Setup-Parameter

        int xSize = 3;
        int ySize = 3;

        TYPE whitePieceType = TYPE.QUEEN;
        TYPE blackPieceType = TYPE.BISHOP;

        Board.setBoard(xSize, ySize);

        List<Scenario> possibleScenarios;


        long time = System.currentTimeMillis();

        // Option 1: check all combinations and keep valid moves
        // possibleScenarios = new TryAndErrorGenerator().run(whitePieceType, blackPieceType);

        // Option 2: set piece on every possible position on the board, check only valid moves
         possibleScenarios = new LogicalGenerator().run(whitePieceType, blackPieceType);

        time = System.currentTimeMillis() - time;


        // printout of the results
        int scenarioCounter = 0;
        for (Scenario scenario : possibleScenarios) {
            System.out.println(String.format("-- Scenario No. %d --", ++scenarioCounter));
            System.out.println(scenario.toString());
        }

        System.out.println(String.format("took %dms for %d scenarios", time, scenarioCounter));
    }


}
