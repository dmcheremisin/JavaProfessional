package $05DatesStringsLocalization.datesAndTimes;

import java.time.ZoneId;

/**
 * Created by Dmitrii on 15.02.2018.
 */
public class FindingTimeZone {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.toUpperCase().contains("EUROPE"))
                .forEach(System.out::println);
        // Europe/London
        //Europe/Brussels
        //Europe/Warsaw
        //Europe/Jersey
        //Europe/Istanbul
        //Europe/Luxembourg
        //Europe/Zaporozhye
        //Europe/Guernsey
        //Europe/Isle_of_Man
        //Europe/Kaliningrad
    }
}
