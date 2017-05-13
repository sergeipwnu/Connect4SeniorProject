import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.concurrent.CountDownLatch;
import javafx.embed.swing.JFXPanel;
public class Driver {
    /**
     * Connect4!
     * Author: Sergei Levashov
     */
    public static void main(String[] args)
    {
            final CountDownLatch latch = new CountDownLatch(1);
            SwingUtilities.invokeLater(new Runnable()
            {
                 public void run() 
                 {
                       new JFXPanel();
                        latch.countDown();
                 }
            });
            System.out.println("as of now, only omid and zachary work as characters");
            Menu mainMenu = new Menu();
            mainMenu.setSize(1000,800);
            mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenu.setResizable(false);
            mainMenu.setVisible(true);
    }
}