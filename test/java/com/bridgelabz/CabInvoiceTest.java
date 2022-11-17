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
}
