package com.stackroute.exception;

public class Account {

    private double balance;
    public Account(int amount){
        this.balance = amount;
    }
    public Account(){

    }
    public double getAccountBalance() {
        
        return balance;
    }

    public double withdraw(int i) throws InsufficientFundException, NegativeIntegerException{

        double result = balance - i;
        
        if (balance == 0){
            return result;
        } else if (i < 0) {
            throw new NegativeIntegerException("");
        } else if (i > balance) {
            throw new InsufficientFundException("");
        }

        return result;
    }
}
