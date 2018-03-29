package $10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static $10JDBC.DbUtils.createSampleData;

/**
 * Created by Dmitrii on 29.03.2018.
 */
public class ScrollingWithRelative {
    public static void main(String[] args) {
        String url = DbUtils.getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            createSampleData();
            ResultSet rs = stmt.executeQuery("SELECT id FROM animal ORDER BY id");
            System.out.println(rs.next());          // true
            System.out.println(rs.getString("id")); // 1
            System.out.println(rs.relative(2));     // true
            System.out.println(rs.getString("id")); // 3
            System.out.println(rs.relative(-1));    // true
            System.out.println(rs.getString("id")); // 2
            System.out.println(rs.relative(4));     // false

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
