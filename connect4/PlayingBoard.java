//import javax.swing.*;
/**
 * In this class we check whether or not one of the players won or not. This areFourConnnected
 * method is called after every move.
 * 
 * @author Zachary, Omer, Sergei
 * @version (1.0 --- June 2, 2017)
 */
public class PlayingBoard 
{
    private final int ROW = 6;//number of rows in board
    private final int COL = 7;//number of columns in board
    private int playerNum = 1;//represents which player's turn it is; starts at 1 (player 1)
    private int[][] board;//the playing board
    private int[][] winArray;//represents the winning 4 pieces
    private int[] newWinArray = new int[5];//represents the winArray matrix into an array
    private int placeBelow = 0;//used in getDropOffset() to determine the row position of the last placed piece

    /**
     * Constructor for objects of class PlayingBoard. board and winArray are instantiated to the
     * size of the board, ROW x COL
     * 
     * Zach
     */
    public PlayingBoard()
    {
        board = new int[ROW][COL]; //0 if no piece, 1 if player1, 2 if player2.
        winArray = new int[ROW][COL];//entire matrix which stores the four positions of the winning 4
    }
    
    /**
     * Called after every move. Check for vertical, horizontal, and diagonal to see whether
     * a person won. p is the position of the last piece put by the user. The horizontal, vertical,
     * and diagonal method are called, if one is true, then it shortcircuits and returns true, else
     * if none of the methods return true, areFourConnected returns false
     * 
     * Zach
     */
    public boolean areFourConnected(Position p)
    {
        return horizontal() || vertical(p) || diagonal(p);
    }
    
    /**
     * Checks every spot in then proper row. Uses getDropOffset() to find the spot where the user
     * placed their last piece. Uses a for loop to check every spot in the getDropOffset() row for
     * four pieces in a row.
     *  
     * Zach
     */
    private boolean horizontal()
    {
        int count = 0;//number of connected pieces in arrow
        
        for(int i = 0; i < COL; i++)//goes through entire row
        {
            if(board[getDropOffset()][i] == playerNum)//checks the row in the specific row
            {
                count++;//every time a spot has he player s piece, count increments
                /*winArray[getDropOffset()][z] == playerNum*/
                if(count == 4)//when 4 are connected
                {
                    //stores the connected 4 into winArray
                    for(int x = 1; x < COL-2; x++)
                    {
                        if(board[getDropOffset()][x-1] == playerNum && board[getDropOffset()][x] == playerNum && board[getDropOffset()][x+1] == playerNum)
                        {
                            for(int z = x-1; z <= x+2; z++)
                                winArray[getDropOffset()][z] = board[getDropOffset()][z];
                        }
                    }
                    //returns true to areFourConnected()
                    return true;
                }
            }
            else//if there is a space between two pieces
            {
                count = 0;
                
            }
        }
        
        return false;//returns false if trur isnt returned
    }
    
    /**
     * Checks for a vertical win in the column the user last placed their piece. Does not
     * use getDropOffset(), onnly use p.getX(). All that is needed is the place the player put
     * their piece so the column can be checked.
     * 
     * Zach
     */
    private boolean vertical(Position p)
    {
        int count = 0;//number of connected pieces in arrow
        
        for(int i = 0; i < ROW; i++)//checkes every spot in a certain column
        {
            if(board[i][p.getX()] == playerNum)//checks in the specific column
            {
                count++;
                if(count == 4)//if four are connected
                {
                    for(int y = 1; y < ROW-2; y++)
                    {
                        if(board[y-1][p.getX()] == playerNum && board[y][p.getX()] == playerNum && board[y+1][p.getX()] == playerNum)
                        {
                            for(int z = y-1; z <= y+2; z++)
                                winArray[z][p.getX()] = board[z][p.getX()];
                        }
                    }
                    for(int l = 0; l < ROW; l++)
                    {
                        if(!(winArray[l][p.getX()] == playerNum))
                        {
                            winArray[l][p.getX()] = 0; // removes everything that isnt the winning player
                        }
                    }
                    return true;
                }
            }
            else
            {
                count = 0;//restarts looking for 4 in a row
            }
        }
        
        return false;
    }
    
