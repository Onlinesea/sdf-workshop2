package VTTPworkshop2;

import VTTPworkshop2.Acount.BankAccount;
import VTTPworkshop2.Acount.FixedDepositAccount;
//import java.io.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BankAccount xhBank = new BankAccount("xinhai", 5000);
        xhBank.deposit("1000");
        xhBank.deposit("1000");
        xhBank.withdraw("200");
        System.out.println(xhBank.getBalance());
        //System.out.println(xhBank.getTransaction());
        FixedDepositAccount xinhai = new FixedDepositAccount("xinhai", 5000);
        System.out.println(xinhai.getBalance());
        System.out.println(xhBank.getTransaction());
        //xhBank.setName("Onlinesea");
        System.out.println(xhBank.getName());


    }
}
