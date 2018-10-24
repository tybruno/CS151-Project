import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private Image image;
    private int x;
    private int y;
    private int imageHeight;
    private int imageWidth;

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

    public void setImageSizes(){
        this.imageWidth = this.image.getWidth(null);
        this.imageHeight = this.image.getHeight(null);
    }

    public Image getImage(){
        return this.image;
    }
    public void moveUp(int speed){
        this.y -= speed;
    }

    public void moveDown(int speed){
        this.y += speed;
    }

    public void moveLeft(int speed){
        this.x -= speed;
    }

    public void moveRight(int speed){
        this.x += speed;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void changeX(int newX){
        x = newX;
    }

    public void changeY(int newY){
        y = newY;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
//        int x = (getWidth() - image.getWidth())/2;
//        int y = (getHeight() - image.getHeight())/2;
        g.drawImage(image,x,y,this);
    }

}
