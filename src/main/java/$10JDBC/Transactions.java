package $10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import static $10JDBC.DbUtils.createSampleData;

/**
 * Created by Dmitrii on 13.06.2018.
 */
public class Transactions {
    public static void main(String[] args) throws SQLException {
        String url = DbUtils.getPropertie("connection.url");
        Connection conn = DriverManager.getConnection(url);
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            createSampleData();

            conn.setAutoCommit(false);

            ResultSet rs = printTable(stmt);
            //====> Table content:
            //1	African Elephant	7.5
            //2	Zebra	1.2

            rs.moveToInsertRow();
            rs.updateInt("id", 3);
            rs.updateString("name", "Tiger");
            rs.updateDouble("num_acres", 10.5);
            rs.insertRow();
            Savepoint tiger = conn.setSavepoint();

            rs.moveToInsertRow();
            rs.updateInt("id", 4);
            rs.updateString("name", "Rabbit");
            rs.updateDouble("num_acres", 3.5);
            rs.insertRow();
            Savepoint rabbit = conn.setSavepoint("Rabbit");

            rs.moveToInsertRow();
            rs.updateInt("id", 5);
            rs.updateString("name", "Lion");
            rs.updateDouble("num_acres", 10.5);
            rs.insertRow();
            Savepoint lion = conn.setSavepoint("Lion");

            //conn.rollback(); will rollback to the initial state
            //conn.rollback(tiger); // only tiger will be added
            conn.rollback(rabbit); // tiger + rabbit are added
            //conn.rollback(lion); all animals are added

            printTable(stmt);
            //====> Table content:
            //1	African Elephant	7.5
            //2	Zebra	1.2
            //3	Tiger	10.5
            //4	Rabbit	3.5

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
    }

    private static ResultSet printTable(Statement stmt) throws SQLException {
        System.out.println("====> Table content: ");
        ResultSet rs = stmt.executeQuery("SELECT id, name, num_acres FROM species");
        while(rs.next()){
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
        }
        return rs;
    }
}
