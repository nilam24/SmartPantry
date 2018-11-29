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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.src.smartpantry.pojos.Product;
import com.example.src.smartpantry.R;

import java.util.List;

public class AdapterProduct extends ArrayAdapter<Product> {

    List<Product>productList;


    public AdapterProduct(@NonNull Context context, int resource, @NonNull List<Product> productList) {
        super(context, resource, productList);
        this.productList=productList;
    }
    public AdapterProduct(Context context, List<Product>productList){
        super(context,0,0);

        this.productList=productList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Product getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable Product item) {
        return super.getPosition(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        Context context = parent.getContext();

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list_layout, parent, false);

        }

        TextView  textlable1,textQuantity1;
        ImageView imageView1;
        Button btnedit;

        imageView1=(ImageView)itemView.findViewById(R.id.imageproduct);
        textlable1=(TextView)itemView.findViewById(R.id.textLable1);
        textQuantity1=(TextView)itemView.findViewById(R.id.textQuantity);

        Product product=new Product();
        product=getItem(position);

        String img=product.getProductImg();

        byte[] byteArray = Base64.decode(img,0);

        Bitmap bitmap=BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        imageView1.setImageBitmap(bitmap);

        Log.e("image pic "," =" + bitmap);

        String lable=product.getProductName();
        textlable1.setText(lable);
        String quantity=product.getProductQuantity();
        textQuantity1.setText(quantity);

        return itemView;
    }
}


/*
 Glide.with(mContext).load(image.getMedium())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
    }
 */