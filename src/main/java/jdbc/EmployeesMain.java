package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource mDbDataSource;
        try {
            mDbDataSource = new MariaDbDataSource();
            mDbDataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            mDbDataSource.setUser("employees");
            mDbDataSource.setPassword("employees");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot create data source", se);
        }

        try (Connection cnx = mDbDataSource.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement("insert into employees(emp_name) values (?)")) {
            pstmt.setString(1, "Jill Doe");
            pstmt.execute();
        }
        catch (SQLException se2) {
            throw new IllegalStateException("Cannot connect data source", se2);
        }
    }
}
