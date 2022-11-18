package com.bridgelabz;

public class CabInvoice {

    enum FareForRides {
     COST_PER_KM(10.0),
     COST_PER_MIN(1.0),
     MINIMUM_FARE(5.0),
     COST_PER_KM_FOR_PREMIUM(15.0),
     COST_PER_MIN_FOR_PREMIUM(2.0),
     MINIMUM_FARE_FOR_PREMIUM(20.0);
     double fare;
        FareForRides(double fare) {
            this.fare = fare;
        }
    }


    public CabInvoice() {
    }


    public double calculateTotalFare(double distance, double time) {
        double totalFare = distance*FareForRides.COST_PER_KM.fare + time*FareForRides.COST_PER_MIN.fare;
        return totalFare<FareForRides.MINIMUM_FARE.fare ? FareForRides.MINIMUM_FARE.fare  : totalFare;
    }

    public double calculatePremiumFare(double distance, double time) {
        double totalFare = distance*FareForRides.COST_PER_KM_FOR_PREMIUM.fare + time*FareForRides.COST_PER_MIN_FOR_PREMIUM.fare;
        return totalFare<FareForRides.MINIMUM_FARE_FOR_PREMIUM.fare  ? FareForRides.MINIMUM_FARE_FOR_PREMIUM.fare : totalFare;
    }

    public double calculateTotalFare(Ride[] rides) {
        double aggregateTotalFare = 0.0;
        for (Ride ride:rides) {
            if(ride.type.equals("Normal")) {
                double totalFare = calculateTotalFare(ride.distance, ride.time);
                aggregateTotalFare += totalFare;
            }
            else {
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
                aggregateFare += calculateTotalFare(rides);
            }
        }
        int totalRides = rides.length;
        double averageFare = aggregateFare / totalRides;
        return new Invoice(totalRides, aggregateFare, averageFare);
    }
}
