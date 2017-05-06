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
    private String myImagePath;
    /**
     * adds a listener, assigns local variables, and sets bounds.
     * 
     * Sergei Levashov
     */
    playerButton(int left, int top, String name, String imagepath)
    {
        addListener();
        myName = name;
        myImagePath = imagepath;
        setBounds(left,top,100,100);
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
                System.out.println(getPName() + " " + getImagePath());
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
    /**
     * local imagepath getter for listener
     * 
     * Sergei Levashov
     */
    private String getImagePath()
    {
        return myImagePath;
    }
}
