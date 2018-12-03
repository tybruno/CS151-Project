import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Scores extends JLabel {

    JLabel label = this;

    int sec = 0;
    int won = 0;
    int totalGames = 0;
    boolean winner = false;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run()
        {
            winner = false;
            if(sec < 90)
                sec++;
            else
            {
                sec = 0;
                won++;
                totalGames++;

                label.setText("Score: " + Integer.toString(won) + " out of " + Integer.toString(totalGames));
                //label.setText("Total Games Played: " + Integer.toString(totalGames));
                winner = true;
            }


        }
    };

    public Scores()
    {
        label.setText("Score: " + won + " out of " + totalGames);
        timer.scheduleAtFixedRate(task, 1000, 1000);
        this.setBounds(485, 370, 150, 150);
    }

    public void reset()
    {

    }

    public boolean getWinner()
    {
        return winner;
    }

    public void gameOver()
    {
        totalGames++;
        label.setText("Score: " + won);
        label.setText("Total Games played: " + totalGames);
    }
}
