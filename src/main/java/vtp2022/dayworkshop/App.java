package vtp2022.dayworkshop;

import vtp2022.dayworkshop.account.BankAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.out.println("My ATM Machine - POSSBank");
        BankAccount bkAcc = new BankAccount ("Xinhai Bank Accouunt");
        //bkAcc.deposit("99999999999999999999999999999999999999999999999");
        //System.out.println("My new account balance >" + bkAcc.getBalance());

        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("2000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        

    }
}
