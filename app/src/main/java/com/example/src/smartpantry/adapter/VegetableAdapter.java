package com.example.src.smartpantry.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.src.smartpantry.R;
import com.example.src.smartpantry.pojos.ProductVegetable;

import java.util.List;

public class VegetableAdapter extends ArrayAdapter<ProductVegetable> {

   List<ProductVegetable>vegetableList;
   ProductVegetable productVegetable;

    public VegetableAdapter(@NonNull Context context, int resource, @NonNull List<ProductVegetable> vegetableList) {
        super(context, resource, vegetableList);
        this.vegetableList=vegetableList;
    }

    public VegetableAdapter(Context context,List<ProductVegetable>vegetableList)
    {
        super(context,0,0);
        this.vegetableList=vegetableList;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public ProductVegetable getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView=convertView;

        itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);
        TextView textNm,textQuant;
        ImageView img;
        textNm=(TextView)itemView.findViewById(R.id.textLable1);
        textQuant=(TextView)itemView.findViewById(R.id.textQuantity);
        img=(ImageView)itemView.findViewById(R.id.imageproduct);

        productVegetable=new ProductVegetable();

        productVegetable=getItem(position);
        String nm=productVegetable.getProductVegeName();
        textNm.setText(nm);
        String image=productVegetable.getProductVegeImg();
        byte[] byteArray = Base64.decode(image,0);

        Bitmap bitmap= BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        img.setImageBitmap(bitmap);

        String q=productVegetable.getProductVegeQuantityInGm();
        textQuant.setText(q);

        return itemView;
    }
}
