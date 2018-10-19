import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private int x;
    private int y;

    public ImagePanel(String filename,int x,int y){

        try{
            this.image = ImageIO.read(new File(filename));
            this.x = x;
            this.y = y;
        }
        catch(IOException ex){
            System.out.println(ex);
        }
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
