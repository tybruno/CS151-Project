import javax.swing.*;
import java.awt.*;

public class ImagePanelTester {
    public static void main(String[] args)
    {
        String dronePath = ".DroneGame/drone.jpg";
        String missilePath = "missile.png";
        String fullpath = "C:\\Users\\Tyler\\IdeaProjects\\CS151-Project\\DroneGame\\src\\missile.png";

        ImagePanel contentPane= new ImagePanel(fullpath,0,0);

//        contentPane.setOpaque(true);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(contentPane);
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
