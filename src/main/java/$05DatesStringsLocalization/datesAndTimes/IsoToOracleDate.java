package $05DatesStringsLocalization.datesAndTimes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class IsoToOracleDate {

    static Map<String, String> timezones = new HashMap<String, String>(){{
       put("NLD","Europe/Amsterdam");
       put("RUS","Europe/Moscow");
       put("USA","America/New_York");
    }};

    public static void main(String[] args) {
        String zone = timezones.get("NLD");
        ZoneId zoneId = ZoneId.of(zone);
        long epochMilli = 1525370235 * 1000L;
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(epochMilli).atZone(zoneId);
        System.out.println(zonedDateTime); // 2018-05-03T19:57:15+02:00[Europe/Amsterdam]

        LocalDateTime dt = zonedDateTime.toLocalDateTime();
        System.out.println(dt); // 2018-05-03T19:57:15

        ZonedDateTime zdt = ZonedDateTime.of(dt, zoneId);
        System.out.println(zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)); // 2018-05-03T19:57:15+02:00
    }

}
