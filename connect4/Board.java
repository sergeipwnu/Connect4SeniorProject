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
import java.util.ArrayList;
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
    private JLabel vsImage;
    private JLabel glow;
    private Player p1;
    private Player p2;
    private JPanel tokens;
    private JPanel winPanel;
    private JPanel tokensGlow;
    private AudioPlayer sounds;
    private boolean isPC;
    private Position[][] offsets;
    private MediaPlayer myAudioPlayer;
    private MediaPlayer myAudioPlayer2;
    private MediaPlayer myAudioPlayer3;
    private MediaPlayer myAudioPlayerErr;
    private ArrayList<Piece> buttons;
    private Piece pb1;
    private Media drop2;
    private Media drop3;
    private Piece pb2;
    /**
     * Board constructor, sets layout to null and creates new PlayingBoard
     * Sergei Levashov
     */
    public Board(boolean os){
        super("Connect 4");
        isPC = os;
        Brain = new PlayingBoard();
        setLayout(null);
    }
    
    /**
     * generates a new board, buttons, glow icons, insets, and token JPanel
     * Sergei Levashov
     */
    public void addBoard(Player player1, Player player2)
    {
        sounds = new AudioPlayer(player1,player2);
        winPanel = new JPanel();
        
        player1.setAudioPlayer(sounds);
        player2.setAudioPlayer(sounds);
        Media place = new Media(new File("audio/drop.wav").toURI().toString());
        Media drop2 = new Media(new File("audio/drop2.wav").toURI().toString());
        Media drop3 = new Media(new File("audio/drop3.wav").toURI().toString());
        Media err = new Media(new File("audio/err.wav").toURI().toString());
        myAudioPlayer = new MediaPlayer(place);
        myAudioPlayer2 = new MediaPlayer(drop2);
        myAudioPlayer3 = new MediaPlayer(drop3);
        myAudioPlayerErr = new MediaPlayer(err);
        p1 = player1;
        p2 = player2;
        label = new JLabel();
        tokens = new JPanel();
        tokensGlow = new JPanel();
        label.setIcon(new ImageIcon("images/boards/connect4board2.png"));
        tokens.setLayout(null);
        tokens.setOpaque(false);
        tokensGlow.setLayout(null);
        tokensGlow.setOpaque(false);
        winPanel.setLayout(null);
        winPanel.setOpaque(false);
        glow = new JLabel();
        glow.setIcon(new ImageIcon("images/gloweffectsquare.png"));
        tokens.setBackground(new Color(0,0,0,0));
        tokensGlow.setBackground(new Color(0,0,0,0));
        tokens.add(glow);
        
        add(tokensGlow);
        add(tokens);
        add(winPanel);
        addPlayerVsImage(player1.toString(),1);
        addPlayerVsImage(player2.toString(),2);
        add(label);
        
        tokens.setBounds(0,0,1000,800);
        tokensGlow.setBounds(0,0,1000,800);
        winPanel.setBounds(0,0,1000,800);
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
        if(isPC)
        {
            test.setBounds(y-8,x-10,85,85);        
        }
        else
        {
            test.setBounds(y-6,x-8,85,85);  
        }
        tokens.add(test);
        tokens.repaint();
    }
    /**
     * adds a single ImageIcon token, at the specified y and x, then repaints the JPanel
     * this addToken method also adds a glow
     * Sergei Levashov
     */
    public void addToken(int y, int x, int player)
    {
        JLabel test = new JLabel();
        if(Brain.getPlayerNum() == 1)
        {
            test.setIcon(new ImageIcon("images/circleglow.png")); //"images/people/" + "glow" + p1.getPath())
        }
        else
        {
            test.setIcon(new ImageIcon("images/circleglow.png"));//test.setIcon(new ImageIcon("images/people/" + "glow" + p2.getPath()));
        }
        if(isPC)
        {
            test.setBounds(y-8-25,x-10-25,135,135);
        }
        else
        {
            test.setBounds(y-6-25,x-8-25,135,135);
        }
        tokensGlow.add(test);
        tokensGlow.repaint();
        
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
                
                buttons.add(new Piece(y,x,Brain,this,sounds));
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
            if((int)(Math.random() * 2) == 0)
            {
                myAudioPlayer.play();
                myAudioPlayer.setOnEndOfMedia(new Runnable()
                {
                    public void run() {
                       myAudioPlayer.stop();
                    }
                });
            }
            else if((int)(Math.random() * 2) == 0)
            {
                myAudioPlayer2.play();
                myAudioPlayer2.setOnEndOfMedia(new Runnable()
                {
                    public void run() {
                       myAudioPlayer2.stop();
                    }
                });
            }
            else{
            myAudioPlayer3.play();
                myAudioPlayer3.setOnEndOfMedia(new Runnable()
                {
                    public void run() {
                       myAudioPlayer3.stop();
                    }
                });
            }
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
    public void addPlayerVsImage(String name, int player)
    {
        vsImage = new JLabel();
        vsImage.setIcon(new ImageIcon("images/people/" + name + "vs.png"));
        if(player == 1)
        {
            vsImage.setBounds(298,39,90,65);
        }
        else
        {
            vsImage.setBounds(589,39,90,65);
        }
        tokensGlow.add(vsImage);
        tokensGlow.repaint();
    }
    /**
     * Displays win screen for winning player and removes all buttons,tokens,and glows
     * 
     * Sergei Levashov
     */
    public void winDisplay(int player)
    {
        JLabel loser = new JLabel();
        JLabel winner = new JLabel();
        if(player == 1)
        {
            winner.setIcon(new ImageIcon("images/people/" + p2 + "win.png"));
            loser.setIcon(new ImageIcon("images/people/" + p1 + "lose.png"));
        }
        else
        {
            winner.setIcon(new ImageIcon("images/people/" + p1 + "win.png"));
            loser.setIcon(new ImageIcon("images/people/" + p2 + "lose.png"));
        }
        label.setIcon(new ImageIcon("images/boards/WinScreen" + player + ".png"));
        remove(tokens);
        remove(tokensGlow);
        for(Piece b: buttons)
        {
            remove(b);
        }
        remove(glow);
        remove(pb1);
        remove(pb2);
        winPanel.setBounds(0,0,1000,800);
        winner.setBounds(50,200,300,400);
        loser.setBounds(650,200,300,400);
        winPanel.add(winner);
        winPanel.add(loser);
        winPanel.repaint();
        winPanel.setVisible(true);
        winner.setVisible(true);
        loser.setVisible(true);
        repaint();
    }
    /**
     * makes winning token line glow and spin
     * 
     * Sergei Levashov
     */
    public void spinWinTokens(int[] winArr, int player)
    {
        Position myPos;
        sounds.DingDingDing();
        System.out.println(winArr[0] + " " + winArr[1] + " " + winArr[2] + " " + winArr[3] + " ");
        for(int x = 0; x < 4; x++)
        {
            
            System.out.println(buttons.get(winArr[x]).getPosition());
            myPos = buttons.get(winArr[x]).getPosition();
            addToken(getOffsetArray()[myPos.getY()][myPos.getX()].getY(),getOffsetArray()[0][myPos.getX()].getX()+103*(winArr[x]/7),player);
        }
    }
    /**
     * removes all board buttons
     * 
     * Sergei Levashov
     */
    public void removeAllButtons()
    {
        for(Piece b: buttons)
        {
            remove(b);
        }
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