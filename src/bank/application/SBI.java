package bank.application;

import java.util.UUID;

public class SBI implements BankInterface{

    private int balance;
    private String password;
    private String accountNo;
    public String name;
    public static double rateOfInterest;

    public SBI(int balance, String password, String name){

        this.accountNo = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }

    @Override
    public int checkBalance(String password){
        if(password == this.password){
            return balance;
        }

        return -1;
    }
    @Override
    public String addMoney(int money){

        balance += money;

        String message = money+" has been added to bank account "+accountNo+" the total is now "+balance;

        return message;
    }
    @Override
    public String withdrawMoney(int drawMoney, String password){

        if(password == this.password){
            if(balance < drawMoney) return "Insufficient balance ";
            else {
                balance -= drawMoney;
                return "money withdrawn successfully.the total balance is"+balance;
            }
        }
        else return "wrong password";

    }
    @Override
    public String changePassword(String oldPassword, String newPassword){
        if(oldPassword == this.password){
            this.password = newPassword;
            return "password reset successful";
        }
        return "wrong password";
    }

    @Override
    public double calculateTotalInterest(int years) {
        double interest = years*rateOfInterest*balance/100;

        return interest;
    }

}
