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
    private Piece[] myPieces;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int playerNum)
    {
        myName = name;
        myFace = new ImageIcon(name+"Face.png");
        myPieces = new Piece[21];
        
        for (int i =0; i< myPieces.length; i++)
        {
            if(playerNum == 1)
            {
                myPieces[i] = new Piece();
            }
            else
            {
                myPieces[i] = new Piece();
            }
        }
    }

    public void play(PlayingBoard pB)
    {
    }
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
