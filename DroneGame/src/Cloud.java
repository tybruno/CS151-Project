
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
public class Cloud extends ImagePanel{
    public int x = 0;
    public int y = 0;
    public int size = 0; 
    
    public Cloud(){
        super("cloud.png", 2000, 2000);
        
        Random rand = new Random(); 
        x = rand.nextInt(2000);
        y = rand.nextInt(500);
        size = 1 + rand.nextInt(5);      
    }
    
    public void redraw(Graphics2D g, ConfigurationSpace cs){
        x -= 1*size;      
        if(x <= - size*320){
            Random rand = new Random();            
            x = 2000 + rand.nextInt(2000);
        }
        
        g.drawImage(this.getImage(), x, y, size*80, size*52, cs);       
    }
}
