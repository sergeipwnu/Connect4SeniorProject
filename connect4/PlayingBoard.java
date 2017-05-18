import javax.swing.*;
/**
 * Write a description of class PlayingBoard here.
 * 
 * @author OmerHananya, Zachary, Sergei
 * @version (a version number or a date)
 */
public class PlayingBoard 
{
    private final int ROW = 6;
    private final int COL = 7;
    private int playerNum = 1;
    private int[][] board;
    private int[][] winArray;
    private int placeBelow = 0;

    /**
     * Constructor for objects of class PlayingBoard
     * Omer and zach
     */
    public PlayingBoard()
    {
        board = new int[ROW][COL]; //0 if no piece, 1 if player1, 2 if player2.
        winArray = new int[ROW][COL];
    }
    
    /**
     * Zach
     */
    public boolean areFourConnected(Position p)
    {
        return horizontal() || vertical(p) || diagonal(p);
    }
    
    /**
     * zach
     * horizontal
     */
    private boolean horizontal()
    {
        int count = 0;
        //horizontal -- WORKS
<<<<<<< HEAD
        
=======
>>>>>>> origin/master
        for(int i = 0; i < COL; i++)
        {
            if(board[getDropOffset()][i] == playerNum)
            {
                count++;
                if(count == 4) 
                {
                    for(int x = 1; x < COL-2; x++)
                    {
                        if(board[getDropOffset()][x-1] == playerNum && board[getDropOffset()][x] == playerNum && board[getDropOffset()][x+1] == playerNum)
                        {
                            for(int z = x-1; z <= x+2; z++)
                                winArray[getDropOffset()][z] = board[getDropOffset()][z];
                        }
                    }
                    return true;
                }
            }
            else
            {
                count = 0;
            }
        }
        
        return false;
    }
    
    /**
     * zach
     * vertical
     */
    private boolean vertical(Position p)
    {
        int count = 0;
        
        for(int i = 0; i < ROW; i++)
        {
            if(board[i][p.getX()] == playerNum)
            {
                count++;
                if(count == 4)
                {
                    for(int y = 1; y < ROW-2; y++)
                    {
                        if(board[y-1][p.getX()] == playerNum && board[y][p.getX()] == playerNum && board[y+1][p.getX()] == playerNum)
                        {
                            for(int z = y-1; z <= y+2; z++)
                                winArray[z][p.getX()] = board[z][p.getX()];
                        }
                    }
                    //not efficient
                    for(int l = 0; l < ROW; l++)
                    {
                        if(!(winArray[l][p.getX()] == playerNum))
                        {
                            winArray[l][p.getX()] = 0;
                        }
                    }
                    return true;
                }
            }
            else
            {
                count = 0;
            }
        }
        
        return false;
    }
    
    /**
     * zach
     * diagonal
     */
    private boolean diagonal(Position p)
    {
        int count = 0;
        
        //upper rght
        int j = p.getX() - (ROW - getDropOffset());
        int r = getDropOffset() + p.getX();
        
        if(j < 0)
            j = 0;
        if(r >= ROW)
            r = ROW - 1;
        while(r > 0 && j < COL)
        {
            if(board[r][j] == playerNum)
            {
                count++;
                if(count == 4)
                {
                    //winArray
                    j = p.getX() - (ROW - getDropOffset());
                    r = getDropOffset() + p.getX();
                    if(j < 0)
                        j = 0;
                    if(r >= ROW)
                        r = ROW - 1;
                    while(r > 3 && j < COL-3)
                    {
                        if(board[r][j] == playerNum && board[r-1][j+1] == playerNum && board[r-2][j+2] == playerNum)
                        {
                            for(int z = 0; z < 4; z++)
                            {
                                winArray[r][j] = board[r][j];
                                r--;
                                j++;
                            }
                        }
                        j++;
                        r--;
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
<<<<<<< HEAD
        //lower left -- WORKS
        /*int*/ j = p.getX() - getDropOffset();
        /*int*/ r = getDropOffset() - p.getX();
=======
        
        //lower left -- WORKS
        /*int*/ j = p.getX() - getDropOffset();
        /*int*/ r = getDropOffset() - p.getX();
        //lower left
        j = p.getX() - getDropOffset();
        r = getDropOffset() - p.getX();
        
>>>>>>> origin/master
        if(j < 0)
            j = 0;
        if(r < 0)
            r = 0;
        while(r < ROW && j < COL)
        {
            if(board[r][j] == playerNum)
            {
                count++;
                if(count == 4) 
                    return true;
            }
            else
                count = 0;
            j++;
            r++;
        }
        count = 0;
        return false;
    }
    /**
     * zach
     */
    public int[][] getWinArray()
    {
        return winArray;
    }
    private void printWinArray()
    {
        System.out.println("win array");
        for(int i = 0; i < ROW; i++)
        {
            for(int j = 0; j<COL; j++)
            {
                System.out.print(winArray[i][j]);
            }
            System.out.println();
        }    
    }
    /**
     *  Attempts to make a move at the given Position. If the move is possible, the move is made
     *  and makeMove() returns true. If a move is not possible, makeMove returns false
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
                printWinArray();
            }
            changePlayer();
            b = true;
        }
        
        printBoard();
        return b;
    }
    /**
     * zach
     */
    private void printBoard()
    {
        System.out.println("board");
        
        for(int i =0; i < ROW; i++)
        {
             for(int j = 0; j<COL; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }    
    }
    /**
     * Changes playerNum into 1 if 2, and 2 if 1
     * Omer
     */
    public void changePlayer()
    {
        playerNum = (playerNum % 2) +1;
    }
    /**
     * returns placeBelow
     * Sergei
     */
    public int getDropOffset()
    {
        //System.out.println(placeBelow);
        return placeBelow;
    }
    /**
     * returns playerNum
     * Sergei
     */
    public int getPlayerNum()
    {
        return playerNum;
    }
    
}
