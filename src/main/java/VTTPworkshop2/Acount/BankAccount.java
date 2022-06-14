package VTTPworkshop2.Acount;

import java.util.*;
//import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BankAccount {
    private String name = "";

    private String acctId= UUID.randomUUID().toString().substring(0,8);

    private LinkedList<String> transaction = new LinkedList<String>();
 
    public int bankAccount;

    public float balance;

    public boolean isClosed;

    public LocalDateTime dateCreated;

    public LocalDateTime dateClosed;

    //Constructors -> Overload to open account
    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    public BankAccount(String name, float balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAcctId() {
        return acctId;
    }
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }
    public int getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    public LocalDateTime getDateClosed() {
        return dateClosed;
    }
    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }
    
    public LinkedList<String> getTransaction() {
        return transaction;
    }

    public void setTranaction(LinkedList<String> transaction) {
        this.transaction = transaction;
    }

    public void withdraw(String withdrawAmt){
        Float withdrawAmtF;
        
        try{
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            if(withdrawAmtF.floatValue()<=0){
                throw new IllegalArgumentException("Withdrawal amount cannot be 0 or negative");
            }
            if(withdrawAmtF.floatValue()>this.balance){
                throw new IllegalArgumentException("Save more money");
            }
            if(this.isClosed){
                throw new IllegalArgumentException("Account closed already");
            }
            StringBuilder currTransaction = new StringBuilder();
            currTransaction.append("Withdraw $");
            currTransaction.append(withdrawAmtF);
            currTransaction.append(" at ");
            currTransaction.append(LocalTime.now());
            transaction.add(currTransaction.toString());


        }catch(NumberFormatException e){
            System.out.println(e);
            throw new IllegalArgumentException("Invalid withdraw amount"); 
        }
        this.balance -= withdrawAmtF.floatValue();
    
    }

    public void deposit(String depositAmt){
        Float depositAmtF;
        
        try{
            depositAmtF = Float.parseFloat(depositAmt);
            if(depositAmtF.floatValue()<=0){
                throw new IllegalArgumentException("Withdrawal amount cannot be 0 or negative");
            }
            if(this.isClosed){
                throw new IllegalArgumentException("Account closed already");
            }
            StringBuilder currTransaction = new StringBuilder();
            currTransaction.append("Deposit $");
            currTransaction.append(depositAmtF);
            currTransaction.append(" at ");
            currTransaction.append(LocalTime.now());
            transaction.add(currTransaction.toString());


        }catch(NumberFormatException e){
            System.out.println(e);
            throw new IllegalArgumentException("Invalid withdraw amount"); 
        }
        this.balance += depositAmtF.floatValue();
    }
}
