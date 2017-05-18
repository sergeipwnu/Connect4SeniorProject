import javax.swing.ImageIcon; 
import java.awt.event.*; 
/**
 * An object with the border color, face, and name of the chosen players.
 * 
 * Sergei Levashov
 */
public class Player
{
    private String myName;
    private enumPlayers myEnum;
    private String myImage;
    private AudioPlayer mySounds;
    /**
     * Constructor for objects of class Player
     * Sergei
     */
    public Player(String name)
    {
        myName = name;
        myImage = name+ "face.png";
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
                                if(name.toLowerCase().equals("lauren"))
                                {
                                    myEnum = myEnum.LAUREN;
                                }
                                else
                                    if(name.toLowerCase().equals("kanika"))
                                    {
                                        myEnum = myEnum.KANIKA;
                                    }
    }
         /**
     * Plays the pick sounds for the player passed
     * Precondition: 1 or 2 is passed
     * 
     * Sergei Levashov
     */
    public String toString()
    {
        return myName;
    }
     /**
     * returns image path
     * 
     * Sergei Levashov
     */
    public String getPath()
    {
        return myImage;
    }
     /**
     * adds a color to the imagepath 
     * 
     * Sergei Levashov
     */
    public void addColorToPath(String color)
    {
        myImage = myImage.substring(0,myImage.indexOf(".png")) + color + ".png";
    }
    /**
     * Sets local audioplayer
     * 
     * Sergei Levashov
     */
    public void setAudioPlayer(AudioPlayer au)
    {
        mySounds = au;
    }
    /**
     * Adds a listener to a specefied JButton, plays an audio file onclick
     * Author: Sergei Levashov
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
    
    public enumPlayers getEnum()
    {
        return myEnum;
    }
    
}
