package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;


import java.util.ArrayList;

public class HistoryDetailsActivity extends AppCompatActivity
        implements PurchaseHistoryRecyclerAdapter.HistoryClickListener  {
    ListView list;
    ArrayList<PurchaseHistory> purchasedData;
   // ProductBaseAdapter adapter;
    PurchaseHistoryRecyclerAdapter adapter;

    RecyclerView purchaseHistRec;
    PurchaseHistory selectedpurchase = new PurchaseHistory();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        purchasedData = ((MyApp) getApplication()).purchasedItems;


        purchaseHistRec = findViewById(R.id.recyclerlist);
        adapter = new PurchaseHistoryRecyclerAdapter(purchasedData,this);
        adapter.listener = this; // step 4
        purchaseHistRec.setAdapter(adapter);
        // todoRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        purchaseHistRec.setLayoutManager(new LinearLayoutManager(this));



        // any click on the list item should be done in the adapter.
    }

    @Override
    public void onHistClicked(int i) {
        selectedpurchase = purchasedData.get(i);
        Intent purchaseDetail = new Intent(HistoryDetailsActivity.this, PurchaseHistoryDetailsActivity.class);
        purchaseDetail.putExtra("purchaseHistoryItem",selectedpurchase);
        startActivity(purchaseDetail);

    }


//        list = findViewById(R.id.historyInfo);
//
//        adapter = new ProductBaseAdapter(purchasedData, this);
//        list.setAdapter(adapter);
//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                selectedpurchase = purchasedData.get(i);
//                Intent purchaseDetail = new Intent(HistoryDetailsActivity.this, PurchaseHistoryDetailsActivity.class);
//                purchaseDetail.putExtra("purchaseHistoryItem",selectedpurchase);
//                startActivity(purchaseDetail);
//            }
//        });
    }





