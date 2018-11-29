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
import com.example.src.smartpantry.pojos.ProductOil;

import java.util.List;

public class OilProductAdapter extends ArrayAdapter<ProductOil> {

   List<ProductOil>productOilList;
   ProductOil productOil;

    public OilProductAdapter(@NonNull Context context, int resource, @NonNull List<ProductOil> productOilList) {
        super(context, resource, productOilList);
    }

    public OilProductAdapter(Context context,List<ProductOil>productOilList){
        super(context,0,productOilList);
        this.productOilList=productOilList;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public ProductOil getItem(int position) {
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
        itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);

        TextView textnm,textquant;
        ImageView img1;

        textnm=(TextView)itemView.findViewById(R.id.textLable1);
        textquant=(TextView)itemView.findViewById(R.id.textQuantity);
        img1=(ImageView)itemView.findViewById(R.id.imageproduct);

        productOil=new ProductOil();
        productOil=getItem(position);
        String nm=productOil.getProductOilName();
        textnm.setText(nm);
        String q=productOil.getProductOilQuantity();
        textquant.setText(q);
        String image=productOil.getProductOilImg();
        byte[]bytes= Base64.decode(image,0);
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        img1.setImageBitmap(bitmap);


        return itemView;
    }
}
