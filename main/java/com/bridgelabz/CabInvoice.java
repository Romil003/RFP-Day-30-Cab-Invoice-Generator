package com.bridgelabz;

public class CabInvoice {

    enum FareForRides {
     COST_PER_KM(10.0,"Normal"),
     COST_PER_MIN(1.0,"Normal"),
     MINIMUM_FARE(5.0,"Normal"),
     COST_PER_KM_FOR_PREMIUM(15.0,"Premium"),
     COST_PER_MIN_FOR_PREMIUM(2.0,"Premium"),
     MINIMUM_FARE_FOR_PREMIUM(20.0,"Premium");
     double value;
     String typeOfRide;
        FareForRides(double value) {
            this.value = value;
        }

        FareForRides(double value, String typeOfRide) {
            this.value = value;
            this.typeOfRide = typeOfRide;
        }
    }


    public CabInvoice() {
    }


    public double calculateTotalFare(double distance, double time) {
        double totalFare = distance*FareForRides.COST_PER_KM.value + time*FareForRides.COST_PER_MIN.value;
        return totalFare<FareForRides.MINIMUM_FARE.value ? FareForRides.MINIMUM_FARE.value  : totalFare;
    }

    public double calculatePremiumFare(double distance, double time) {
        double totalFare = distance*FareForRides.COST_PER_KM_FOR_PREMIUM.value + time*FareForRides.COST_PER_MIN_FOR_PREMIUM.value;
        return totalFare<FareForRides.MINIMUM_FARE_FOR_PREMIUM.value  ? FareForRides.MINIMUM_FARE_FOR_PREMIUM.value : totalFare;
    }

    public double calculateTotalFare(Ride[] rides) {
        double aggregateTotalFare = 0.0;
        for (Ride ride:rides) {
            if(ride.type.equals(FareForRides.COST_PER_KM.typeOfRide)) {
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
            if (ride.type.equals(FareForRides.COST_PER_KM_FOR_PREMIUM.typeOfRide)) {
                aggregateFare += calculatePremiumFare(ride.distance,ride.time);
            } else {
                aggregateFare += calculateTotalFare(ride.distance,ride.time);
            }
        }
        int totalRides = rides.length;
        double averageFare = aggregateFare / totalRides;
        return new Invoice(totalRides, aggregateFare, averageFare);
    }
}
