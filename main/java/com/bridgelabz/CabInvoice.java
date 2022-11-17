package com.bridgelabz;

public class CabInvoice {

    static final double COST_PER_KM = 10.0 ;
    static final double COST_PER_MIN = 1.0 ;

    static final double MINIMUM_FARE = 5.0 ;

    static final double COST_PER_KM_FOR_PREMIUM = 15.0;

    static final double COST_PER_MIN_FOR_PREMIUM = 2.0 ;

    static final double MINIMUM_FARE_FOR_PREMIUM = 20.0 ;


    public CabInvoice() {
    }


    public double calculateTotalFare(double distance, double time) {
        double totalFare = distance*COST_PER_KM + time*COST_PER_MIN;
        return totalFare<MINIMUM_FARE ? MINIMUM_FARE : totalFare;
    }

    public double calculatePremiumFare(double distance, double time) {
        double totalFare = distance*COST_PER_KM_FOR_PREMIUM + time*COST_PER_MIN_FOR_PREMIUM;
        return totalFare<MINIMUM_FARE_FOR_PREMIUM ? MINIMUM_FARE_FOR_PREMIUM : totalFare;
    }

    public double calculateTotalFare(Ride[] rides) {
        double aggregateTotalFare = 0.0;
        for (Ride ride:rides) {
            if(ride.type.equals("Normal")) {
                double totalFare = calculateTotalFare(ride.distance, ride.time);
                aggregateTotalFare += totalFare;
            }
        }
        return aggregateTotalFare;
    }

    public double calculatePremiumFare(Ride[] rides){
        double aggregateTotalFare = 0.0;
        for (Ride ride:rides) {
            if(ride.type.equals("Premium")) {
                double totalFare = calculatePremiumFare(ride.distance, ride.time);
                aggregateTotalFare += totalFare;
            }
        }
        return aggregateTotalFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        double aggregateFare = 0.0;
        for (Ride ride : rides) {
            if (ride.type.equals("Premium")) {
                aggregateFare += calculatePremiumFare(rides);

            } else {
                aggregateFare += calculateTotalFare(rides);
            }
        }
        int totalRides = rides.length;
        double averageFare = aggregateFare / totalRides;
        return new Invoice(totalRides, aggregateFare, averageFare);
    }
}
