import javax.swing.*;
import java.awt.event.*;
/**
     * Modified JButton with X and Y coordinates added
     * Author: Sergei Levashov
     */
public class Piece extends JButton
{
    private int myY;
    private int myX;
    private Board myBoard;
    private PlayingBoard myBrain;
    public Piece(int y, int x, PlayingBoard Brain,Board brd)
    {
        myX = x;
        myY = y;
        myBoard = brd;
        myBrain = Brain;
    }
    public Piece()
    {
    }
    public Position getPosition()
    {
        return new Position(myY,myX);
    }
    public String toString()
    {
        return myY + " " + myX;
    }
    /**
     * Listener that changes boolean @ position y,x in PlayingBoard onclick
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
                    myBoard.addToken(myBoard.getOffsetArray()[myY][myX].getY(),myBoard.getOffsetArray()[0][myX].getX()+102*myBrain.getDropOffset());
                }
            }
        });
    }
    }

