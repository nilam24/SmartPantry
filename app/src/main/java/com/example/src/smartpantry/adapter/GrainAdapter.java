package com.example.src.smartpantry.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.src.smartpantry.pojos.ProductGrain;

import java.util.List;

public class GrainAdapter extends ArrayAdapter<ProductGrain> {

    List<ProductGrain>productGrainList;
    ProductGrain productGrain;
    public GrainAdapter(@NonNull Context context, int resource, @NonNull List<ProductGrain>productGrainList ) {
        super(context, resource, productGrainList);
    }

    public GrainAdapter(Context context,List<ProductGrain>productGrainList){
        super(context,0,0);
        this.productGrainList=productGrainList;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public ProductGrain getItem(int position) {
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
