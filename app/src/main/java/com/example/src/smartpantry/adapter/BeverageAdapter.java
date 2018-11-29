package com.example.src.smartpantry.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.src.smartpantry.pojos.ProductBeverage;

import java.util.List;

public class BeverageAdapter extends ArrayAdapter<ProductBeverage> {

    List<ProductBeverage>beverageList;
    ProductBeverage productBeverage;
    public BeverageAdapter(@NonNull Context context, int resource, @NonNull List<ProductBeverage> productBeverageList) {
        super(context, resource, productBeverageList);
    }

    public BeverageAdapter(Context context,List<ProductBeverage>productBeverageList){
        super(context,0,0);

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public ProductBeverage getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        

        return super.getView(position, convertView, parent);
    }
}
