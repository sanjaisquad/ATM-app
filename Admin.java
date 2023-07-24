package ATM_application;

import java.sql.*;
import java.util.Scanner;

public class Admin {
    String id;
    int    pass;

    Scanner scan=new Scanner(System.in);

    public void adminn() throws SQLException {
        // creating a object A for Authentication
        Authentication A = new Authentication();
        System.out.println("******Admin********\nAdmin id :");
        id=scan.nextLine();
        System.out.println("Password :");
        pass=scan.nextInt();
        boolean x=A.checkAdmin(id,pass);
        if(x){
            boolean b=true;
            while (b) {
                System.out.println("1-Add Account\n2-Delete Account\n3-Exit");
                int a = scan.nextInt();
                if (a == 1) {
                    Add_account();
                }
                else if (a==2) {
                    Delete_acc();
                }
                else if (a==3) {
                    break;
                } else {
                    System.out.println("Enter correctly!!!");
                }
            }
        }
        else {
            System.out.println("Wrong password");
        }
    }

    private void Add_account() throws SQLException {
        System.out.println("Enter name  :");
        String name=scan.next();
        System.out.println("Enter Accno :");
        long accno=scan.nextLong();
        System.out.println("Enter pin   :");
        int pin=scan.nextInt();
        float amount=100;

        String query="insert into account value(?,?,?,?);";

        Connection con=DBconnection.getconnectionn();
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,name);
        ps.setLong(2,accno);
        ps.setInt(3,pin);
        ps.setFloat(4,amount);
        ps.executeUpdate();
        System.out.println("\nsuccessfully added\n");
        con.close();

    }

    private void Delete_acc() throws SQLException {
        System.out.println("Enter account no :");
        long accno = scan.nextLong();

        String query="Delete from account where Accno="+accno;
        Connection con=DBconnection.getconnectionn();
        Statement st=con.createStatement();
        st.executeUpdate(query);
        System.out.println("\nsuccessfully Deleted\n  ");
        con.close();
    }

}
