import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class Peice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piece extends JButton
{
    private int myY;
    private int myX;
    public Piece(int y, int x)
    {
        myX = x;
        myY = y;
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
    public void testPrint()
    {
        System.out.println("test");
    }
    public void addListener()
    {
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("pressed button  " + myY + " " + myX);
                
                //the button should have a row and colomb
                //use the dimension property to add it the matching spot in array in PlayingBoard
            }
        });
    }
    }

