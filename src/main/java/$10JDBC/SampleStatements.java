package $10JDBC;

import java.sql.*;

import static $10JDBC.DbUtils.createSampleData;

/**
 * Created by Dmitrii on 26.03.2018.
 */
public class SampleStatements {
    public static void main(String[] args) {
        String url = DbUtils.getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();) {
            createSampleData();
            // insert
            int result = stmt.executeUpdate("INSERT INTO species VALUES (10, 'Deer', 3)");
            System.out.println("Insert: " + result); // 1

            // update
            result = stmt.executeUpdate("UPDATE species set name ='' WHERE name = 'None'");
            System.out.println("Update: " + result); // 0

            // delete
            result = stmt.executeUpdate("DELETE FROM species WHERE id = 10");
            System.out.println("Delete: " + result); // 1

            ResultSet rs = stmt.executeQuery("select name from animal");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            //Elsa
            //Zelda
            //Ester
            //Eddie
            //Zoe
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
