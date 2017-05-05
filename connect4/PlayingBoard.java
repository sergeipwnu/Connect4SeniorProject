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
    private int playerNum = 1;
    private int[][] moves;

    /**
     * Constructor for objects of class PlayingBoard
     */
    public PlayingBoard()
    {
        moves = new int[ROW][COL];
    }
    
    /**
     * 
     */
    public boolean areFourConnected()
    {
        //this will be checked and update the variable connect4 after every time makeMove is successful
        return true;
    }
    
    /**
     * 
     */
    public boolean makeMove(Position p) 
    {
        if(moves[p.y][p.x] > 0)
        {
            return false;
        }
        else
        {
            int below = p.y;
            
            while(below+1 <= ROW && moves[below][p.x] == 0)
                below++;
            
            moves[below][p.x] = playerNum;
            changePlayer();
            
            return true;
        }
    }
    
    /**
     * 
     */
    private void changePlayer()
    {
        playerNum = (playerNum % 2) +1;
    }
    
}
