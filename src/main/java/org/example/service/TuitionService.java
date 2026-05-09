package org.example.service;

public interface TuitionService {
    public double calculateTuitionFee(int units, double discountRate);
    public void makePayment(double amount);
    public double getRemainingBalance();
    public boolean isFullyPaid();
}
