package $10JDBC;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Dmitrii on 26.03.2018.
 */
public class DbUtils {
    public static void main(String[] args) {
        createSampleData();
    }
    public static void createSampleData(){
        String url = getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();) {
            stmt.executeUpdate("CREATE TABLE species (" +
                    "id INTEGER PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "num_acres DECIMAL)");
            stmt.executeUpdate("CREATE TABLE animal (" +
                    "id INTEGER PRIMARY KEY ," +
                    "species_id INTEGER," +
                    "name VARCHAR(255)," +
                    "date_born TIMESTAMP)");
            stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
            stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");

            stmt.executeUpdate("INSERT INTO animal VALUES(1,1, 'Elsa',  '2001-05-06 02:15:20')");
            stmt.executeUpdate("INSERT INTO animal VALUES(2,2, 'Zelda', '2002-06-06 13:15:10')");
            stmt.executeUpdate("INSERT INTO animal VALUES(3,1, 'Ester', '2003-07-06 21:15:30')");
            stmt.executeUpdate("INSERT INTO animal VALUES(4,1, 'Eddie', '2004-08-06 10:15:40')");
            stmt.executeUpdate("INSERT INTO animal VALUES(5,2, 'Zoe',   '2005-09-06 01:15:50')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertie(String propertie){
        InputStream resourceAsStream = DbUtils.class.getClassLoader().getResourceAsStream("resources.properties");
        Properties props = new Properties();
        try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return props.getProperty(propertie);
    }
}
