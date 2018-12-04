import javax.swing.*;

public class Tries extends JLabel{
    JLabel label = this;
    private int tries;

    public Tries(){
        tries = 3;
        label.setText(tries+ " tries left. Out of 3.");
    }

    public void crash(){
        tries--;
        label.setText(tries + " tries left. Out of 3");
    }

    public void win(){
        tries = 3;
        label.setText(tries + " tries left. Out of 3");
    }

    public int getTries(){
        return tries;
    }

    public void reload(){
        tries = 3;
        label.setText(tries + " tries left. Out of 3");
    }
}
