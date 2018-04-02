package $07Concurrency;

/**
 * @author dmch0916
 * Date: 02.04.2018
 * Time: 19:45
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
