import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    protected Connection connection;
    protected PreparedStatement ps;
    protected ResultSet rs;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/departmentdb?useSSL=false&serverTimezone=UTC";

        try {
            connection = DriverManager.getConnection(url, "root", "1288");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void closeAll() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
