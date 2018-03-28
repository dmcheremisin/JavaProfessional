package $10JDBC;

import java.sql.*;

import static $10JDBC.DbUtils.createSampleData;

/**
 * Created by Dmitrii on 26.03.2018.
 */
public class SampleConnection {
    public static void main(String[] args) {
        String url = DbUtils.getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();) {
            createSampleData();
            ResultSet rs = stmt.executeQuery("select id, name from animal");
            while (rs.next()) {
                System.out.println("id = " + rs.getString(1) + "; name = " + rs.getString(2) );
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        // id = 1; name = Elsa
        //id = 2; name = Zelda
        //id = 3; name = Ester
        //id = 4; name = Eddie
        //id = 5; name = Zoe
    }
}
