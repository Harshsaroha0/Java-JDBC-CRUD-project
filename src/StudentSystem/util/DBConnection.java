package StudentSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://127.0.0.1:3306/studentrecords";
        String user = "root";
        String pass = "harsh123";

        return DriverManager.getConnection(url, user, pass);
    }
}