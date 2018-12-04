import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Timer;
import java.util.TimerTask;

public class TimerImplementation extends JLabel {

    JLabel label = this;

    public boolean bool = false;

    static int sec = 30;
    static int min = 1;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            int sec = TimerImplementation.sec;
            int min = TimerImplementation.min; 
            
            if (sec > 0) {
                sec--;
            } else if(min==1) {
                min--;
                sec = 59;
            } else {
                min=0;
                sec=0;
            }
            
            TimerImplementation.sec = sec;
            TimerImplementation.min = min;
            
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
        TimerImplementation.sec = 30;
        TimerImplementation.min = 1;
    }
    
    public boolean isTimeOut(){
        if(TimerImplementation.min <= 0 && TimerImplementation.sec <= 0){
            return true;
        }else{
            return false;
        }
    }
}

