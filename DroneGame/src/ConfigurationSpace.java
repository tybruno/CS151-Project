import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * Creates the Board objeect
 * This tutorial helped us make this class http://zetcode.com/tutorials/javagamestutorial/movingsprites/
 */
public class ConfigurationSpace extends JPanel implements ActionListener {
    private Timer timer;
    private Drone drone;
    private final int STARTING_X = 20;
    private final int STARTING_Y = 20;
    private final String DRONE_PATH = "drone.jpg";
    private final int TIMER_DELAY = 10;

    /**
     * The constructor for the board
     */
    public ConfigurationSpace() {

        addKeyListener(new keysListener());
        setFocusable(true);
        setBackground(Color.BLUE);
//        setDoubleBuffered(true);
        this.drone = new Drone(DRONE_PATH, STARTING_X, STARTING_Y);

        //need this so we can move the drone
        timer = new Timer(TIMER_DELAY, this);
        timer.start();
    }

    /**
     * Key listener class for the drone
     * Checks if the arrow keys are pressed or released
     * if the arrow key is pressed the x and y values will be updated accordingly
     * if the arrow key is released it resets the new x and new y value
     */
    private class keysListener extends KeyAdapter {
        /**
         * If key is pressed change the drone's x or y coordinates
         *
         * @param e event triggered
         */
        @Override
        public void keyPressed(KeyEvent e) {
            drone.keyPressed(e);
        }

        /**
         * If an arrow key is released reset the new x and new y value
         *
         * @param e event triggered
         */
        @Override
        public void keyReleased(KeyEvent e) {
            drone.keyReleased(e);
        }

    }

    /**
     * Overrides the paintComponenet
     *
     * @param g graphic being used
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(drone.getImage(), drone.getX(), drone.getY(), this);
//        Toolkit.getDefaultToolkit().sync();


    }

    /**
     * Overrides the action performed
     * <p>
     * Moves the drone and repaints it if x or y values change for the drone
     *
     * @param e Event that triggers the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        drone.move();
        repaint();
    }


}
