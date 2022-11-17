package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabInvoiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateTotalFare(10.0,4.0);
        Assertions.assertEquals(104.0,totalFare);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateTotalFare(0.1,1.0);
        Assertions.assertEquals(5.0,totalFare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnAggregateTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(10.0,4.0),new Ride(5.0,5.0),new Ride(0.1,1.0)};
        double aggregateTotalFare = cabInvoice.calculateTotalFare(rides);
        Assertions.assertEquals(164.0,aggregateTotalFare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoice(){
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(10.0,4.0),new Ride(12.0,5.0),new Ride(0.1,1.0)};
        Invoice expectedInvoice = new Invoice(3,234.0,78.0);
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
}
