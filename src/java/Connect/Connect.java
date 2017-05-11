package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection getConnect() {
        Connection con = null;
        try {
            String Username = "sa";
            String password = "DEADLINE";
            String DBName = "DichVu";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, Username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
