import javax.swing.JFrame;
public class Driver {
    /**
     * Connect4!
     * Author: Sergei Levashov
     */
    public static void main(String[] args){
        System.out.println("as of now, only omid and zachary work as characters");
        Menu mainMenu = new Menu();
        mainMenu.setSize(1000,800);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setResizable(false);
        mainMenu.setVisible(true);
        
    }
}