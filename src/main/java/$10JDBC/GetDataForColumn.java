package $10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static $10JDBC.DbUtils.createSampleData;

/**
 * Created by Dmitrii on 26.03.2018.
 */
public class GetDataForColumn {
    public static void main(String[] args) {
        String url = DbUtils.getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();) {
            createSampleData();
            ResultSet rs = stmt.executeQuery("select id, name, date_born FROM animal WHERE name='Elsa'");
            if(rs.next()){
                int id = rs.getInt(1);
                long idLong = rs.getLong(1);
                String name = rs.getString(2);
                java.sql.Date date = rs.getDate(3);
                java.sql.Time time = rs.getTime(3);
                java.sql.Timestamp timestamp = rs.getTimestamp(3);
                System.out.println("id int  = " + id); // 1
                System.out.println("id long  = " + idLong); // 1
                System.out.println("name String  = " + name); // Elsa
                System.out.println("date Date  = " + date); // 2001-05-06
                System.out.println("date Time  = " + time); // 02:15:20
                System.out.println("date Timestamp  = " + timestamp); // 2001-05-06 02:15:20.0

                LocalDate localDate = date.toLocalDate();
                System.out.println(localDate); // 2001-05-06

                LocalTime localTime = time.toLocalTime();
                System.out.println(localTime); // 02:15:20

                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                System.out.println(localDateTime); // 2001-05-06T02:15:20

                Object object = rs.getObject(3);
                if (object instanceof java.sql.Time){
                    System.out.println("time");
                } else if(object instanceof java.sql.Date){
                    System.out.println("date");
                } else if(object instanceof java.sql.Timestamp) {
                    System.out.println("timestamp");
                }
                // timestamp
                Timestamp tsp = (Timestamp) object;
                System.out.println(tsp); // 2001-05-06 02:15:20.0
            }


        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
