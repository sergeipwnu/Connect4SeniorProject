import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
/**
 * the menu screen, a window which launches a new Board
 * 
 * Sergei
 */
public class Menu extends JFrame
{
    private Player player1 = null;
    private Player player2 = null;
    private Board myBoard;
    private boolean isPC = false;
    private boolean playerInstanceLoaded = false;
    JLabel label;
    JPanel playerIcons;
    private JLabel omid, sergei, omer, zach, warrick, lauren, catherines, kanika;
    /**
     * Creates isPC variable to calculate offsets later in Board.
     * Creates and adds all buttons to the JFrame, as well as player images
     * Sergei
     */
    Menu()
    {
        super("Connect4 Menu");
        if(System.getProperty("os.name").indexOf("Mac") != -1)
        {
            System.out.println("you are using a mac");
            
            //figure out how to add icon image for mac here
        }
        else
        {
            System.out.println("you are using a pc");
            isPC = true;
            setIconImage(new ImageIcon("images/icons/connect4.png").getImage());
        }
        setLayout(null);
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("images/boards/Connect4Menu.png"));
        menu.setBounds(0,0,1000,800);
        menu.setVisible(true);
        playerIcons = new JPanel();
        playerIcons.setBounds(0,0,1000,800);
        playerIcons.setBackground(new Color(0,0,0,0));
        playerIcons.setLayout(null);
        addPlayerImages();
        add(playerIcons);
        add(menu);
        createButtons();
    }
    /**
     * Initializes the board with the isPC variable
     * Postcondition: DISPOSE_ON_CLOSE,1000x800,non-resizable
     * Sergei
     */
    public void initBoard()
    {
            myBoard = new Board(isPC);
            myBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myBoard.setSize(1000,800);
            myBoard.setResizable(false);
            myBoard.setVisible(true);
            startGame();
            myBoard.setVisible(true);
            playerInstanceLoaded = false; // resets first player picked boolean to false
    }
    /**
     * starts the game by launching the local Board with both players
     * Sergei
     */
    private void startGame()
    {
        myBoard.addBoard(player1, player2);
    }
    /**
     * returns true if player 1 is already selected, false if not
     * 
     * Sergei Levashov
     */
    public boolean isPicked()
    {
        return playerInstanceLoaded;
    }
     /**
     * sets player 1 to selected
     * Sergei Levashov
     */
    public void setPicked()
    {
        playerInstanceLoaded = true;
    }
    /**
     * sets the player to the player passed from listener, as well as the their piece color
     * player1 is set to blue
     * Sergei Levashov
     */
    public void setPlayer1(Player p)
    {
        player1 = p;
        player1.addColorToPath("b");
    }
    /**
     * sets the player to the player passed from listener, as well as the their piece color
     * player2 is set to red
     * Sergei Levashov
     */
    public void setPlayer2(Player p)
    {
        player2 = p;
        player2.addColorToPath("r");
    }
    /**
     * creates all player buttons and makes them invisible
     * Sergei and Zachary
     */
    private void createButtons()
    {
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
     * Represents the unlocckable characters. (Mr. L and Tim)
     * 
     * Zachary
     */
    private void unlock()
    {
        add(makeButtonInvisible(new playerButton(320,560,"Mr. L",this)));
        add(makeButtonInvisible(new playerButton(530,560,"unknown",this)));
    }
    /**
     * returns the passed playerButton as invisible
     * Sergei
     */
    private playerButton makeButtonInvisible(playerButton b)
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        return b;
    }
    /**
     * adds all player images to the JPanel over the invisible buttons
     * Sergei
     */
    private void addPlayerImages()
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
    }
    /**
     * overlays pick image over passed player
     * Sergei
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
        }
    }
}
