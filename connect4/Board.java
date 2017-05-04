import java.awt.*;
import javax.swing.*;


public class Board extends JFrame{
    public Board(){
        super("Connect 4");
        setLayout(null);
        //Icon board = new ImageIcon("images/connect4board.png");
        //add(new JLabel(board));
        
        
        JButton button = new JButton("test");
        button.setSize(new Dimension(100,100));
        add(button);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        /*
        for(int x = 0; x < 6 * 7; x++)
        {
        add(new JButton("Button1"));
        }
        */
    }
   
}