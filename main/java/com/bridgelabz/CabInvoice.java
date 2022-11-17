package com.bridgelabz;

public class CabInvoice {
    static final double COST_PER_KM = 10.0;
    static final double COST_PER_MIN = 1.0;

    public CabInvoice() {
    }


    public double calculateTotalFare(double distance, double time) {
        double totalFare = distance*COST_PER_KM + time*COST_PER_MIN;
        return totalFare;
    }
}
