import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.concurrent.CountDownLatch;
import javafx.embed.swing.JFXPanel;
public class Driver {
    /**
     *  Creates a new CountDownLatch and initializes JFX, then initializes the menu @ 1000X800
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
                       latch.countDown(); //runs latch countdown until JFXPanel fully loaded,
                                          //this is to prevent the toolkit from being initialized afterwords
                 }
            });
            Menu mainMenu = new Menu();
            mainMenu.setSize(1000,800);
            mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenu.setResizable(false);
            mainMenu.setVisible(true);
    }
}