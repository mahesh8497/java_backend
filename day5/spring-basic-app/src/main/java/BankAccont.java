import accountManagement.AccountManagement;

import java.util.*;
public class BankAccont {
    public static void main(String[] args) {
        AccountManagement accMang=new AccountManagement();
        Scanner sc=new Scanner(System.in);
        accMang.insertData();
        accMang.display();
        accMang.depositeAmmount();
        accMang.withdrawAmount();
        while (true){
            System.out.println("Enter The Number: 1- Deposite 2-Withdraw");
            int num=sc.nextInt();
            if(num>2){
                System.out.println("Thank You");
                break;
            }
            if(num==1){
                accMang.depositeAmmount();
            }
            if (num==2){
                accMang.withdrawAmount();
            }
        }
    }
}
