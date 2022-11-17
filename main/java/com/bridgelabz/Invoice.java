package com.bridgelabz;

import java.util.Objects;

public class Invoice {

    int totalNumberOfRides ;
    double aggregateTotalFare ;
    double averageFare;

    public Invoice(int totalNumberOfRides, double aggregateTotalFare, double averageFare) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.aggregateTotalFare = aggregateTotalFare;
        this.averageFare = averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalNumberOfRides == invoice.totalNumberOfRides && Double.compare(invoice.aggregateTotalFare, aggregateTotalFare) == 0 && Double.compare(invoice.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNumberOfRides, aggregateTotalFare, averageFare);
    }
}
