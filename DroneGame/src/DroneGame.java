import javax.swing.*;
import java.awt.*;

/**
 * this is the game
 * This tutorial helped us make this class http://zetcode.com/tutorials/javagamestutorial/movingsprites/
 */
//Main class
public class DroneGame extends JFrame{

    /**
     * The Game that is being played
     *
     */
    public DroneGame(){
        add(new ConfigurationSpace());
        setSize(960,540);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            DroneGame game = new DroneGame();
            game.setVisible(true);
        });

    }
}
