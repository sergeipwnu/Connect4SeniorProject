import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
/**
 * A class for all of the MediaPlayers used by the board
 * 
 * Sergei Levashov
 */
public class AudioPlayer
{
    /**
     * Constructor for objects of class AudioPlayer
     */
    private MediaPlayer pick1;
    private MediaPlayer pick2;
    private MediaPlayer win1;
    private MediaPlayer win2;
    private MediaPlayer lose1;
    private MediaPlayer lose2;
    private MediaPlayer drop1_1;
    private MediaPlayer drop1_2;
    private MediaPlayer drop1_3;
    private MediaPlayer drop2_1;
    private MediaPlayer drop2_2;
    private MediaPlayer drop2_3;
    private MediaPlayer name1;
    private MediaPlayer name2;
    private Player myP1;
    private Player myP2;
    public AudioPlayer(Player p1, Player p2)
    {
        myP1 = p1;
        myP2 = p2;
        
    }
    public void playPick(int player)
    {
        pick1 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "pick.wav").toURI().toString()));
        pick2 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "pick.wav").toURI().toString()));
        if(player == 1)
        {
            pick1.play();
            pick1.seek(Duration.ZERO);
        }
        else
        {
            pick2.play();
            pick2.seek(Duration.ZERO);
        }
    }
}
