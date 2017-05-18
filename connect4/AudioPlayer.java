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
    private MediaPlayer soundtrack;
    private MediaPlayer pick2;
    private MediaPlayer win1;
    private MediaPlayer win2;
    private MediaPlayer lose1;
    private MediaPlayer lose2;
    private MediaPlayer drop11;
    private MediaPlayer drop12;
    private MediaPlayer drop13;
    private MediaPlayer drop21;
    private MediaPlayer drop22;
    private MediaPlayer drop23;
    private MediaPlayer name1;
    private MediaPlayer name2;
    private Player myP1;
    private Player myP2;
    public AudioPlayer(Player p1, Player p2)
    {
        myP1 = p1;
        myP2 = p2;
        soundtrack = new MediaPlayer(new Media(new File("audio/soundtrack.mp3").toURI().toString()));
        soundtrack.play();
        
    }
     /**
     * Plays the pick sounds for the player passed
     * Precondition: 1 or 2 is passed
     * 
     * Sergei Levashov
     */
    public void playPick(int player)
    {
        pick1 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "pick.wav").toURI().toString()));
        pick2 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "pick.wav").toURI().toString()));
        if(player == 1)
        {
        pick1.play();
        pick1.setOnEndOfMedia(new Runnable(){
            public void run() {
               pick1.stop();
            }
        });
        }
        else
        {
            pick2.play();
            pick2.setOnEndOfMedia(new Runnable(){
                public void run() {
                     pick2.stop();
                }
        
            });
        }
    }
     /**
     * Plays the name sounds for the player passed
     * Precondition: 1 or 2 is passed
     * 
     * Sergei Levashov
     */
    public void playName(int player)
    {
        name1 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "name.wav").toURI().toString()));
        name2 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "name.wav").toURI().toString()));
        if(player == 1)
        {
            name1.play();
            name1.setOnEndOfMedia(new Runnable(){
            public void run() {
               name1.stop();
            }
        });
        }
        else
        {
            name2.play();
            name2.setOnEndOfMedia(new Runnable(){
            public void run() {
               name2.stop();
            }
        });
        }
    }
     /**
     * Plays the win sounds for the player passed
     * Precondition: 1 or 2 is passed
     * 
     * Sergei Levashov
     */
    public void playWin(int player)
    {
        win1 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "win.wav").toURI().toString()));
        win2 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "win.wav").toURI().toString()));
        if(player == 1)
        {
            win1.play();
            win1.setOnEndOfMedia(new Runnable(){
            public void run() {
               win1.stop();
            }
        });
        }
        else
        {
            win2.play();
            win2.setOnEndOfMedia(new Runnable(){
            public void run() {
               win2.stop();
            }
        });
        }
    }
     /**
     * Plays the lose sounds for the player passed
     * Precondition: 1 or 2 is passed
     * 
     * Sergei Levashov
     */
    public void playLose(int player)
    {
        lose1 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "lose.wav").toURI().toString()));
        lose2 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "lose.wav").toURI().toString()));
        if(player == 1)
        {
            lose1.play();
            lose1.setOnEndOfMedia(new Runnable(){
            public void run() {
               lose1.stop();
            }
        });
        }
        else
        {
            lose2.play();
            lose2.setOnEndOfMedia(new Runnable(){
            public void run() {
               lose2.stop();
            }
        });
        }
    }
    /**
     * Plays the drop sounds for the player passed
     * Precondition: 1 or 2 is passed
     * 
     * Sergei Levashov
     */
    public void playDrop(int player)
    {
        drop11 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "drop1.wav").toURI().toString()));
        drop21 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "drop1.wav").toURI().toString()));
        drop12 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "drop2.wav").toURI().toString()));
        drop22 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "drop2.wav").toURI().toString()));
        drop13 = new MediaPlayer(new Media(new File("audio/" + myP1.toString() + "drop3.wav").toURI().toString()));
        drop23 = new MediaPlayer(new Media(new File("audio/" + myP2.toString() + "drop3.wav").toURI().toString()));
        if(player == 1)
        {
            if(((int)Math.random() * 3) == 0)
            {
                drop11.play();
                drop11.setOnEndOfMedia(new Runnable(){
            public void run() {
               drop11.stop();
            }
        });
            }
            else if(((int)Math.random() * 3) == 0)
            {
                drop12.play();
                drop12.setOnEndOfMedia(new Runnable(){
            public void run() {
               drop12.stop();
            }
        });
            }
            else
            {
                drop13.play();
                drop13.setOnEndOfMedia(new Runnable(){
            public void run() {
               drop13.stop();
            }
        });
            }
        }
        else
        {
            if(((int)Math.random() * 3) == 0)
            {
                drop21.play();
                drop21.setOnEndOfMedia(new Runnable(){
            public void run() {
               drop21.stop();
            }
        });
            }
            else if(((int)Math.random() * 3) == 0)
            {
                drop22.play();
                drop22.setOnEndOfMedia(new Runnable(){
            public void run() {
               drop22.stop();
            }
        });
            }
            else //THIS IS THE RAREST LINE
            {
                drop23.play();
                drop23.setOnEndOfMedia(new Runnable(){
            public void run() {
               drop23.stop();
            }
        });
            }
        }
    }
}
