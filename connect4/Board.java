import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Board extends JFrame{
    private PlayingBoard Brain;
    private JLabel label;
    private Player p1;
    private Player p2;
    private JPanel tokens;
    /**
     * Board constructor, initializes the JFframe
     * Author: Sergei Levashov
     */
    public Board(){
        super("Connect 4");
        Brain = new PlayingBoard();
        setLayout(null);
    }
    /**
     * generates a new board and buttons
     * Author: Sergei Levashov
     */
    public void addBoard(Player player1, Player player2)
    {
        p1 = player1;
        p2 = player2;
        label = new JLabel();
        tokens = new JPanel();
        label.setIcon(new ImageIcon("images/connect4board2.png"));
        tokens.setLayout(null);
        tokens.setOpaque(true);
        addToken(0,0); //this should be moved to the Peices Listener later
        tokens.setBackground(new Color(0,0,0,0));
        add(tokens);
        add(label);
        tokens.setBounds(0,0,1000,800);
        label.setBounds(0,0,1000,800);
        generateButtons(getInsets(),Brain);
    }
    /**
     * adds a single token, at the specified y and x
     * Author: Sergei Levashov
     */
    public void addToken(int y, int x)
    {
        JLabel test = new JLabel();
        test.setIcon(new ImageIcon("images/greentest.png"));
        test.setBounds(173,160,60,60);
        tokens.add(test);
    }
    /**
     * generates the 6X7 grid of buttons and makes them invisible
     * Author: Sergei Levashov
     */
    private void generateButtons(Insets insets,PlayingBoard Brain)
    {
        ArrayList<Piece> buttons = new ArrayList<Piece>();
        int LeftInset = 165;
        int count = 1;
        int TopInset = 129;
        for(int y = 0; y < 6; y++)
        {
            for(int x = 0; x < 7; x++) //adds in all buttons
            {
                Piece p = new Piece(y,x,Brain);
                buttons.add(p);
                p.addListener(); //this adds a listener in the instance of the button
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
                    LeftInset = 165;
                    TopInset += 103;
                    count = 0;
                }
            count++;
        }
        
        //here we add the buttons for the vs boxes on the top right of the board
        Piece p1 = new Piece();
        Piece p2 = new Piece();
        p2.setBounds(615,34,70,70);
        p1.setBounds(317,34,70,70);
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
        backButton.setBounds(30, 32,70,70);
        add(backButton);
        backButtonListener(backButton);
        makeButtonInvisible(backButton);
    }
    /**
     * creates listener at back button
     * Author: Sergei Levashov
     */
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
    /**
     * makes the JButton passed invisible
     * Author: Sergei Levashov
     */
    private void makeButtonInvisible(Piece b) //makes an individual button invisible
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        
    }
    public void addMenuButtons()
    {
        
    }
}