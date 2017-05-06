import javax.swing.JFrame;
import javax.swing.*;
/**
 * Menu screen
 * 
 * Zachary
 */
public class Menu extends JFrame
{
    private Player player1 = null;
    private Player player2 = null;
    private Board myBoard;
    JLabel label;
    /**
     * Zachary
     */
    Menu()
    {
        super("Connect4 Menu");
        setLayout(null);
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("images/Connect4Menu.png"));
        menu.setBounds(0,0,1000,800);
        add(menu);
        createButtons();
    }
    public void initBoard()
    {
        myBoard = new Board();
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setSize(1000,800);
        myBoard.setResizable(false);
        myBoard.setVisible(true);
        if(charactersSelected())
        {
            startGame();
        }
        else
        {
            //continue selecting characters
        }
    }
    /**
     * Zachary
     */
    private void startGame()
    {
        myBoard.addBoard();
    }
    /**
     * Zachary
     */
    private boolean charactersSelected()
    {
        //if(player1 != null && player2 != null)
            return true;
        //return false;
    }
    private void createButtons()
    {
        add(makeButtonInvisible(new playerButton(135,200,"Omid","omid_face.png")));
        add(makeButtonInvisible(new playerButton(345,200,"Sergei","sergei_face.png")));
        add(makeButtonInvisible(new playerButton(555,200,"Omer","omer_face.png")));
        add(makeButtonInvisible(new playerButton(770,200,"Zachary","zach_face.png")));
    }
    private playerButton makeButtonInvisible(playerButton b)
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        return b;
    }
    
}
