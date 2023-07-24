package ATM_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static String url="jdbc:mysql://localhost:3306/maib";
    private static String userid  ="root";
    private static String password="";

    public static Connection getconnectionn() throws SQLException {
        System.out.println("***********************");
        return DriverManager.getConnection(url,userid,password);
    }

}
