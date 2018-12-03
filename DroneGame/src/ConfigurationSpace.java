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
    private TimerImplementation timerImpl;
    private final int STARTING_X = 20;
    private final int STARTING_Y = 20;
    private final String DRONE_PATH = "drone.png";
    private final int TIMER_DELAY = 16;// 16.666 ms = 60fps
    private long previousTime;
    private final int NUMBEROFCLOUDS = 10;
    private Cloud[] cloud = new Cloud[NUMBEROFCLOUDS];
    
    private final int NUMBEROFPLANES = 10;
    private Plane[] planes = new Plane[NUMBEROFPLANES] ;      
    
    /**
     * The constructor for the board
     */
    public ConfigurationSpace() {
        previousTime = System.currentTimeMillis();
        addKeyListener(new keysListener());
        setFocusable(true);
        setBackground(new Color(135,206,235));
//        setDoubleBuffered(true);
        this.drone = new Drone(DRONE_PATH, STARTING_X, STARTING_Y);
        this.timerImpl = new TimerImplementation();
        timerImpl.setBounds(1,100,75,75);
        add(timerImpl);
        //clouds
        for(int i=0; i < NUMBEROFCLOUDS; i++){
            this.cloud[i] = new Cloud();
        }
        
        //planes
        for(int i=0; i < NUMBEROFPLANES; i++){
            this.planes[i] = new Plane();
        }        
        
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

        //drawing clouds
        for(int i=0; i < NUMBEROFCLOUDS; i++){
            cloud[i].redraw(g2, this);
        }        
            
        //drawing drone 
        g2.drawImage(drone.getImage(), drone.getX(), drone.getY(), 204, 204, this);
        
        //drawing planes
        for(int i=0; i < NUMBEROFPLANES; i++){
            planes[i].redraw(g2, this);
        }          
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
