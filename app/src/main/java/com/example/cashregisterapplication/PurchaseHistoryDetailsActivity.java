package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PurchaseHistoryDetailsActivity extends AppCompatActivity {

    TextView displayPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history_details);

        displayPurchase = findViewById(R.id.displayPurchase);

        PurchaseHistory item = (PurchaseHistory) getIntent().getSerializableExtra("purchaseHistoryItem");
        String purchase = "Product: "+item.getName()+"\nPrice: "+item.getValue()+"\nPurchase Date "+ item.getTimeOfPurchease();
        displayPurchase.setText(purchase);


    }
}