package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener  {
    Button okButton, cancelButton;
    ListView list;
    ArrayList<StoreItems> restockData;
    ProductBaseAdapter adapter;
    EditText newQuantityView;
    StoreItems selectedItem = new StoreItems();
    boolean newQuant,itemselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        restockData = ((MyApp)getApplication()).getStoreItem();

        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);
        list = findViewById(R.id.restockData);
        newQuantityView = findViewById(R.id.restockQuantity);

        list = findViewById(R.id.restockData);

        adapter = new ProductBaseAdapter(restockData, this);
        list.setAdapter(adapter);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = restockData.get(i);
                newQuantityView.setText("");

                newQuant = false;
                itemselect = false;
            }
        });

    }

    @Override
    public void onClick(View v) {

        if (newQuant) {
            newQuant = false;
            newQuantityView.setText("");
        }
        switch (v.getId()){
            case R.id.okButton:

                if (itemselect || newQuantityView.getText().toString().isEmpty()) {
                    Toast.makeText(this, "All fields are REQUIRED", Toast.LENGTH_SHORT).show();
                    break;
                }
                selectedItem.newquant(Integer.parseInt(newQuantityView.getText().toString()));
                adapter.notifyDataSetChanged();
                newQuant=true;
                itemselect=true;
                newQuantityView.setText("");
                break;
            case R.id.cancelButton:
            Intent toManager = new Intent(RestockActivity.this,ManagerMenuActivity.class);
            startActivity(toManager);
            break;
        }

    }
}