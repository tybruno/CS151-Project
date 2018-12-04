import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Timer;
import java.util.TimerTask;

public class TimerImplementation extends JLabel {

    JLabel label = this;

    public boolean bool = false;

    int sec = 30;
    int min = 1;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            if (sec > 0)
                sec--;
            else if(min==1) {
                min--;
                sec = 59;
            }
            else{
                min=0;
                sec=0;
            }
            if (sec < 10 && min < 10)
                label.setText("Timer: 0" + Integer.toString(min) + ":0" + Integer.toString(sec));
            else if (min < 10)
                label.setText("Timer: 0" + Integer.toString(min) + ":" + Integer.toString(sec));
            else
                label.setText("Timer: " + Integer.toString(min) + ":" + Integer.toString(sec));
        }
    };

    public int getSec(){
        return sec;
    }
    public int getMin(){
        return min;
    }

    public TimerImplementation() {
        bool = true;
        timer.scheduleAtFixedRate(task, 1000, 1000);
        this.setHorizontalAlignment(SwingConstants.RIGHT);
//		this.setBounds(500, 400, 75, 75);
    }
    public void resetTimer(){
        sec = 30;
        min = 1;
    }
}

