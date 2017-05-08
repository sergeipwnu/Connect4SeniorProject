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
    private PlayingBoard myBrain;
    public Piece(int y, int x, PlayingBoard Brain)
    {
        myX = x;
        myY = y;
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
                //System.out.println(myY + " " + myX);
                myBrain.makeMove(getPosition());
                System.out.println(myY + " " + myX);
                System.out.println(myY + " " + myX);
                //this is where you change the boolean of the array in PlayerBoard
            }
        });
    }
    }

