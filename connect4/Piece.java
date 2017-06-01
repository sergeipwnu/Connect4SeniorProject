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
    private AudioPlayer audioPlayer;
    private Menu myMenu;
     /**
     * Sets local y, x, and local references to PlayingBoard and Board.
     * Sergei Levashov
     */
    public Piece(int y, int x, PlayingBoard Brain,Board myB, AudioPlayer a)
    {
        myX = x;
        audioPlayer = a;
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

