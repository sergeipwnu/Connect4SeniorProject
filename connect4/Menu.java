import javax.swing.JFrame;
import javax.swing.*;
/**
 * Menu screen
 * 
 * Zachary
 */
public class Menu
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
        
    }
    public void start()
    {
        label = new JLabel();
        myBoard = new Board();
        myBoard.addMenu(label);
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setSize(1000,800);
        myBoard.setResizable(false);
        myBoard.setVisible(true);
        if(charactersSelected())
        {
            //startGame(); //to add the board just uncomment startGame
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
}
