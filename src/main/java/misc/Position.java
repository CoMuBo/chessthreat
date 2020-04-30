package misc;

public class Position {

    protected final int x;
    protected final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Overrides the equals-Method to be able to check if the Position is in a List/Map
     * For this only x/y positions are considered
     *
     * @param o the object which should be compared to this
     * @return true if the x/y positions equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Position)) {
            return false;
        }
        // Positions equal if the x- and y-positions equals
        if (x != ((Position) o).getX() || y != ((Position) o).getY()) {
            return false;
        }
        return true;
    }

}
