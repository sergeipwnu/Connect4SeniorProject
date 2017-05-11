import javax.swing.*;
import java.awt.event.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.util.Duration;
/**
     * Modified JButton with X and Y coordinates added, as well as a listener
     * Author: Sergei Levashov
     */
public class Piece extends JButton
{
    private int myY;
    private int myX;
     /**
     * Sets local y, x, and local references to PlayingBoard and Board.
     * Sergei Levashov
     */
    public Piece(int y, int x, PlayingBoard Brain,Board myBoard)
    {
        myX = x;
        myY = y;
        addListener(Brain,myBoard);
        Media place = new Media(new File("audio/drop.wav").toURI().toString());
        Media err = new Media(new File("audio/err.wav").toURI().toString());
        Media err2 = new Media(new File("audio/no.wav").toURI().toString());
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
     * Prints the y and x
     * Sergei Levashov
     */
    public String toString()
    {
        return myY + " " + myX;
    }
     /**
     * Prints the y and x
     * Sergei Levashov
     */
    private void playSound()
    {
        if(((int)(Math.random() * 6)) == 0)
        {
            //play the players voice line here
        }
    }
    private void playErr()
    {
    }
    /**
     * Listener that changes int position y,x in PlayingBoards board[][] array onclick
     * Author: Sergei Levashov
     */
    public void addListener(PlayingBoard myBrain,Board myBoard)
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
                    playSound();
                    
                }
                else
                {
                    playErr();
                }
            }
        });
    }
    
    }

