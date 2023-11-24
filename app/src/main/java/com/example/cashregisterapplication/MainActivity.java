package com.example.cashregisterapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView productNameView, totalPurchaseView, quantityView;
    Button buyButton, clearButton, managerButton;
    ListView list;
    ArrayList<StoreItems> productData;
    ProductBaseAdapter adapter;
    Button[] numbuttons = new Button[10];
    StoreItems selectedItem = new StoreItems();
   // String product_Name;
    boolean newNumber;
    ArrayList<PurchaseHistory> purchasedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productData = ((MyApp) getApplication()).getStoreItem();

        productNameView = findViewById(R.id.productType);
        totalPurchaseView = findViewById(R.id.total);
        quantityView = findViewById(R.id.quantity);


        list = findViewById(R.id.storeInfo);

        adapter = new ProductBaseAdapter(productData, this);
        list.setAdapter(adapter);

        // Initialize numbuttons array
        for (int i = 0; i < 10; i++) {
            //create a string to get the resource ID of the button with that name
            int buttonId = getResources().getIdentifier("b" + i, "id", getPackageName());
            // finds the Button view associated with the resource ID and assigns it to the numbuttons array at the index
            numbuttons[i] = findViewById(buttonId);
            numbuttons[i].setOnClickListener(this); // Set the click listener for each button
        }
        buyButton = findViewById(R.id.buyButton);
        clearButton = findViewById(R.id.bclear);
        managerButton=findViewById(R.id.managerButton);

        buyButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        managerButton.setOnClickListener(this);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = productData.get(i);
                productNameView.setText(selectedItem.getName());
                newNumber = false;
                quantityView.setText("");
                totalPurchaseView.setText("");
            }
        });

        purchasedItems = ((MyApp)getApplication()).purchasedItems;

    }



    @Override
    public void onClick(View v) {

        if (newNumber) {
            newNumber = false;
            productNameView.setText("");
            quantityView.setText("");
            totalPurchaseView.setText("");
        }

        switch (v.getId()) {


                case R.id.bclear:
                    productNameView.setText("");
                    quantityView.setText("");
                    totalPurchaseView.setText("");
                    break;
                case R.id.buyButton:

                    if (productNameView.getText().toString().isEmpty() || quantityView.getText().toString().isEmpty()) {
                        Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int quantity = Integer.parseInt(quantityView.getText().toString());
                    String formattedTotal = String.format("%.2f", selectedItem.totalPurchased(quantity));
                    boolean checkAmount = selectedItem.purchasedAmount(quantity);


                    if (!checkAmount){
                        Toast.makeText(this, "Not Enough Quantity In Stock!!!", Toast.LENGTH_SHORT).show();
                        productNameView.setText("");
                        quantityView.setText("");
                        totalPurchaseView.setText("");

                    } else {
                        totalPurchaseView.setText(formattedTotal);
                        adapter.notifyDataSetChanged();
                        purchasedItems.add(new PurchaseHistory(selectedItem.getName(),quantity,Double.parseDouble(formattedTotal),new Date()));
                        showThankYouDialog();
                    }
                    newNumber = true;
                    break;
                case R.id.managerButton:
                    Intent toManagerMenu = new Intent(MainActivity.this,ManagerMenuActivity.class);
                    startActivity(toManagerMenu);
                    break;

                default:
                    for (int i = 0; i < numbuttons.length; i++) {
                        if (v.getId() == numbuttons[i].getId()) {
                            quantityView.append(String.valueOf(i));
                            break; // Exit the loop since we found a match
                        }
                    }
            }
     }

    //Alert popup
    private void showThankYouDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        productNameView.setText("");
        quantityView.setText("");
        totalPurchaseView.setText("");

        if (!purchasedItems.isEmpty()) {
            PurchaseHistory lastPurchase = purchasedItems.get(purchasedItems.size() - 1);

            builder.setTitle("Thank You for Your Purchase")
                    .setMessage("Your purchase is " + lastPurchase.getQnt() + " " + lastPurchase.getName() + " for " + lastPurchase.getValue())
                    .setCancelable(true) // Allow dismissing when clicking outside the dialog
                    .show();
        }
    }

}