package VTTPworkshop2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VTTPworkshop2.Acount.BankAccount;
import VTTPworkshop2.Acount.FixedDepositAccount;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount(){
        BankAccount bkAcc = new BankAccount("Xinhai");
        bkAcc.deposit("1000");
        bkAcc.withdraw("500");
        float finalBalance = bkAcc.getBalance();
        assertEquals(499.6, finalBalance, 4);
    }

    @Test
    public void testFixedDepositAccount(){
        try{
            FixedDepositAccount fdAcc = new FixedDepositAccount("My FD acc", 1000);
            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setInterest(4);
            fdAcc.setDuration(12);
            System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setInterest(5);
            fdAcc.setDuration(6);
        }catch (IllegalArgumentException e){
            assertTrue("Only can set duration and interest once ".contains(e.getMessage()));
        }
    }

    @Test
    public void testFixedDepositAccountchangeInterestAndDurationOnce(){
        FixedDepositAccount fdAcc = 
            new FixedDepositAccount("My FD acc", 10000);

        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setInterest(4);
        fdAcc.setDuration(12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        assertEquals(11, fdAcc.getDuration(), 2);
    }

}