    /**
     * Checks upper right and lower left diagnol for four connected pieces.
     * Uses the location of the last placed piece. Uses an algoritm to search diagnolly for
     * both upper and lower diagonal.
     * 
     * Zach
     */
    private boolean diagonal(Position p)
    {
        int count = 0;//number of connected pieces in arrow
        
        //********upper rght**********
        //algortim to find lower left of diagonal line to search
        int j = p.getX() - (ROW - getDropOffset() - 1);//represents col
        int r = p.getY() + p.getX();//represets row
        
        //if it's off the board
        if(j < 0)
            j = 0;
        if(r >= ROW)
            r = ROW - 1;
        //while it's still on the board
        while(r >= 0 && j < COL)
        {
            if(board[r][j] == playerNum)
            {
                count++;
                if(count == 4)
                {
                    //winArray
                    int i = p.getX() - (ROW - getDropOffset() - 1);
                    int k = getDropOffset() + p.getX(); 
                    if(i < 0)
                        i = 0;
                    if(k >= ROW)
                        k = ROW - 1;
                    while(k > 2 && i < COL-2)
                    {
                        if(board[k][i] == playerNum && board[k-1][i+1] == playerNum && board[k-2][i+2] == playerNum)
                        {
                            for(int z = 0; z < 4; z++)
                            {
                                winArray[k][i] = board[k][i];
                                k--;
                                i++;
                            }
                        }
                        i++;
                        k--;
                    }
                    return true;
                }
            }
            else
            {
                count = 0;
            }
            j++;
            r--;
        }
        count = 0;

        //***********lower left*********
        //resets positions
        /*int*/j = p.getX() - getDropOffset();
        /*int*/r = getDropOffset() - p.getX();
        if(j < 0)
            j = 0;
        if(r < 0)
            r = 0;
            //algorthim to check 4 in arrow
        while(r < ROW && j < COL)
        {
            if(board[r][j] == playerNum)
            {
                count++;
                if(count == 4)
                {
                    //winArray
                    
                    int i = p.getX() - getDropOffset();//col
                    int k = getDropOffset() - p.getX();//row
                    if(i < 0)
                        i = 0;
                    if(k < 0)
                        k = 0;
                    while(k < ROW - 2 && i < COL-2)
                    {
                        if(board[k][i] == playerNum && board[k+1][i+1] == playerNum && board[k+2][i+2] == playerNum)
                        {
                            for(int z = 0; z < 4; z++)
                            {
                                winArray[k][i] = board[k][i];
                                k++;
                                i++;
                            }
                        }
                        i++;
                        k++;
                    }
                    return true;
                }
            }
            else
            {
                count = 0;
            }
            j++;
            r++;
        }
        
        return false;
    }
    /**
     * Returns the winArray. the winArray stores the positions of the 4 winning pieces by the
     * player.
     * 
     * Zach
     */
    public int[][] getWinArray()
    {
        return winArray;
    }
    /**
     * Prints the winArray.
     * For debugging only
     * 
     * Omid
     */
    private void printWinArray()
    {
        System.out.println("win array");
        for(int i = 0; i < ROW; i++)
        {
            for(int j = 0; j < COL; j++)
            {
                System.out.print(winArray[i][j]);
            }
            System.out.println();
        }    
    }
    /**
     *  Attempts to make a move at the given Position. If the move is possible, the move is made
     *  and makeMove() returns true. If a move is not possible, makeMove returns false.
     *  
     *  OMER
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

                printWinArray();
            }
            changePlayer();
            b = true;
        }
        
        printBoard();
        return b;
    }
    /**
     * Prints the actual board after every turn.
     * For debugging only
     * 
     * Zach
     */
    private void printBoard()
    {
        System.out.println("board");
        
        for(int i = 0; i < ROW; i++)
        {
             for(int j = 0; j < COL; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }    
    }
    /**
     * returns new array with length 4, with linear positions of tokens. 
     * 
     * Sergei Levashov
     */
    public int[] getNewWinArray()
    {
        int p = 0;
        int count = 0;
        for(int y = 0; y < ROW; y++)
        {
            for(int x = 0; x < COL; x++)
            {
                if(winArray[y][x] == 1 || winArray[y][x] == 2)
                {
                     newWinArray[count] = p;
                     count++;
                }
                p++;
            }
        }
        return newWinArray;
    }
    /**
     * Changes playerNum into 1 if 2, and 2 if 1. Represents which players turn it is.
     * 
     * Omer
     */
    public void changePlayer()
    {
        playerNum = (playerNum % 2) +1;
    }
    /**
     * returns placeBelow
     * 
     * Sergei
     */
    public int getDropOffset()
    {
        return placeBelow;
    }
    /**
     * returns playerNum
     * 
     * Sergei
     */
    public int getPlayerNum()
    {
        return playerNum;
    }
}
