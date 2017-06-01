package logic.serverCalculation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mark.W on 2017/6/1.
 */
public class ServerCalculation {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/quantgee_data";
    private static String USERNAME = "root";
    private static String PASSWORD = "wycg55967568w";

    private static Connection conn;

    private static Connection getConn() {
       if (conn != null) {
           return conn;
       }

        try {
            Class.forName(DRIVER);      //classLoader,加载对应驱动
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }





}
