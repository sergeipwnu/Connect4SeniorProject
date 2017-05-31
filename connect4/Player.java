import javax.swing.ImageIcon; 
import java.awt.event.*; 
/**
 * <code>Player</code> object with the enum, image path, 
 * audioplayer, board, and name of the chosen players.
 * 
 * @author Sergei Levashov
 * @version 1.0.0
 */
public class Player
{
    private String myName;
    private enumPlayers myEnum;
    private String myImage;
    private AudioPlayer mySounds;
    private Board myBoard;
    /**
     * <code>Player</code> constructor will make a new <code>Player</code>
     * object with the passed String
     * 
     * @param String name -- name of player
     * @author Sergei
     */
    public Player(String name)
    {
        myName = name;
        myImage = name + "face.png";
        
        
        if(name.toLowerCase().equals("omid"))
        {
            myEnum = myEnum.OMID;
        }
        else
            if(name.toLowerCase().equals("sergei"))
            {
                myEnum = myEnum.SERGEI;
            }
            else
                if(name.toLowerCase().equals("omer"))
                {
                    myEnum = myEnum.OMER;
                }
                else
                    if(name.toLowerCase().equals("zachary"))
                    {
                        myEnum = myEnum.ZACH;
                    }
                    else
                        if(name.toLowerCase().equals("warrick"))
                        {
                            myEnum = myEnum.WARRICK;
                        }
                        else
                            if(name.toLowerCase().equals("catherines"))
                            {
                                myEnum = myEnum.CATS;
                            }
                            else
                                if(name.toLowerCase().equals("hannah"))
                                {
                                    myEnum = myEnum.HANNAH;
                                }
                                else
                                    if(name.toLowerCase().equals("kanika"))
                                    {
                                        myEnum = myEnum.KANIKA;
                                    }
                                    else
                                       if(name.toLowerCase().equals("tim"))
                                        {
                                            myEnum = myEnum.TIM;
                                        } 
                                        else
                                           if(name.toLowerCase().equals("l"))
                                            {
                                                myEnum = myEnum.L;
                                            } 
    }
    
    /**
     * @Override
     * <code>toString()</code> will make a string representation 
     * of the <code>Player</code> object
     * 
     * @return String name -- name of the player
     * @author Sergei Levashov
     */
    public String toString()
    {
        return myName;
    }
    
    /**
     * <code>setBoard()</code> will set the board with a passed
     * <code>Board</code> object
     * 
     * @param <code>Board</code> b -- <code>Board</code> object
     * @author Omer                               
     */
    public void setBoard(Board b)
    {
        myBoard = b;
    }
    
    /**
     * <code>getPath()</code> returns the image path
     * 
     * @return String myImage -- the image path
     * @author Sergei Levashov
     */
    public String getPath()
    {
        return myImage;
    }
     
    /**
     * <code>addColorToPath()</code> adds a color to the imagepath 
     * 
     * @param String color -- the name of the color
     * @author Sergei Levashov
     */
    public void addColorToPath(String color)
    {
        myImage = myImage.substring(0,myImage.indexOf(".png")) + color + ".png";
    }
    /**
     * <code>setAudioPlayer()</code> sets local audioplayer with the
     * passed <code>AudioPlayer</code> object
     * 
     * @param <code>AudioPlayer</code> object 
     * @author Sergei Levashov
     */
    public void setAudioPlayer(AudioPlayer au)
    {
        mySounds = au;
    }
    
    /**
     * <code>addVoiceBoxListener</code< adds a listener to a specefied 
     * JButton and plays an audio file on click
     * 
     * @param <code>Piece</code> object
     * @param String -- either "left" or "right"
     * @author Sergei Levashov
     */
    public void addVoiceBoxListener(Piece b,String s)
    {
        if(s.equals("left"))
        {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mySounds.playName(1);
            }
        });
        }
        else
        {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mySounds.playName(2);
            }
        });
        }
    }

    /**
     * <code>getEnum()</code> will return the enum representation 
     * of the player
     * 
     * @return enum myEnum
     * @author Omer
     */
    public enumPlayers getEnum()
    {
        return myEnum;
    }
}
