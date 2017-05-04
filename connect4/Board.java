import java.awt.FlowLayout;
import javax.swing.*;


public class Board extends JFrame{
    public Board(){
        super("Connect 4");
        setLayout(new FlowLayout());
        JButton okButton = new JButton("OK"); 
        Icon board = new ImageIcon("images/connect4board.png");
        add(new JLabel(board));
        add(okButton);
    }
}