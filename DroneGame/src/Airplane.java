import javax.swing.*;
import java.awt.*;
//Need to finish this

public class Airplane extends ImagePanel{
    private int newX;
    private int newY;

    public Airplane(String imagePath, int startingX,int startingY){
        super(imagePath, startingX, startingY);
        setImageSizes();
    }

    /**
     * Moves the object by updating the new x and y values for the image
     */
    public void move() {
        x--;
    }

    public void resetToLeft(){
        x = 500;
        y = 10;
    }


}
