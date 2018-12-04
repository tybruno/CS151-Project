import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private Image image;
    protected int x;
    protected int y;
    private int imageHeight;
    private int imageWidth;

    /**
     * Constructor for an image panel object
     * @param filename The filepath to the image
     * @param x The starting x coordinate
     * @param y The starting y coordinate
     */
    public ImagePanel(String filename,int x,int y){                  
        
        this.x = x;
        this.y = y;
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource(filename);
        
        try{  
            ImageIcon icon = new ImageIcon(imageURL);
            this.image = icon.getImage();
        }catch(NullPointerException ex){           
            System.out.println(ex);
            System.out.println("FileName: "+ filename);
            System.out.println("Path: "+ imageURL);
        }
    }

    /**
     * overrides the paint component.
     * Paints/draws image
     * @param g graphic being used
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
//        int x = (getWidth() - image.getWidth())/2;
//        int y = (getHeight() - image.getHeight())/2;
        g.drawImage(image,x,y,this);
        this.setBounds(this.x,this.y,this.imageWidth,this.imageHeight);
    }

    /**
     * Set's the image width and image height to the object
     */
    public void setImageSizes(){
        this.imageWidth = this.image.getWidth(null);
        this.imageHeight = this.image.getHeight(null);
        this.setBounds(this.x,this.y,this.imageWidth,this.imageHeight);
    }

    /**
     * Returns the Image
     * @return Image variable
     */
    public Image getImage(){
        return this.image;
    }

    /**
     * moves the image up
     * @param speed The rate in which the image is moved
     */
    public void moveUp(int speed){
        this.y -= speed;
    }

    /**
     * moves the image down
     * @param speed The rate in which the image is moved
     */
    public void moveDown(int speed){
        this.y += speed;
    }

    /**
     * moves the image left
     * @param speed The rate in which the image is moved
     */
    public void moveLeft(int speed){
        this.x -= speed;
    }

    /**
     * moves the image right
     * @param speed The rate in which the image is moved
     */
    public void moveRight(int speed){
        this.x += speed;
    }

    /**
     * returns the xx position of the image
     * @return x coordinate of the image
     */
    public int getX(){
        return x;
    }

    /**
     * Returns the y position of the image
     * @return y coordinate of the image
     */
    public int getY(){
        return y;
    }

    /**
     * Sets the x coordinate
     * @param newX new x coordinate value
     */
    public void setX(int newX){
        x = newX;
    }

    /**
     *  sets the y coordinate
     * @param newY new y coordinate value
     */
    public void setY(int newY){
        y = newY;
    }


}
