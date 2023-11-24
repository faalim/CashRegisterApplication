package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerMenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button historyButton, restockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_menu);


        historyButton = findViewById(R.id.toHistory);
        restockButton = findViewById(R.id.restockButton);

        historyButton.setOnClickListener(this);
        restockButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toHistory:
                Intent toHistoryPage = new Intent(ManagerMenuActivity.this, HistoryDetailsActivity.class);
                startActivity(toHistoryPage);

                break;
            case R.id.restockButton:
                Intent torestockPage = new Intent(ManagerMenuActivity.this, RestockActivity.class);
                startActivity(torestockPage);

                break;

        }


    }
}