import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
/**
 * Menu screen
 * 
 * Zachary and Sergei
 */
public class Menu extends JFrame
{
    private Player player1 = null;
    private Player player2 = null;
    private Board myBoard;
    private boolean playerInstanceLoaded = false;
    JLabel label;
    JPanel playerIcons;
    private JLabel omid, sergei, omer, zach;
    /**
     * 
     * Zachary
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
     * 
     * Zachary
     */
    public void initBoard()
    {
            myBoard = new Board();
            myBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myBoard.setSize(1000,800);
            myBoard.setResizable(false);
            myBoard.setVisible(true);
            startGame();
            myBoard.setVisible(true);
            playerInstanceLoaded = false; // resets first player picked boolean to false
    }
    /**
     * starts the game by adding the board
     * Zachary
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
     * sets player 1 selected
     * 
     * Sergei Levashov
     */
    public void setPicked()
    {
        playerInstanceLoaded = true;
    }
    /**
     * sets the player to the player passed from listener, as well as the their piece color
     * 
     * Sergei Levashov
     */
    public void setPlayer1(Player p)
    {
        player1 = p;
        player1.addColorToPath("b");
    }
    /**
     * sets the player to the player passed from listener, as well as the their piece color
     * 
     * Sergei Levashov
     */
    public void setPlayer2(Player p)
    {
        player2 = p;
        player2.addColorToPath("r");
    }
    /**
     * creates all player buttons
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
        add(makeButtonInvisible(new playerButton(530,340,"lauren",this)));
        add(makeButtonInvisible(new playerButton(745,340,"bubbles",this)));
        
    }
    /**
     * unlocckable characters
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
    private void addPlayerImages()
    {
        omid = new JLabel();
        omid.setIcon(new ImageIcon("images/people/omidneutral.png"));
        omid.setBounds(123,182,140,140);
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
        zach.setBounds(735,182,140,140);
        playerIcons.add(zach);
        
        
    }
    
    public void changePlayerImage(enumPlayers p)
    {
        switch(p)
        {
            case OMID: 
                omid.setIcon(new ImageIcon("images/people/omidpick.png"));
                omid.setBounds(123,182,140,140);    
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
                zach.setIcon(new ImageIcon("images/people/zachpick.png"));
                zach.setBounds(735,182,140,140);
                repaint();
                break; 
        }
    }
}
