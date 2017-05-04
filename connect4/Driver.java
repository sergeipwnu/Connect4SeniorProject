import javax.swing.JFrame;
public class Driver {

    public static void main(String[] args){

         Board myBoard = new Board();
         myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         myBoard.setSize(1500,1000);
         myBoard.setVisible(true);
    }
}