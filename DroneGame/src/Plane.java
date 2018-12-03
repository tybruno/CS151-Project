
import java.awt.Graphics2D;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fchon
 */
public class Plane extends ImagePanel{
    public int x = 0;
    public int y = 0;
    public double size = 0; 
    
    public Plane(){
        super("plane.png", 2000, 2000);
        
        Random rand = new Random(); 
        x = rand.nextInt(4000);
        y = rand.nextInt(300);
        size = (1 + rand.nextFloat())*2;      
    }
    
    public void redraw(Graphics2D g, ConfigurationSpace cs){
        x -= 1*size;      
        if(x <= - size*320){
            Random rand = new Random();            
            x = 2000 + rand.nextInt(2000);
        }
        
        g.drawImage(this.getImage(), x, y, (int)size*80, (int)size*52, cs);       
    }
}
