import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImagePanelTester {
    public static void main(String[] args)
    {
        String droneName = "drone.jpg";
        String missileName = "missile.png";

        ImagePanel contentPane= new ImagePanel(missileName,0,0);


        JButton down = new JButton("Down");



//        contentPane.setOpaque(true);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(contentPane);
        f.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    System.out.println("down key");
                }
            }

        });
        f.setSize(400,400);
        f.setLocation(200,200);
        f.add(down);
        f.setVisible(true);

        down.addActionListener(event ->{contentPane.moveDown(10);contentPane.repaint();});


//        JFrame f2 = new JFrame();
//        f2.add(down);
//        f2.setVisible(true);
    }
}
