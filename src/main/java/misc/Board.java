package misc;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static int xSize;
    private static int ySize;

    public static void setBoard(int xSize, int ySize) {
        Board.xSize = xSize;
        Board.ySize = ySize;
    }

    public static int getXSize() {
        return xSize;
    }

    public static int getYSize() {
        return ySize;
    }


    /**
     * simple method to check if the given position is still inside of the board
     *
     * @param position position which should be checked
     * @return true if the given position is inside of the board, false if not
     */
    public static boolean isOnTheBoard(Position position) {
        if (position.getX() < 0 || position.getY() < 0) {
            return false;
        }
        if (position.getX() > xSize - 1 || position.getY() > ySize - 1) {
            return false;
        }
        return true;
    }

    /**
     * simple methode which returns a list of all possible positions inside the board
     *
     * @return a list of Position-objects, one for each field on the board
     */
    public static List<Position> getAllPositions() {
        List<Position> resultList = new ArrayList<Position>(xSize * ySize);
        for (int i = 0; i < xSize; i++) {
            for (int y = 0; y < xSize; y++) {
                resultList.add(new Position(i, y));
            }
        }
        return resultList;
    }
}