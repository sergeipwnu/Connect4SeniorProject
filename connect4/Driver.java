import javax.swing.JFrame;
public class Driver {

    public static void main(String[] args){

         Board myBoard = new Board();
         myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         myBoard.setSize(800,800);
         myBoard.setVisible(true);
    }
}