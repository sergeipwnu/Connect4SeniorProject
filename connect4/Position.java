 /**
  * class <code>Position</code> - a custom class for storing an x and y coordinantes 
  * that corresponds to the location of a piece on the board
  * 
  * @author Sergei Levashov
  * @version 1.0.0
  */
public class Position
{
    private int myX;
    private int myY;
    /**
     * constructor <code>Position</code> - initializes local y and x to passed variables
     * 
     * @param int y : y-value of the coordinate
     * @param int x : x-value of the coordinate
     * @author Sergei Levashov
     */
    Position(int y, int x)
    {
        myX = x;
        myY = y;
    }
    
    /**
     * @Override
     * 
     * <code>toString()</code> <b>summary</b>: will make a <code>String</code> with the coordinate notation
     * 
     * @return String -- (x, y)
     * @author Omer
     */
    public String toString()
    {
        return "(" + myX +", " + myY + ")";
    }
    
    /**
     * <code>getX()</code> <b>summary</b>: will return the x-value of the coordinate
     * 
     * @return int myX
     * @author Sergei Levashov
     */
    public int getX()
    {
        return myX;
    }
    
    /**
     * <code>getY()</code> <b>summary</b>: will return the y-value of the coordinate
     * 
     * @return int myY
     * @author Sergei Levashov
     */
    public int getY()
    {
        return myY;
    }
}
