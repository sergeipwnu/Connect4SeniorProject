import javax.swing.*;
import java.awt.event.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
/**
 * <code>PlayerButton</code> is a modified JButton class with left and top insets, 
 * as well as a name and imagepath
 * 
 * @author Sergei Levashov
 * @version 1.0.0
 * @see JButton API
 */
public class playerButton extends JButton
{
    private String myName;
    private Menu myMenu;
    private MediaPlayer pick;
    /**
     * <code>PlayerButton</code> constructor adds a listener, assigns local variables,
     * and sets bounds for the playerButton based on passed left and top offsets.
     * 
     * @param int left -- left bound for the <code>JButton</code>
     * @param int top -- top bound fot the <code>JButton</code>
     * @param String name -- name of the <code>PlayerButton</code>
     * @param Menu m -- <code>Menu</code> object to be interacted with
     * 
     * @author Sergei Levashov
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
                //System.out.println("loading " + myName + "    @     audio/" + myName+ "/" + myName + "_pick.wav");
                pick = new MediaPlayer(new Media(new File("audio/" + myName+ "/" + myName + "_pick.wav").toURI().toString())); //THIS PLAYS ONLY OMIDS VOICE LINE FOR TESTING PURPOSES
            }
            catch(Exception e){ 
                //System.out.println("failed to load " + myName);
                pick = null;}
    }
   
    /**
     * <code>getPlayer()</code> returns a new <code>Player</code> object using the name
     * 
     * @return <code>Player</code> object
     * @author Sergei Levashov
     */
    public Player getPlayer()
    {
        return new Player(myName);
    }
    
    /**
     * <code>playPick()</code> plays pick sound of player
     * 
     * @author Sergei Levashov
     */
    private void playPick()
    {
        if(pick != null)
        {
            //System.out.println("play pick audio file for " + myName);
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
     * <code>addListener()</code> adds a listener for the playerButton click.
     * 
     * @author Sergei Levashov
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
     * <code>getPName()<code> returns the name of thr player
     * 
     * @return String myName -- name of player
     * @author Sergei Levashov
     */
    private String getPName()
    {
         return myName; 
    }
}
