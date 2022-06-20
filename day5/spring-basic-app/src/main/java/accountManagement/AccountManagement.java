package accountManagement;
import java.util.*;
public class AccountManagement {
    int deposite=0;
    int balance=0;
    public void insertData(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome To Bank");
        System.out.println("To Create Account");
        System.out.println("Enter The Adhar Card Number");
        int AdharNumber=sc.nextInt();
        System.out.println("Enter The Mobile Number");
        long moNum=sc.nextLong();
        System.out.println("Welcome,Your Account is Created");
        System.out.println("Your Balance is 0");
    }
    public void display(){
        System.out.println("Your Account Number is:123456789");
    }
    public void depositeAmmount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter deposite Amount");
        int deposite=sc.nextInt();
        balance=balance+deposite;
        System.out.println("Your Balance is: "+balance);
    }
    public void withdrawAmount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter withdraw Amount");
        int withDraw=sc.nextInt();
        if(withDraw>balance)
            System.out.println("Insufficent Balance");
            else{
                balance=balance-withDraw;
            System.out.println("Your Balance is: "+balance);

        }
    }

}
