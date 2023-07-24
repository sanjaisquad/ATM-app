package ATM_application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String [] args) {
        Scanner scan=new Scanner(System.in);
        //withdraw
        //deopsit
        //check balance
        //exit
        Authentication A = null;
        A = new Authentication();
        //requirements.........
        while (true) {
            long user_cardno;
            int user_pin;
            System.out.println("WELOME TO MARI AMMAN INDIAN BANK (MAIB)");

            System.out.println("1-User\n2-Admin");
            int a = scan.nextInt();
            //admin part............
            if (a == 2) {


                Admin x = new Admin();
                try {
                    x.adminn();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            //User part
            else if (a == 1) {
                System.out.println("Enter your card no: ");
                user_cardno = scan.nextLong();
                System.out.println("Enter your PIN: ");
                user_pin = scan.nextInt();


                try {
                    if (A.checkuser(user_cardno, user_pin)) {
                        start s = new start(user_cardno);
                        s.starter();
                    } else {
                        System.out.println("exit....");
                    }
                } catch (SQLException e) {
                    System.out.println("wrong user id");
                    System.out.println(e);
                }

            }
        }
    }
    }