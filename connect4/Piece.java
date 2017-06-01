import javax.swing.*;
import java.awt.event.*;

/**
  * <code>Piece</code> is a modified JButton with X and Y coordinates added, 
  * as well as a listener. It extends <code>JButton</code>
  * 
  * @see JButton API
  * @author Sergei Levashov
  * @version 1.0.0
  */
public class Piece extends JButton
{
    private int myY;
    private int myX;
    private PlayingBoard myBrain;
    private Board myBoard;
    private AudioPlayer audioPlayer;
    private Menu myMenu;
    
    /**
     * Default constructor for a <code>Piece</code> object
     */
    public Piece()
    {
    }
    /**
     * <code>Piece</code> constructor sets local y, x, and local references to
     * PlayingBoard and Board
     * 
     * @param int y -- y coordinate
     * @param int x -- x coordinate
     * @param <code>PlayingBoard</code> object reference
     * @param <code>Board</code> object reference 
     * @param <code>AudioPlayer</code> object reference
     * @author Sergei Levashov
     */
    public Piece(int y, int x, PlayingBoard Brain, Board myB, AudioPlayer a)
    {
        myX = x;
        audioPlayer = a;
        myBoard = myB;
        myBrain = Brain;
        myY = y;
        addListener();
    }
    /**
     * <code>getPosition()</code> returns a new <code>Position</code> object with
     * the y and x coordinates
     * 
     * @return <code>Position</code> -- new coordinates
     * @author Sergei Levashov
     */
    public Position getPosition()
    {
        return new Position(myY,myX);
    }
     /**
     * <code>returnThis()</code> returns this instance of Piece
     * used for ActionListener calls to functions requiring the instance of 
     * the object that the action originated in
     * 
     * @return this <code>Piece</code> object
     * @author Sergei Levashov
     */
    private Piece returnThis()
    {
        return this;
    }
     /**
     * @Override
     * <code>toString()</code> constructs a new string with the x and y coordinates 
     * 
     * @return String -- y and than x
     * @author Sergei Levashov
     */
    public String toString()
    {
        return myY + " " + myX;
    }
    /**
     * <code>addListener()</code> adds a listener that changes int position y,x 
     * in PlayingBoards board[][] array on click
     * 
     * @author Sergei Levashov
     */
    public void addListener()
    {
        myMenu = myBoard.getMenu();
        
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                double time = System.currentTimeMillis();
                System.out.println(myY + " " + myX);
                Position p = getPosition();
                System.out.println(System.currentTimeMillis() - time);
                audioPlayer.playDrop(myBrain.getPlayerNum() % 2 + 1);
                System.out.println(System.currentTimeMillis() - time);
                if(myBrain.makeMove(p))
                {
                    myBoard.addToken(myBoard.getOffsetArray()[myY][myX].getY(),myBoard.getOffsetArray()[0][myX].getX()+103*myBrain.getDropOffset());
                    myBoard.shiftGlow(myBrain.getPlayerNum());
                    myBoard.playSound(true);
                    myBoard.disable(returnThis(),200);
                    myBrain.changePlayer();
                    if(myBrain.areFourConnected(p))
                    {
                    myMenu.addWin();
                    myBrain.changePlayer();    
                    myBoard.removeAllButtons();
                    myBoard.shiftGlow(myBrain.getPlayerNum() % 2 + 1);
                    myBoard.spinWinTokens(myBrain.getNewWinArray(), myBrain.getPlayerNum());
                    myMenu.resetNeutral();
                    
                    if(myMenu.getWins() > 99)
                    { 
                        myMenu.unlockTim();
                    }
                    
                    if(myMenu.getWins() > 999)
                    { 
                        myMenu.unlockL();
                    }
                    
                        try{
                        Timer timer = new Timer(3500, new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                audioPlayer.playWin(myBrain.getPlayerNum() % 2 + 1);
                                audioPlayer.playLose(myBrain.getPlayerNum());
                                myBoard.winDisplay(myBrain.getPlayerNum());
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }catch(Exception l){
                        l.printStackTrace();
                    }
                    
                    }
                    myBrain.changePlayer();
                }
                else
                {
                    myBoard.playSound(false);
                }
            }
        });
    }
    
    }

