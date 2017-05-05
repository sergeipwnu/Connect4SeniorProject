import javax.swing.JFrame;
public class Driver {
    /**
     * Connect4!
     * Author: Sergei Levashov
     */
    public static void main(String[] args){

         Board myBoard = new Board();
         myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         myBoard.setSize(1000,800);
         myBoard.setResizable(false);
         myBoard.setVisible(true);
    }
}