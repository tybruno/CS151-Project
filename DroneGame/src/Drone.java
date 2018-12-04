import java.awt.event.KeyEvent;

/**
 * Creates the drone object
 * This tutorial helped us make this class http://zetcode.com/tutorials/javagamestutorial/movingsprites/
 */
public class Drone extends ImagePanel {
    private int newX;
    private int newY;

    /**
     * Drone constructor
     *
     * @param imagePath File path to drone image
     * @param startingX Starting X position of the image
     * @param startingY Starting y position of the image
     */
    public Drone(String imagePath, int startingX, int startingY) {
        super(imagePath, startingX, startingY);
        setImageSizes();
    }

    /**
     * Event function that checks when
     * the key is released. when the key
     * is released, reset the new y and new x values
     *
     * @param e key event that is triggered
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        //key up
        if (key == KeyEvent.VK_UP) {
            this.newY = 0;
        }

        //key down
        if (key == KeyEvent.VK_DOWN) {
            this.newY = 0;
        }

        //key left
        if (key == KeyEvent.VK_LEFT) {
            this.newX = 0;
        }

        //key right
        if (key == KeyEvent.VK_RIGHT) {
            this.newX = 0;
        }

    }

    /**
     * Event function that checks when
     * the key is pressed. when the key
     * is pressed, update the new x or y value with new position (by 1)
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            this.newY = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
            this.newY = 5;

        }

        if (key == KeyEvent.VK_LEFT) {
            this.newX = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.newX = 5;
        }


    }

    /**
     * Moves the object by updating the new x and y values for the image
     */
    public void move() {
        x += newX;
        y += newY;
        setImageSizes();

    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public void reset(){
        x -= 20;
    }


}
