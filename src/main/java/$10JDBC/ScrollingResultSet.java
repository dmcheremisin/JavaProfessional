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
public class ScrollingResultSet {
    public static void main(String[] args) {
        String url = DbUtils.getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            createSampleData();
            ResultSet rs = stmt.executeQuery("SELECT id FROM species ORDER BY id");
            rs.afterLast();
            System.out.println(rs.previous()); // true
            System.out.println(rs.getInt(1)); // 2
            System.out.println(rs.previous()); // true
            System.out.println(rs.getInt(1)); // 1
            System.out.println(rs.last()); // true
            System.out.println(rs.getInt(1)); // 2
            System.out.println(rs.first()); // true
            System.out.println(rs.getInt(1)); // 1
            rs.beforeFirst();
            System.out.println(rs.getInt(1));// throws SQLException no current row
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
