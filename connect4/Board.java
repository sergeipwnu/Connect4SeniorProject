import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Board extends JFrame{
    public Board(){
        super("Connect 4");
        setLayout(null);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/connect4board2.png"));
        Insets insets = getInsets();
        add(label);
        label.setBounds(0,0,800,800);
        generateButtons(50,50,insets,label);

    }
    private void generateButtons(int dim1, int dim2, Insets insets, JLabel label)
    {
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        int LeftInset = 65;
        int count = 1;
        int TopInset = 145;
        for(int x = 0; x < 7*6; x++)
        {
            buttons.add(new JButton());
        }
        
        for(JButton b : buttons)
        {
        add(b);
        addListener(b);
        b.setBounds(LeftInset + insets.left, TopInset + insets.top,
             70,70);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        LeftInset += 100;
        if(count == 7)
        {
            LeftInset = 65;
            TopInset += 102;
            count = 0;
        }
        count++;
        }
    }
    private void addListener(JButton b)
    {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("pressed button");
            }
        });
    }
}