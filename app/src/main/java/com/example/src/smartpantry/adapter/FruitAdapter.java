package com.example.src.smartpantry.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.src.smartpantry.R;
import com.example.src.smartpantry.pojos.ProductFruit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<ProductFruit> {

    List<ProductFruit>fruitList;
    ProductFruit productFruit;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<ProductFruit> fruitList) {
        super(context, resource, fruitList);
        this.fruitList=fruitList;
    }

    public FruitAdapter(Context context,List<ProductFruit>fruitList)
    {
        super(context,0,0);
        this.fruitList=fruitList;

    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Nullable
    @Override
    public ProductFruit getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getPosition(@Nullable ProductFruit item) {
        return super.getPosition(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView=convertView;

        itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);

        TextView textNm,textQuant;
        ImageView img;
        textNm=(TextView)itemView.findViewById(R.id.textLable1);
        textQuant=(TextView)itemView.findViewById(R.id.textQuantity);
        img=(ImageView)itemView.findViewById(R.id.imageproduct);

        productFruit=new ProductFruit();

        productFruit=getItem(position);
        String fruitnm=productFruit.getProductFruitName();
        Log.e("fruit nam",""+fruitnm);
        textNm.setText(fruitnm);
        String fruitImg=productFruit.getProductFruitImg();
        byte[] byteArray = Base64.decode(fruitImg,0);

        Bitmap bitmap= BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        img.setImageBitmap(bitmap);

        String quant=productFruit.getProductFruitQuantityInGm();
        textQuant.setText(quant);

        return itemView;
    }
}
