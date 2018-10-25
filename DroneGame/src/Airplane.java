import javax.swing.*;
//Need to finish this
public class Airplane extends ImagePanel{
    private int newY;

    public Airplane(String imagePath, int startingX,int startingY){
        super(imagePath, startingX, startingY);
        setImageSizes();
    }

    /**
     * Moves the object by updating the new x and y values for the image
     */
    public void move() {
        y += newY;
    }





}
