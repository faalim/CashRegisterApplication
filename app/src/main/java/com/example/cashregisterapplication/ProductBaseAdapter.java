package com.example.cashregisterapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {
   ArrayList<StoreItems> items;
   Context context;
    public ProductBaseAdapter(ArrayList<StoreItems> list, Context context){
        this.items= list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.products_row,parent, false);

            TextView productName = v.findViewById(R.id.product_row_name);
            TextView price = v.findViewById(R.id.price_row_amount);
            TextView quantity = v.findViewById(R.id.quantity_row_amount);

            StoreItems item = items.get(position);

            productName.setText(item.getName());
            price.setText(String.valueOf(item.getValue()));
            quantity.setText(String.valueOf(item.getQnt()));


//            productName.setText(items.get(position).getName());
//            price.setText(String.valueOf(items.get(position).getValue()));
//            quantity.setText(String.valueOf(items.get(position).getQnt()));

            return v;


    }
}
