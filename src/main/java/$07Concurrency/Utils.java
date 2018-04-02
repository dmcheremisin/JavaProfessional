package $07Concurrency;

/**
 * Created by Dmitrii on 02.04.2018.
 */
public class Utils {

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
