import javax.swing.*;
import java.awt.event.*;
/**
 * A modified JButton class with left and top insets, as well as a name and imagepath
 * 
 * Sergei Levashov
 */
public class playerButton extends JButton
{
    private String myName;
    private Menu myMenu;
    /**
     * adds a listener, assigns local variables, and sets bounds.
     * 
     * Sergei Levashov
     */
    playerButton(int left, int top, String name, Menu m)
    {
        addListener();
        myMenu = m;
        myName = name;
        setBounds(left,top,150,150);
    }
    public Player getPlayer()
    {
        return new Player(myName);
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
                    myMenu.setPlayer2(getPlayer());
                    System.out.println(getPlayer());
                    myMenu.initBoard();
                }
                else
                {
                    myMenu.setPlayer1(getPlayer());
                    myMenu.setPicked();
                    System.out.println(getPlayer());
                }
            }
        });
    }
    /**
     * local name getter for listener
     * 
     * Sergei Levashov
     */
    private String getPName()
    {
       return myName; 
    }
}
