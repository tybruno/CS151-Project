import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Timer;
import java.util.TimerTask;

public class TimerImplementation extends JLabel {

    JLabel label = this;

    public boolean bool = false;

    int sec = 0;
    int min = 0;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            if (sec < 59)
                sec++;
            else {
                sec = 0;
                min++;
            }
            if (sec < 10 && min < 10)
                label.setText("Timer: 0" + Integer.toString(min) + ":0" + Integer.toString(sec));
            else if (min < 10)
                label.setText("Timer: 0" + Integer.toString(min) + ":" + Integer.toString(sec));
            else
                label.setText("Timer: " + Integer.toString(min) + ":" + Integer.toString(sec));
        }
    };

    public TimerImplementation() {
        bool = true;
        timer.scheduleAtFixedRate(task, 1000, 1000);
        this.setHorizontalAlignment(SwingConstants.RIGHT);
//		this.setBounds(500, 400, 75, 75);
    }
}

