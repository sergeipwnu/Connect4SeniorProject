import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import chn.util.FileInput;
import chn.util.FileOutput;
/**
 * class <code>Menu</code> - is the menu screen, a window which launches a new Board
 * It extends <code>JFrame</code>  class
 * 
 * @see JFrame API
 * @author Sergei
 * @version 1.0.0
 */
public class Menu extends JFrame
{
    //private int[] winCountByPlayer;
    private int winCount = 0;
    private FileInput f;
    private Player player1 = null;
    private Player player2 = null;
    private Board myBoard;
    private boolean isPC = false;
    private boolean playerInstanceLoaded = false;
    JLabel label;
    JPanel playerIcons;
    private JLabel omid, sergei, omer, zach, warrick, lauren, catherines, kanika, tim, lants;
    /**
     * constructor <code>Menu()</code> - will creates isPC variable to 
     * calculate offsets later in Board.
     * Will also create and add all buttons to the JFrame, as well as player images
     * 
     * @author Sergei
     */
    Menu()
    {
        super("Connect4 Menu");
        if(System.getProperty("os.name").indexOf("Mac") != -1)
        {
            //System.out.println("you are using a mac");
        }
        else
        {
            //System.out.println("you are using a pc");
            isPC = true;
            setIconImage(new ImageIcon("images/icons/connect4.png").getImage());
        }
        loadFromFile();
        setLayout(null);
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("images/boards/Connect4Menu.png"));
        menu.setBounds(0,0,1000,800);
        menu.setVisible(true);
        tim = new JLabel();
        lants = new JLabel();
        playerIcons = new JPanel();
        playerIcons.setBounds(0,0,1000,800);
        playerIcons.setBackground(new Color(0,0,0,0));
        playerIcons.setLayout(null);
        addPlayerImages();
        add(playerIcons);
        add(menu);
        createButtons();
        
