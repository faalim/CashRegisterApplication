package com.example.cashregisterapplication;

import java.io.Serializable;

public class StoreItems implements Serializable {
    private String name;
    private int quant;
    private double value;//

    public StoreItems() {

    }

    public StoreItems(String name, int quant, double value) {
        this.name = name;
        this.quant = quant;
        this.value = value;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setQnt(int quant) {
        this.quant = quant;
    }

    public void setValue(double value) {
        this.value = value;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getQnt() {
        return quant;
    }

    public double getValue() {
        return value;
    }

    public double totalPurchased(int Amount) {
        return Amount * this.value;
    }

    public boolean purchasedAmount(int Amount){
        if(this.quant >= Amount){
            this.quant = this.quant - Amount;
            return  true;
        }
        return  false;
    }

    public boolean newquant(int i){
        this.quant += i;
        return true;
    }




}
