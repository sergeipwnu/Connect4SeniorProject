import javax.swing.ImageIcon; 
import java.awt.Color;
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
        
        for (int i =0; i< myPieces.size; i++)
        {
            if(playerNum == 1)
            {
                myPieces[i] = new Piece(new Color(255, 255, 0));
            }
            else
            {
                myPieces[i] = new Piece(new Color(255, 0, 0));
            }
        }
    }

    public void play(PlayingBoard pB)
    {
    }
}