        //System.out.println("win count: " + winCount);
        
    }
    
    /**
     * <code>initBoard()</code> <b>summary</b>: initializes the board with the isPC variable
     * 
     * Postcondition: DISPOSE_ON_CLOSE,1000x800,non-resizable
     * 
     * @author Sergei
     */
    public void initBoard()
    {
            myBoard = new Board(isPC, this);
            myBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myBoard.setSize(1000,800);
            myBoard.setResizable(false);
            myBoard.setVisible(true);
            startGame();
            myBoard.setVisible(true);
            playerInstanceLoaded = false; // resets first player picked boolean to false
    }
    
    /**
     * <code>startGame()</code> <b>summary</b>: starts the game by launching the local Board with both players
     * @author Sergei
     */
    private void startGame()
    {
        myBoard.addBoard(player1, player2);
    }
    
    /**
     * <code>isPicked()</code> <b>summary</b>: returns true if player 1 is already selected, false if not
     * 
     * @return true or false if player 1 is picked
     * @author Sergei Levashov
     */
    public boolean isPicked()
    {
        return playerInstanceLoaded;
    }
     /**
     * <code>setPicked()</code> <b>summary</b>: sets player 1 to be selected
     * 
     * @author Sergei Levashov
     */
    public void setPicked()
    {
        playerInstanceLoaded = true;
    }
    /**
     * <code> setPlayer()</code> <b>summary</b>: sets the player to the player passed from listener, as well as the their piece color
     * player1 is set to blue
     * Sergei Levashov
     */
    public void setPlayer1(Player p)
    {
        player1 = p;
        player1.addColorToPath("b");
    }
    
    /**
     * <code> setPlayer2()</code> <b>summary</b>: sets the player to the player passed from listener, as well as the their piece color
     * player2 is set to red
     * Sergei Levashov
     */
    public void setPlayer2(Player p)
    {
        player2 = p;
        player2.addColorToPath("r");
    }
    
    /**
     * <code>createButtons()</code> <b>summary</b>: creates all player buttons and makes them <b>invisible</b>
     * 
     * @author Sergei and Zachary and Omid
     */
    private void createButtons()
    {
        if(winCount > 999)
        {
            add(makeButtonInvisible(new playerButton(330,555,"l",this)));
        }
        if(winCount > 99)
        {
            add(makeButtonInvisible(new playerButton(530,555,"tim",this)));
        }
        
        //first row
        add(makeButtonInvisible(new playerButton(110,175,"omid",this)));
        add(makeButtonInvisible(new playerButton(320,175,"sergei",this)));
        add(makeButtonInvisible(new playerButton(530,175,"omer",this)));
        add(makeButtonInvisible(new playerButton(745,175,"zachary",this)));
        
        //second row
        add(makeButtonInvisible(new playerButton(110,340,"warrick",this)));
        add(makeButtonInvisible(new playerButton(320,340,"catherines",this)));
        add(makeButtonInvisible(new playerButton(530,340,"hannah",this)));
        add(makeButtonInvisible(new playerButton(745,340,"kanika",this)));
    }
    /**
     * <code>playerButton()</code> <b>summary</b>: returns the passed playerButton as invisible
     * 
     * @return <b>invisible</b> <code>playerButton</code>  
     * @param  <code>playerButton</code> to be made invisible
     * @author Sergei
     */
    private playerButton makeButtonInvisible(playerButton b)
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        return b;
    }
    /**
     * <code>addPlayerImages()</code> <b>summary</b>: adds all player images 
     * to the JPanel over the <b>invisible</b> buttons
     * 
     * @author Sergei
     */
    public void addPlayerImages()
    {
        omid = new JLabel();
        omid.setIcon(new ImageIcon("images/people/omidneutral.png"));
        omid.setBounds(110,182,140,140);
        playerIcons.add(omid);
        
        sergei = new JLabel();
        sergei.setIcon(new ImageIcon("images/people/sergeineutral.png"));
        sergei.setBounds(322,182,140,140);
        playerIcons.add(sergei);
        
        omer = new JLabel();
        omer.setIcon(new ImageIcon("images/people/omerneutral.png"));
        omer.setBounds(535,182,140,140);
        playerIcons.add(omer);
        
        zach = new JLabel();
        zach.setIcon(new ImageIcon("images/people/zachneutral.png"));
        zach.setBounds(745,182,140,140);
        playerIcons.add(zach);
        
        warrick = new JLabel();
        warrick.setIcon(new ImageIcon("images/people/warrickneutral.png"));
        warrick.setBounds(110,348,140,140);
        playerIcons.add(warrick);
        
        catherines = new JLabel();
        catherines.setIcon(new ImageIcon("images/people/catherinesneutral.png"));
        catherines.setBounds(322,348,140,140);
        playerIcons.add(catherines);
        
        lauren = new JLabel();
        lauren.setIcon(new ImageIcon("images/people/hannahneutral.png"));
        lauren.setBounds(535,348,139,140);
        playerIcons.add(lauren);
        
        kanika = new JLabel();
        kanika.setIcon(new ImageIcon("images/people/kanikaneutral.png"));
        kanika.setBounds(745,348,140,140);
        playerIcons.add(kanika);
        
        if(winCount > 99)
        {
            unlockTim();
        }
        if(winCount > 999)
        { 
            unlockL();
        }
    }
    
    /**
     * <code>resetNeutral()</code> <b>summary</b>: Changes all player images to neutral version after end of the game
     * 
     * @author Omid
     */
    public void resetNeutral()
    {
        omid.setIcon(new ImageIcon("images/people/omidneutral.png"));
        omid.setBounds(110,182,140,140);
        
        sergei.setIcon(new ImageIcon("images/people/sergeineutral.png"));
        sergei.setBounds(322,182,140,140);
        
        omer.setIcon(new ImageIcon("images/people/omerneutral.png"));
        omer.setBounds(535,182,140,140);
        
        zach.setIcon(new ImageIcon("images/people/zachneutral.png"));
        zach.setBounds(745,182,140,140);
        
        warrick.setIcon(new ImageIcon("images/people/warrickneutral.png"));
        warrick.setBounds(110,348,140,140);
        
        catherines.setIcon(new ImageIcon("images/people/catherinesneutral.png"));
        catherines.setBounds(322,348,140,140);

        lauren.setIcon(new ImageIcon("images/people/hannahneutral.png"));
        lauren.setBounds(535,348,139,140);
       
        kanika.setIcon(new ImageIcon("images/people/kanikaneutral.png"));
        kanika.setBounds(745,348,140,140);
        
        if(winCount > 999)
        {
            add(makeButtonInvisible(new playerButton(330,555,"l",this)));
            lants.setIcon(new ImageIcon("images/people/lneutral.png"));
            lants.setBounds(322,568,140,140);
        }
        if(winCount > 99)
        {
            add(makeButtonInvisible(new playerButton(530,555,"tim",this)));
            tim.setIcon(new ImageIcon("images/people/timneutral.png"));
            tim.setBounds(534,568,140,140);
        }
    }
    
    /**
     * <code>changePlayerImage()</code> <b>summary</b>: overlays pick image over passed player
     * 
     * @param <code>enumPlayers</code> p -- enum representation of the player names
     * @author Omer
     */
    public void changePlayerImage(enumPlayers p)
    {
        switch(p)
        {
            case OMID: 
                omid.setIcon(new ImageIcon("images/people/omidpick.png"));
                omid.setBounds(110,182,140,140);    
                repaint();
                break;
            case SERGEI:
                sergei.setIcon(new ImageIcon("images/people/sergeipick.png"));
                sergei.setBounds(322,182,140,140);  
                repaint();
                break;
            case OMER:
                omer.setIcon(new ImageIcon("images/people/omerpick.png"));
                omer.setBounds(535,182,140,140);
                repaint();
                break;
            case ZACH:
                zach.setIcon(new ImageIcon("images/people/zacharypick.png"));
                zach.setBounds(745,182,140,140);
                repaint();
                break; 
            case WARRICK:
                warrick.setIcon(new ImageIcon("images/people/warrickpick.png"));
                warrick.setBounds(110,348,140,140);
                repaint();
                break;
            case CATS:
                catherines.setIcon(new ImageIcon("images/people/catherinespick.png"));
                catherines.setBounds(322,348,140,140);
                repaint();
                break; 
            case HANNAH:
                lauren.setIcon(new ImageIcon("images/people/hannahpick.png"));
                lauren.setBounds(535,348,139,140);
                repaint();
                break; 
            case KANIKA:
                kanika.setIcon(new ImageIcon("images/people/kanikapick.png"));
                kanika.setBounds(745,348,140,140);
                repaint();
                break; 
            case TIM:
                tim.setIcon(new ImageIcon("images/people/timpick.png"));
                tim.setBounds(534,568,140,140);
                repaint();
                break; 
            case L:
                lants.setIcon(new ImageIcon("images/people/lpick.png"));
                lants.setBounds(322,568,140,140);
                repaint();
                break;
        }
    }
    
    /**
     * <code>loadFromFile()</code> <b>summary</b>: will load win data from a file
     * 
     * @author Omer
     */
    private void loadFromFile()
    {
        f = new FileInput("wincount.txt");
        winCount = f.readInt();
    }
    
    /**
     * <code>unlockTim()</code> <b>summary</b>: will unlock Tim the Enchanter and make
     * him into a playable character
     * 
     * @author Omid
     */
    public void unlockTim()
    {
        tim.setIcon(new ImageIcon("images/people/timneutral.png"));
        tim.setBounds(534,568,140,140);
        playerIcons.add(tim);
        repaint();
    }
    /**
     * <code>unlockL()</code> <b>summary</b>: will unlock Mr. L and make
     * him into a playable character
     * 
     * @author Omid
     */
    public void unlockL()
    {
        lants.setIcon(new ImageIcon("images/people/lneutral.png"));
        lants.setBounds(322,568,140,140);
        playerIcons.add(lants);
        repaint();
    }
    
    /**
     * <code>addWin()</code> <b>summary</b>: will add a win to the total win count
     * 
     * @authot omer
     */
    public void addWin()
    {
        winCount++;
        writeToFile();
    }
    
    /**
     * <code>writeToFile</code> <b>summary</b>: writes the data to a .txt file when programs closes 
     * 
     * @author Zach
     */
    public void writeToFile()
    {
        FileOutput outFile = new FileOutput("wincount.txt", "write"); //opens in write mode to overwrite the data
        outFile.print(winCount);
        outFile.close();
    }
    
    public int getWins()
    {
        return winCount;
    }
}
