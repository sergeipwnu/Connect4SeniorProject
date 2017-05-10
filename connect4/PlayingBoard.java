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
    private int playerNum = 1;
    private int[][] board;
    private int placeBelow = 0;

    /**
     * Constructor for objects of class PlayingBoard
     * Omer
     */
    public PlayingBoard()
    {
        board = new int[ROW][COL]; //0 if no piece, 1 if player1, 2 if player2.
    }
    
    /**
     * OMER
     * 
     */
    public boolean areFourConnected(Position p)
    {
        int count =0;
        
        //horizontal
        for(int i =0; i < COL; i++)
        {
            if(board[p.getY()][i] == playerNum)
            {
                count++;
                if (count == 4) 
                    return true;
            }
            else
                count =0;  
        }
        
            
        //veritcal check
        for(int i = 0; i < ROW; i++)
        {
            if(board[i][p.getX()] == playerNum)
            {
                count++;
                if (count == 4) 
                    return true;
            }
            else
            {
                count =0;  
            }
        }
        
            
        return false;
    }
    
    /**
     *  Attempts to make a move at the given Position. If the move is possible, the move is made
     *  and makeMove() returns true. If a move is not possible, the user is prompted via the command
     *  line and makeMove() returns false
     * OMER
     */
    public boolean makeMove(Position p) 
    {
        placeBelow = 0;
        System.out.println(p);
        boolean b;
        
        if(board[p.getY()][p.getX()] > 0)
        {
            b = false;
            System.out.println("cant do that buddy");
        }
        else 
        {
            placeBelow = p.getY();
            while(placeBelow+1 < ROW && board[placeBelow+1][p.getX()] == 0)
            {
                placeBelow++;
            }
            
            board[placeBelow][p.getX()] = playerNum;
            if(areFourConnected(p))
            {
                System.out.println(">>>>>>>PLAYER " + playerNum + 
                                    " WINS<<<<<<<<<");
            }
            changePlayer();
            b = true;
        }
        
        System.out.println("board");
        for(int i =0; i < ROW; i++)
        {
             for(int j = 0; j<COL; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        
        
        return b;
    }
    
    /**
     * Changes playerNum into 1 if 2, and 2 if 1
     * Omer
     */
    private void changePlayer()
    {
        playerNum = (playerNum % 2) +1;
    }
    /**
     * returns placeBelow
     * Sergei
     */
    public int getDropOffset()
    {
        System.out.println(placeBelow);
        return placeBelow;
    }
    
}
