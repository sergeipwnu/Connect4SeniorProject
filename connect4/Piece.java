import javax.swing.*;
/**
 * Write a description of class Peice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piece extends JButton
{
    private int myY;
    private int myX;
    public Piece(int y, int x)
    {
        myX = x;
        myY = y;
    }
    public Piece()
    {
    }
    public Position getPosition()
    {
        return new Position(myY,myX);
    }
}
