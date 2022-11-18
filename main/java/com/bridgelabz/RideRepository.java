package com.bridgelabz;

import java.util.HashMap;

public class RideRepository {

    HashMap<Integer,Ride[]> rideHashMap = new HashMap<>() ;

    public RideRepository() {
    }

    public void addRides(Integer userId, Ride[] ride1) {
        if(rideHashMap.containsKey(userId)){
            System.out.println("Already Exist !!!");
        } else {
            rideHashMap.put(userId,ride1);
        }
    }

    public Invoice getInvoiceFromUserId(Integer userId) {
        Ride[] rides = rideHashMap.get(userId);
        CabInvoice cabInvoice = new CabInvoice();
        return cabInvoice.generateInvoice(rides);
    }
}
