import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Board extends JFrame{
    public Board(){
        super("Connect 4");
        PlayingBoard Brain = new PlayingBoard();
        setLayout(null);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/connect4board2.png"));
        Insets insets = getInsets();
        add(label);
        label.setBounds(0,0,800,800);
        generateButtons(50,50,insets);
    }
    private void generateButtons(int dim1, int dim2, Insets insets)
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
            b.setBounds(LeftInset + insets.left, TopInset + insets.top,70,70);
            makeButtonInvisible(b);
            LeftInset += 100;
                if(count == 7)
                {
                    LeftInset = 65;
                    TopInset += 102;
                    count = 0;
                }
            count++;
        }
        
        //here we add the buttons for the vs boxes on the top right of the board
        JButton p1 = new JButton();
        JButton p2 = new JButton();
        p2.setBounds(671,27,70,70);
        p1.setBounds(380,27,70,70);
        add(p1);
        add(p2);
        makeButtonInvisible(p2);
        makeButtonInvisible(p1);
        addVoiceBoxListener(p1,"left");
        addVoiceBoxListener(p2,"right");
        
        //back button
        JButton backButton = new JButton();
        backButton.setBounds(50, 25,70,70);
        add(backButton);
        backButtonListener(backButton);
        makeButtonInvisible(backButton);
    }
    private void addListener(JButton b)
    {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("pressed button"); //the button should have a row and colomb
                //use the dimension property to add it the matching spot in array in PlayingBoard
            }
        });
    }
    private void addVoiceBoxListener(JButton b, String s)
    {
        if(s.equals("left"))
        {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                    //then play the voice line of the left player
                    System.out.println("left player voice line");
            }
        });
        }
        else
        {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //play voice of right player;
                System.out.println("right player voice line");
            }
        });
        }
    }
    private void backButtonListener(JButton b) //implement change to new JFrame here
    {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("pressed back button");
            }
        });
    }
    private void makeButtonInvisible(JButton b)
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
    }
}