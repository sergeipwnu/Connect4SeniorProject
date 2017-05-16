 /**
     * A custom class for storing an x and y that corresponds to the location of a peice
     * Sergei Levashov
     */
public class Position
{
    private int x;
    private int y;
     /**
     * Initializes local y and x to passed variables
     * Sergei Levashov
     */
    Position(int yy, int xx)
    {
        x = xx;
        y = yy;
    }
    /**
     * toString() that prints the x,y
     * Omer
     */
    public String toString()
    {
        return "(" + x +", " + y + ")";
    }
     /**
     * getter for local X
     * Sergei Levashov
     */
    public int getX()
    {
        return x;
    }
    /**
     * getter for local Y
     * Sergei Levashov
     */
    public int getY()
    {
        return y;
    }
}
