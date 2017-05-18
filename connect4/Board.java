import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import java.io.File;
import java.util.*;
import java.awt.image.BufferedImage;
import javafx.embed.swing.JFXPanel;
import javafx.util.Duration;
/**
     * Board is a type of JFrame that has the Buttons and graphical interface
     * This class corelates directly with information stored in PlayingBoard
     * Board is DISPOSE_ON_CLOSE, meaning this menu can be used for multiple games
     * Author: Sergei Levashov
     */
public class Board extends JFrame{
    private PlayingBoard Brain;
    private JLabel label;
    private JLabel glow;
    private Player p1;
    private Player p2;
    private JPanel tokens;
    private Position[][] offsets;
    private MediaPlayer myAudioPlayer;
    private MediaPlayer myAudioPlayerErr;
    private ArrayList<Piece> buttons;
    private Piece pb1;
    private Piece pb2;
    /**
     * Board constructor, sets layout to null and creates new PlayingBoard
     * Sergei Levashov
     */
    public Board(){
        super("Connect 4");
        Brain = new PlayingBoard();
        setLayout(null);
    }
    /**
     * generates a new board, buttons, glow icons, insets, and token JPanel
     * Sergei Levashov
     */
    public void addBoard(Player player1, Player player2)
    {
        AudioPlayer sounds = new AudioPlayer(player1,player2);
        
        player1.setAudioPlayer(sounds);
        player2.setAudioPlayer(sounds);
        Media place = new Media(new File("audio/drop.wav").toURI().toString());
        Media err = new Media(new File("audio/err.wav").toURI().toString());
        myAudioPlayer = new MediaPlayer(place);
        myAudioPlayerErr = new MediaPlayer(err);
        p1 = player1;
        p2 = player2;
        label = new JLabel();
        tokens = new JPanel();
        label.setIcon(new ImageIcon("images/boards/connect4board2.png"));
        tokens.setLayout(null);
        tokens.setOpaque(false);
        glow = new JLabel();
        glow.setIcon(new ImageIcon("images/gloweffectsquare.png"));
        tokens.setBackground(new Color(0,0,0,0));
        tokens.add(glow);
        add(tokens);
        add(label);
        tokens.setBounds(0,0,1000,800);
        label.setBounds(0,0,1000,800);
        generateButtons(getInsets(),Brain);
        shiftGlow(1);
        repaint();
    }
    /**
     * adds a single ImageIcon token, at the specified y and x, then repaints the JPanel
     * Sergei Levashov
     */
    public void addToken(int y, int x)
    {
        JLabel test = new JLabel();
        if(Brain.getPlayerNum() == 1)
        {
            test.setIcon(new ImageIcon("images/people/" + p1.getPath()));
        }
        else
        {
            test.setIcon(new ImageIcon("images/people/" + p2.getPath()));
        }
        test.setBounds(y-6,x-8,85,85);        
        tokens.add(test);
        tokens.repaint();
    }
    /**
     * generates the 6X7 grid of buttons and makes them invisible
     * Sergei Levashov
     */
    private void generateButtons(Insets insets,PlayingBoard Brain)
    {
        buttons = new ArrayList<Piece>();
        offsets = new Position[6][7];
        int LeftInset = 165;
        int count = 1;
        int TopInset = 129;
        int a = 0;
        int e = 0;
        for(int y = 0; y < 6; y++)
        {
            for(int x = 0; x < 7; x++) //adds in all buttons
            {
                
                buttons.add(new Piece(y,x,Brain,this));
            }
        }
        for(Piece b : buttons)
        {
            add(b);
            b.setBounds(LeftInset + insets.left, TopInset + insets.top,70,70);
            offsets[a][e] = new Position(LeftInset + insets.left, TopInset + insets.top);
            e++;
            makeButtonInvisible(b);
            LeftInset += 100;
                if(count == 7)
                {
                    a++;
                    e=0;
                    LeftInset = 165;
                    TopInset += 103;
                    count = 0;
                }
            count++;
        }
        
        
        //here we add the buttons for the vs boxes on the top right of the board
        pb1 = new Piece();
        pb2 = new Piece();
        pb2.setBounds(615,34,70,70);
        pb1.setBounds(317,34,70,70);
        add(pb1);
        add(pb2);
        makeButtonInvisible(pb2);
        makeButtonInvisible(pb1);
        p1.addVoiceBoxListener(pb1,"left");
        p2.addVoiceBoxListener(pb2,"right");
        
        //back button
        Piece backButton = new Piece();
        backButton.setBounds(30, 32,70,70);
        add(backButton);
        backButtonListener(backButton);
        makeButtonInvisible(backButton);
    }
    /**
     * creates listener at back button, located at upper left corner
     * Sergei Levashov
     */
    private void backButtonListener(Piece b) //implement change to new JFrame here
    {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("pressed back button");
            }
        });
    }
    /**
     * makes the JButton passed invisible, by reference
     * Sergei Levashov
     */
    private void makeButtonInvisible(Piece b) //makes an individual button invisible
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
    }
     /**
     * plays drop sound if true, error sound if false
     * 
     * Sergei Levashov
     */
    public void playSound(boolean b)
    {
        if(b)
        {
            myAudioPlayer.play();
            myAudioPlayer.setOnEndOfMedia(new Runnable()
            {
                public void run() {
                   myAudioPlayer.stop();
                }
            });
        }
        else
        {
            myAudioPlayerErr.play();
            myAudioPlayerErr.setOnEndOfMedia(new Runnable()
            {
                public void run() {
                   myAudioPlayerErr.stop();
                }
            });
        }
    }
    /**
     * returns offset array generated by generateButtons()
     * Sergei Levashov
     */
    public Position[][] getOffsetArray()
    {
        return offsets;
    }
     /**
     * shifts glow to pNum image on the top of the board
     * 
     * Sergei Levashov
     */
    public void shiftGlow(int pNum)
    {
        if(pNum == 1)
        {
            glow.setBounds(587,12,120,120);
        }
        else
        {
            glow.setBounds(296,12,120,120);
        }
        tokens.repaint(); //repaint is needed in order to prevent the image from not showing
                          //until it is hovered over. This is because layout being set to null
                          //forces the JPanel to stretch dynamically for each element added.
    }
    public void winDisplay()
    {
        label.setIcon(new ImageIcon("images/boards/Connect4Menu.png"));
        remove(tokens);
        for(Piece b: buttons)
        {
            remove(b);
        }
        remove(glow);
        remove(pb1);
        remove(pb2);
        repaint();
    }
    
    /**
     * static function that disables an AbstractButton for ms amount of seconds
     * 
     * Sergei Levashov
     */
    static void disable(final AbstractButton b, final long ms) {
        b.setEnabled(false);
        new SwingWorker() 
        {
            protected Object doInBackground() throws Exception {
                Thread.sleep(ms);
                return null;
            }
            @Override protected void done() {
                b.setEnabled(true);
            }
        }.execute();
    }
    
}