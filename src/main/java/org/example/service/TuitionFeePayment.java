package org.example.service;

public class TuitionFeePayment implements TuitionService{
    private final double PRICE_PER_UNIT = 1000.00;
    private double balance;
    private double totalTuition;

    @Override
    public double calculateTuitionFee(int units, double discountRate) {
        double total = units * PRICE_PER_UNIT;
        this.balance = total - (total * discountRate);
        return total - (total * discountRate);
    }
    @Override
    public double processPayment(double currentBalance, double paymentAmount) {
        return currentBalance - paymentAmount;
    }
    @Override
    public void makePayment(double amount) {
        this.balance -= amount;
    }
    public double getRemainingBalance(){
        return balance;
    }
    @Override
    public boolean isFullyPaid() {
        return balance <= 0;
    }
}
