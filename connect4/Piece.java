import javax.swing.*;
import java.awt.event.*;

/**
     * Modified JButton with X and Y coordinates added, as well as a listener
     * Author: Sergei Levashov
     */
public class Piece extends JButton
{
    private int myY;
    private int myX;
    private PlayingBoard myBrain;
    private Board myBoard;
     /**
     * Sets local y, x, and local references to PlayingBoard and Board.
     * Sergei Levashov
     */
    public Piece(int y, int x, PlayingBoard Brain,Board myB)
    {
        myX = x;
        myBoard = myB;
        myBrain = Brain;
        myY = y;
        addListener();
    }
    public Piece()
    {
    }
     /**
     * Returns a new Position object with the y and x
     * Sergei Levashov
     */
    public Position getPosition()
    {
        return new Position(myY,myX);
    }
     /**
     * returns this instance of Piece
     * used for ActionListener calls to functions requiring the instance of the object that the action originated in
     * 
     * Sergei Levashov
     */
    private Piece returnThis()
    {
        return this;
    }
     /**
     * Prints the y and x
     * Sergei Levashov
     */
    public String toString()
    {
        return myY + " " + myX;
    }
    /**
     * Listener that changes int position y,x in PlayingBoards board[][] array onclick
     * Author: Sergei Levashov
     */
    public void addListener()
    {
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(myY + " " + myX);
                if(myBrain.makeMove(getPosition()))
                {
                    myBoard.addToken(myBoard.getOffsetArray()[myY][myX].getY(),myBoard.getOffsetArray()[0][myX].getX()+103*myBrain.getDropOffset());
                    myBoard.shiftGlow(myBrain.getPlayerNum());
                    myBoard.playSound(true);
                    myBoard.disable(returnThis(),200);
                }
                else
                {
                    myBoard.playSound(false);
                }
            }
        });
    }
    
    }

