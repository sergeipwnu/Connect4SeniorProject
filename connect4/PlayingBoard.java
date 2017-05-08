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

    /**
     * Constructor for objects of class PlayingBoard
     */
    public PlayingBoard()
    {
        board = new int[ROW][COL]; //0 if no piece, 1 if player1, 2 if player2.
    }
    
    /**
     * OMER
     * from  http://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm 
     * by ferdelOlmo
     */
    public boolean areFourConnected()
    {
        // horizontalCheck 
        for (int j = 0; j< ROW-3 ; j++ )
        {
            for (int i = 0; i< COL; i++)
            {
                if (board[i][j] == playerNum && board[i][j+1] == playerNum &&
                    board[i][j+2] == playerNum && board[i][j+3] == playerNum)
                {
                    return true;
                }           
            }
        }
        // verticalCheck
        for (int i = 0; i< COL-3 ; i++ )
        {
            for (int j = 0; j< ROW; j++)
            {
                if (board[i][j] == playerNum && board[i+1][j] == playerNum &&
                    board[i+2][j] == playerNum && board[i+3][j] == playerNum)
                {
                    return true;
                }           
            }
        }
        // ascendingDiagonalCheck 
        for (int i=3; i< COL; i++)
        {
            for (int j=0; j<ROW-3; j++)
            {
                if (board[i][j] == playerNum && board[i-1][j+1] == playerNum && 
                    board[i-2][j+2] == playerNum && board[i-3][j+3] == playerNum)
                    return true;
            }
        }
        // descendingDiagonalCheck
        for (int i=3; i< COL; i++){
            for (int j=3; j< ROW; j++){
                if (board[i][j] == playerNum && board[i-1][j-1] == playerNum && 
                    board[i-2][j-2] == playerNum && board[i-3][j-3] == playerNum)
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * TO BE TESTED WHEN GAMEPLAY IMPLEMENTED
     * OMER
     */
    public boolean makeMove(Position p) 
    {
        System.out.println(p);
        boolean b;
        
        if(board[p.y][p.x] > 0)
        {
            b = false;
            System.out.println("cant do that buddy");
        }
        else 
        {
            
            int placeBelow = p.y;
            while(placeBelow+1 < ROW && board[placeBelow+1][p.x] == 0)
            {
                placeBelow++;
            }
            
            board[placeBelow][p.x] = playerNum;
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
     * 
     */
    private void changePlayer()
    {
        playerNum = (playerNum % 2) +1;
    }

    
}
