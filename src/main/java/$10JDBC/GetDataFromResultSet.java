package $10JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static $10JDBC.DbUtils.createSampleData;

/**
 * Created by Dmitrii on 26.03.2018.
 */
public class GetDataFromResultSet {
    public static void main(String[] args) {
        String url = DbUtils.getPropertie("connection.url");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();) {
            createSampleData();
            Map<Integer, String> map1 = new HashMap<>();
            ResultSet rs = stmt.executeQuery("select id, name from animal");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                map1.put(id, name);
            }
            System.out.println(map1); // {1=Elsa, 2=Zelda, 3=Ester, 4=Eddie, 5=Zoe}

            Map<Integer, String> map2 = new HashMap<>();
            rs = stmt.executeQuery("select id, name from animal");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                map2.put(id, name);
            }
            System.out.println(map2); // {1=Elsa, 2=Zelda, 3=Ester, 4=Eddie, 5=Zoe}

            rs = stmt.executeQuery("select count(*) from animal");
            if(rs.next()){
                System.out.println(rs.getInt(1)); // 5
            }

            rs = stmt.executeQuery("select count(*) as count from animal");
            if(rs.next()){
                System.out.println(rs.getInt("count")); // 5
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
