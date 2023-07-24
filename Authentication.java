package ATM_application;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentication {
    private Connection con;

    //it will get connection from the Data base (con)


    //Authentication for Admin
    public boolean checkAdmin(String id,int pass) throws SQLException {
        Connection con = DBconnection.getconnectionn();
        String query="Select pass from admin where id="+"\""+id+"\"";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        int xx=rs.getInt(1);
        con.close();
        if(xx==pass){
            System.out.println("tureeeee");
            return true;
        }
        else{
            System.out.println("wrong password Admin");
        }
        return false;
    }


    //Authentication for user
    public boolean checkuser(long id,int pin) throws SQLException {
        Connection con = DBconnection.getconnectionn();
        String query="Select Pin from account where Accno="+id+";";
        Statement st= con.createStatement();
        ResultSet x = st.executeQuery(query);
        x.next();
        int xx=x.getInt(1);
        con.close();
        if(pin==xx){

            return true;
        }
        else {
            System.out.println("wrong password user");
        }

        return false;
    }

}
