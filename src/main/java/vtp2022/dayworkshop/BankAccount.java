package vtp2022.dayworkshop;

//package to generate uuid
import java.util.UUID;
import java.util.*;
import java.time.LocalDateTime;

public class BankAccount {
    //bank account 
    private String name ="";

    // this is a geerated account ID 
    private String acctId = UUID.randomUUID().toString().substring(0,8);
    //holds the bank acc balance 
    private float balance = 0f;
    //list of transaction history in the event of anything done on the bankaccount object 
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;

    private LocalDateTime accountCreationDate;
    
    private LocalDateTime accountClosingDate; 

    //2nd constructor with bank account name and the initial balance 
    public BankAccount(String name){
        this.name = name;
    }
    
    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
        
    }


 /************************************************************************************************************************* */   
    // Getter and setter for the rest of the properties 
    public String getName() {
        return name;
    }

    public String getAcctId() {
        return acctId;
    }

    public float getBalance() {
        return balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    protected float withdraw(String withdrawAmt){
        Float  withdrawAmtF= null;
        try{
            withdrawAmtF = Float.parseFloat(withdrawAmt);             //Exception will be throw if alphaphet is throw in
            if(withdrawAmtF.floatValue()<=0){
                throw new IllegalArgumentException("Withdrawal Amount cannot be negative or kosong");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed lah");

            }

            this.balance = this.balance - withdrawAmtF.floatValue(); // transact first then show in balance 
            //Construct the transaction history event log 
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            // save the event log into the txn linkedlist 
            transaction.add(txnStrbld.toString());
            // update the deposit amount 

        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        return withdrawAmtF.floatValue();
    }

    protected void deposit(String depositAmt){
        try{
            Float depositAmtF = Float.parseFloat(depositAmt);             //Exception will be throw if alphaphet is throw in
            if(depositAmtF.floatValue()<=0){
                throw new IllegalArgumentException("Amount cannot be negative or kosong");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed lah");

            }

            this.balance = this.balance + depositAmtF.floatValue(); // transact first then show in balance 
            //Construct the transaction history event log 
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            // save the event log into the txn linkedlist 
            transaction.add(txnStrbld.toString());
            // update the deposit amount 


        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
         
    }

}
