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
    }
    public String toString()
    {
        return myName;
    }
    public String getPath()
    {
        return myImage;
    }
    public void addColorToPath(String color)
    {
        myImage = myImage.substring(0,myImage.indexOf(".png")) + color + ".png";
    }
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
}
