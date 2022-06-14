package VTTPworkshop2.Acount;

public class FixedDepositAccount extends BankAccount {
    private float interest = (float)3.0;
    private int duration = 6;
    private int interestcounter = 0;
    private int durationcounter = 0;

    public int getInterestcounter() {
        return interestcounter;
    }

    public int getDurationcounter() {
        return durationcounter;
    }

    public FixedDepositAccount(String name, float initialAmount){
        super(name, initialAmount);                                       //super to call the parent class
    }

    public FixedDepositAccount(String name, float initialAmount, float interest){
        super(name, initialAmount);                                       
        this.interest = interest;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest, int duration){
        super(name, initialAmount);                                       
        this.interest = interest;
        this.duration = duration;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        if(interestcounter< 1){
            this.interest = interest;
            interestcounter++;
        }else{
            System.out.println("You have set the interest rate once");
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if(durationcounter< 1){
            this.duration = duration;
            durationcounter++;
        }else{
        System.out.println("You have set the duration once");
        }
    }

    @Override
    public float getBalance(){
        return super.getBalance()*(this.interest+100)/100;
    }
    @Override
    public void withdraw(String amount){
        System.out.println("It is a fixed deposit account, cant withdraw");
    }
    @Override
    public void deposit(String amount){
        System.out.println("It is a fixed deposit account, cant deposit");
    }
}
