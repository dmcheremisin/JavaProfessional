package $05DatesStringsLocalization.datesAndTimes;

import java.time.*;

/**
 * Created by Dmitrii on 15.02.2018.
 */
public class Periods {

    public static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period){
        while(start.isBefore(end)){
            System.out.println("Applied again");
            start = start.plus(period);
        }// Applied again \n Applied again \n Applied again
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 11);
        LocalDate end = LocalDate.of(2017, Month.JULY, 30);
        Period period = Period.of(1, 2, 3);
        System.out.println(period); // P1Y2M3D
        performAnimalEnrichment(start, end, period);

        // creation
        Period annually = Period.ofYears(1); // every year
        System.out.println(annually); // P1Y
        Period quarterly = Period.ofMonths(3); // every 3 months
        System.out.println(quarterly); // P3M
        Period weeks = Period.ofWeeks(3); // every 3 weeks
        System.out.println(weeks); // P21D
        Period days = Period.ofDays(3); // every 3 days
        System.out.println(days); // P3D
        Period custom = Period.of(1, 0, 7);  // every year and 7 days
        System.out.println(custom); // P1Y7D

        Period everyMonth = Period.ofYears(1).ofMonths(1); // every MONTH !!!! Not every year and month
        System.out.println(everyMonth); // P1M

        // usage
        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dt = LocalDateTime.of(date, time);
        System.out.println(date.plus(everyMonth)); // 2015-02-20
        System.out.println(dt.plus(everyMonth)); // 2015-02-20T06:15
        // System.out.println(time.plus(everyMonth));  UnsupportedTemporalTypeException: Unsupported unit: Months
        System.out.println(dt.minus(everyMonth)); // 2014-12-20T06:15

    }
}
