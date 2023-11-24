package com.example.cashregisterapplication;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {
    //array
  //  ArrayList<StoreItems> storeItem = new ArrayList<>();
    ArrayList<StoreItems> storeItem;
    public ArrayList<StoreItems> getStoreItem() {
        if(storeItem==null)
        {   storeItem = new ArrayList<StoreItems>();
            storeItem.add(new StoreItems("Pants", 10, 20.44));
            storeItem.add(new StoreItems("Shoes", 100, 10.44));
            storeItem.add(new StoreItems("Hats", 30, 5.9));
        }
        return storeItem;
    }
    ArrayList<PurchaseHistory> purchasedItems = new ArrayList<>();
}
