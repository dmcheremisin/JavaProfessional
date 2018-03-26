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
            ResultSet rs = stmt.executeQuery("select name from animal");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
