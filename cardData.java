package ATM_application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cardData {
    private String Name ;

    private long Cardno;

    private int PIN;

    private float amount;


    //constructor..........
    cardData(long cardno) throws SQLException {

        this.Cardno=cardno;

        connector();

    }
    //get name
    public String getName(){

        return Name;
    }

    //get cardno
    public long getCardno(){
        return Cardno;
    }

    //get pin
    public int getPIN(){
        return PIN;
    }

    public float getAmount(){return amount;}

    public void diplay_carddata(){

        System.out.println("WELCOME "+Name+" ===> ("+Cardno+")");
    }

    //withdraw...................................
    public void Withdraw_Amount(int request) throws SQLException {
        if(request<=this.amount){
            amount = amount - request;
            System.out.println( "Please collect your amount -> "+request);
            //calling the deposit fun for reassign the remaining amount into account
            Deopsit( amount);

        }
        else {
        System.out.println("Enter the valid amount ");}

    }

    //deposit...........................................
    public void Deopsit(float amount) throws SQLException {
        String query = "update account set amount="+amount+"where Accno="+Cardno;
        Connection con=DBconnection.getconnectionn();
        Statement st=con.createStatement();
        st.executeUpdate(query);
        con.close();
        connector();
        System.out.println(amount);
    }

    //connect to the data base.........................
    public void connector() throws SQLException {
        String query ="Select * from account";
        Connection con=DBconnection.getconnectionn();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        this.Name=rs.getString(1);
        this.amount=rs.getFloat(4);
        con.close();
    }

}
