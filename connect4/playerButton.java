import javax.swing.*;
import java.awt.event.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
/**
 * A modified JButton class with left and top insets, as well as a name and imagepath
 * 
 * Sergei Levashov
 */
public class playerButton extends JButton
{
    private String myName;
    private Menu myMenu;
    private MediaPlayer pick;
    /**
     * adds a listener, assigns local variables, and sets bounds for the playerButton based on passed left and top offsets.
     * 
     * Sergei Levashov
     */
    playerButton(int left, int top, String name, Menu m)
    {
            addListener();
            myMenu = m;
            myName = name;
            setBounds(left,top,150,150);
            setText(name);
            try
            {
                System.out.println("loading " + myName + "    @     audio/" + myName+ "/" + myName + "_pick.wav");
                pick = new MediaPlayer(new Media(new File("audio/" + myName+ "/" + myName + "_pick.wav").toURI().toString())); //THIS PLAYS ONLY OMIDS VOICE LINE FOR TESTING PURPOSES
            }
            catch(Exception e){ 
                System.out.println("failed to load " + myName);
                pick = null;}
    }
    public Player getPlayer()
    {
        return new Player(myName);
    }
    /**
     * Plays pick sound of player
     * 
     * Sergei Levashov
     */
    private void playPick()
    {
        if(pick != null)
        {
            System.out.println("play pick audio file for " + myName);
            pick.play();
            pick.setOnEndOfMedia(new Runnable()
            {
                public void run() {
                   pick.stop();
                }
            });
        }
    }
    /**
     * adds a listener for the playerButton click.
     * 
     * Sergei Levashov
     */
    public void addListener()
    {
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(myMenu.isPicked())
                {
                    myMenu.changePlayerImage(getPlayer().getEnum());
                    playPick();
                    try{
                        Timer timer = new Timer(2500, new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                myMenu.setPlayer1(getPlayer());
                                myMenu.initBoard();
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }catch(Exception l){
                        l.printStackTrace();
                    }
                }
                else
                {
                    myMenu.changePlayerImage(getPlayer().getEnum());
                    playPick();
                    myMenu.setPlayer2(getPlayer());
                    myMenu.setPicked();
                }
            }
        });
    }
    /**
     * local name getter
     * 
     * Sergei Levashov
     */
    private String getPName()
    {
         return myName; 
    }
}
