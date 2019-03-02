package $05DatesStringsLocalization.datesAndTimes;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by Dmitrii on 01.07.2018.
 */
public class ComparingTime {
    public static void main(String[] args) {
        LocalTime now = LocalTime.of(9, 30);
        LocalTime gameStart = LocalTime.of(10, 15);
        long timeConsumed = 0;
        long timeToStart = 0;
        if(now.isAfter(gameStart)){ // false
            System.out.println("After");
            timeConsumed = gameStart.until(now, ChronoUnit.HOURS);
        }else{
            System.out.println("Before");
            timeToStart = now.until(gameStart, ChronoUnit.HOURS);
        }
        System.out.println(timeToStart + " " + timeConsumed);
        //Before
        //0 0
    }
}
