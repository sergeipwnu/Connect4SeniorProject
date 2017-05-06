import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class playerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerButton extends JButton
{
    private String myName;
    private String myImagePath;
    playerButton(int left, int top, String name, String imagepath)
    {
        addListener();
        myName = name;
        myImagePath = imagepath;
        setBounds(left,top,100,100);
    }
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
    private String getPName()
    {
       return myName; 
    }
    private String getImagePath()
    {
        return myImagePath;
    }
}
