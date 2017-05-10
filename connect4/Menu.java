import javax.swing.JFrame;
import javax.swing.*;
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
    /**
     * 
     * Zachary
     */
    Menu()
    {
        super("Connect4 Menu");
        setLayout(null);
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("images/boards/Connect4Menu.png"));
        menu.setBounds(0,0,1000,800);
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
            myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    public boolean isPicked()
    {
        return playerInstanceLoaded;
    }
    public void setPicked()
    {
        playerInstanceLoaded = true;
    }
    public void setPlayer1(Player p)
    {
        player1 = p;
        player1.addColorToPath("b");
    }
    public void setPlayer2(Player p)
    {
        player2 = p;
        player2.addColorToPath("r");
    }
    /**
     * returns true if both players have selected a character, false if not
     * Zachary
     */
    private boolean charactersSelected() //TODO
    {
        //if(player1 != null && player2 != null)
            return true;
        //return false;
    }
    /**
     * creates all player buttons
     * Sergei
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
     * unlocckable caharacters
     * zachary
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
        //b.setOpaque(false);
        //b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        return b;
    }
    
}
