import javax.swing.*;
/**
 * Write a description of class PlayingBoard here.
 * 
 * @author OmerHananya
 * @version (a version number or a date)
 */
public class PlayingBoard 
{
    // instance variables - replace the example below with your own
    private final int ROW = 6;
    private final int COL = 7;
    private Piece[][] matrix;

    /**
     * Constructor for objects of class PlayingBoard
     */
    public PlayingBoard()
    {
        matrix = new Piece[ROW][COL];
    }
    
    /**
     * 
     */
    public boolean areFourConnected()
    {
        return true;
    }
    
    /**
     * 
     */
    public boolean makeMove(Piece p)
    {
        return true;
    }
    
}
