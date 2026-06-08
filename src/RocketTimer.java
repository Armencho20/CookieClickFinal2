import java.util.Timer;
import java.util.TimerTask;

public class RocketTimer {
    Timer liftoff;
    TimerTask liftofftask;

    public RocketTimer() {
        liftoff = new Timer();
        liftofftask = new TimerTask() {
            int countdown = 10;
            @Override
            public void run() {
                if (countdown > 1) {
                    System.out.println(countdown--);
                } else if (countdown == 1) {
                    System.out.println("we have ignition");
                    countdown--;

                } else {
                    System.out.println("lift off");
                    String rocket = " /\\\n/  \\\n|  |\n\\_/";
                    System.out.println(rocket);
                    liftoff.cancel();
                }
            }
        };
        liftoff.schedule(liftofftask, 0, 1000);
    }
}
