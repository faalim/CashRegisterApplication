package com.example.cashregisterapplication;

import java.io.Serializable;
import java.util.Date;

public class PurchaseHistory extends StoreItems implements Serializable {
    private Date timePurchased;
    public PurchaseHistory(String name, int quant, double value, Date timePurchased) {
        super(name, quant, value);
        this.timePurchased = timePurchased;
    }
    public PurchaseHistory(){   }
    public Date getTimeOfPurchease() {
        return timePurchased;
    }
}

