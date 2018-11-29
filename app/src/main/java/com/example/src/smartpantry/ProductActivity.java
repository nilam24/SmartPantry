package com.example.src.smartpantry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.src.smartpantry.adapter.AdapterProduct;
import com.example.src.smartpantry.pojos.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    ListView listView1;
    AdapterProduct adapterProduct;
    ApiInterface ap;
    Product product;
    List<Product>productList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_layout);

        listView1=(ListView)findViewById(R.id.listviewProduct);

        adapterProduct=new AdapterProduct(this,new ArrayList<Product>());
        ap=ApiClient.getApiClient().create(ApiInterface.class);

        product=new Product();
        productList=new ArrayList<>();
        Call<List<Product>>call=ap.getListProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                productList=response.body();

                adapterProduct.addAll(productList);
                listView1.setAdapter(adapterProduct);
                adapterProduct.notifyDataSetChanged();
                Log.e(" response P "," "+productList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                Log.e(" failure P",""+t.getMessage());
            }
        });

    }
}
