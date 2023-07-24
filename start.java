package ATM_application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class start {
    Scanner scan = new Scanner(System.in);
    long user_cardno;
    public start(long accno) {

        this.user_cardno=accno;
    }
 //   ArrayList<cardData> ATMcard= new ArrayList<cardData>();
    //data inserting....
//
//        ATMcard.add(new cardData("sanjai",111122233,1974,4000));
//        ATMcard.add(new cardData("kaviya",211122233,2974,5232));
//        ATMcard.add(new cardData("jayapal",311122233,3974,5324));
//        ATMcard.add(new cardData("Ponni",411122233,4974,8343));
//        ATMcard.add(new cardData("suri",511122233,5974,98272));
//        ATMcard.add(new cardData("Ntr",611122233,6974,5352));
//        ATMcard.add(new cardData("hema",711122233,7974,5827));
//        ATMcard.add(new cardData("sam",811122233,8974,5837));
//        ATMcard.add(new cardData("sandy",911122233,9974,87472));

    //start.........
    public void starter() throws SQLException {
        boolean x=true;
        while (x){

        //if(ATMcard.contains(user_cardno) ){

        //int inde =ATMcard.indexOf(user_cardno);

        // System.out.println(ATMcard.get();

            cardData b=new cardData(user_cardno);
                b.diplay_carddata();
                System.out.println("1-Withdraw \n2-Deposit\n3-check\n4-Exit");
                int option = scan.nextInt();

                if(option == 1){
                    System.out.println(b.getAmount());
                    System.out.println("Enter the amount :");
                    int request_amount= scan.nextInt();
                    b.Withdraw_Amount(request_amount);

                }
                else if(option == 2) {
                    System.out.println("Enter the amount :");
                    int deposit_amount=scan.nextInt();
                    deposit_amount+=b.getAmount();
                    b.Deopsit(deposit_amount);
                    System.out.println("updated successfully ->"+b.getAmount());

                }

                else if(option == 3){
                    System.out.println("Checking.......");
                    System.out.println(b.getName() +" -> " +b.getCardno() +" -> "+b.getAmount());

                }
                else if(option==4){
                    break;
                }
                else {
                    System.out.println("Enter correct option ");
                }
            }


}
}

