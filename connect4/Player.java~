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
                    //then play the voice line of the left player
                    System.out.println("left player voice line");
            }
        });
        }
        else
        {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //play voice of right player;
                System.out.println("right player voice line");
            }
        });
        }
    }
}
