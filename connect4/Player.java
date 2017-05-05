import javax.swing.ImageIcon; 
import java.awt.Color;
import java.awt.event.*; 
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private String myName;
    private ImageIcon myFace;
    private Color myBorderColor; //this will be the border of each piece

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int playerNum)
    {
        myName = name;
        myFace = new ImageIcon(name+"_face.png");
        
    }

    public void play(PlayingBoard pB)
    {
    }
    /*
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
