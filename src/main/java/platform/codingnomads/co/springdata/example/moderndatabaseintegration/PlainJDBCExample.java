package platform.codingnomads.co.springdata.example.moderndatabaseintegration;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.*;

public class PlainJDBCExample {

    public static void main(String[] args) {
        Connection DBConnection = null;
        Statement statement = null;

        String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            DBConnection = DriverManager.getConnection("URL", "root", "darkLinux1000");

            statement = DBConnection.createStatement();
            String customQuery = "SELECT * FROM Employees";
            ResultSet rs = statement.executeQuery(customQuery);

            while (rs.next()) {
                System.out.println(new Employee(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }

            rs.close();
            statement.close();
            DBConnection.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (AssertionError | SQLException e2) {
                e2.printStackTrace();
            }
            try {
                assert DBConnection != null;
                DBConnection.close();
            } catch (AssertionError | SQLException e3) {
                e3.printStackTrace();
            }
        }
    }
}
@Data
@AllArgsConstructor
class Employee {
    private int Id;
    private String firstName;
    private String lastName;
}


