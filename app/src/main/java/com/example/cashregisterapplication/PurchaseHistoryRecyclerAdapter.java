package com.example.cashregisterapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PurchaseHistoryRecyclerAdapter  extends
        RecyclerView.Adapter<PurchaseHistoryRecyclerAdapter.PurchaseHistoryViewHolder> {

    interface HistoryClickListener{
        void onHistClicked(int i);
    }
    ArrayList<PurchaseHistory> purchasedItems;
    Context context;
    HistoryClickListener listener;

    class PurchaseHistoryViewHolder extends RecyclerView.ViewHolder {
        public PurchaseHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

    public PurchaseHistoryRecyclerAdapter(ArrayList<PurchaseHistory> purchasedItems, Context context) {
        this.purchasedItems = purchasedItems;
        this.context = context;
    }

    @NonNull
    @Override
    public PurchaseHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.products_row,parent,false);
        return  new PurchaseHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseHistoryViewHolder holder, int position) {

        TextView productName = holder.itemView.findViewById(R.id.product_row_name);
        TextView price =  holder.itemView.findViewById(R.id.price_row_amount);
        TextView quantity =  holder.itemView.findViewById(R.id.quantity_row_amount);


        productName.setText(purchasedItems.get(position).getName());
        price.setText(String.valueOf(purchasedItems.get(position).getValue()));
        quantity.setText(String.valueOf(purchasedItems.get(position).getQnt()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onHistClicked(holder.getAdapterPosition()); // step 5
            }
        });
    }

    @Override
    public int getItemCount() {
        return purchasedItems.size();
    }



}
