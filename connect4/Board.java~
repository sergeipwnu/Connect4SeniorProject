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
        ArrayList<Piece> buttons = new ArrayList<Piece>();
        int LeftInset = 65;
        int count = 1;
        int TopInset = 145;
        for(int y = 0; y < 6; y++)
        {
            for(int x = 0; x < 7; x++)
            {
                Piece p = new Piece(y,x);
                buttons.add(p);
                p.addListener();
            }
        }
        
        for(Piece b : buttons)
        {
            add(b);
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
        Piece p1 = new Piece();
        Piece p2 = new Piece();
        p2.setBounds(671,27,70,70);
        p1.setBounds(380,27,70,70);
        add(p1);
        add(p2);
        makeButtonInvisible(p2);
        makeButtonInvisible(p1);
        Player Player1 = new Player("testname",0);
        Player Player2 = new Player("testname",0);
        Player1.addVoiceBoxListener(p1,"left");
        Player2.addVoiceBoxListener(p2,"right");
        
        //back button
        Piece backButton = new Piece();
        backButton.setBounds(50, 25,70,70);
        add(backButton);
        backButtonListener(backButton);
        makeButtonInvisible(backButton);
    }
    
    private void backButtonListener(Piece b) //implement change to new JFrame here
    {
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("pressed back button");
            }
        });
    }
    private void makeButtonInvisible(Piece b)
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
    }
}