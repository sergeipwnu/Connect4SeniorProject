import javax.swing.*;
/**
 * Write a description of class PlayingBoard here.
 * 
 * @author OmerHananya
 * @version (a version number or a date)
 */
public class PlayingBoard 
{
    private final int ROW = 6;
    private final int COL = 7;
    private boolean connect4 = false;
    private int[][] moves;

    /**
     * Constructor for objects of class PlayingBoard
     */
    public PlayingBoard()
    {
        moves = new int[ROW][COL]; //0 if no piece, 1 if player1, 2 if player2.
    }
    
    /**
     * 
     */
    public boolean areFourConnected()
    {
        //this will be checked and update the variable connect4 after every time makemove is successful
        return true;
    }
    
    /**
     * 
     */
    public boolean makeMove(Position p) 
    {
        //Position is an object with a y and x value. change the value at y,x in the moves array
        //to true if the move is avaliable and if there is a Piece directly below
        
        return true;//return true if the move is possible, false if not
    }

    
}
