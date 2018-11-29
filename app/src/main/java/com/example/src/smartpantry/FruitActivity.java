package com.example.src.smartpantry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.src.smartpantry.adapter.FruitAdapter;
import com.example.src.smartpantry.pojos.ProductFruit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitActivity extends AppCompatActivity {

    ListView listView2;
    TextView emptyview;
    FruitAdapter fruitAdapter;
    ApiInterface ap;
    ProductFruit productFruit;
    List<ProductFruit> product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_layout);
        listView2=(ListView)findViewById(R.id.listviewProduct);
        emptyview=(TextView)findViewById(R.id.empty);

        productFruit=new ProductFruit();
        product=new ArrayList<>();
        ap=ApiClient.getApiClient().create(ApiInterface.class);
        fruitAdapter=new FruitAdapter(FruitActivity.this,new ArrayList<ProductFruit>());

       // listView1.setAdapter(fruitAdapter);
        Call<List<ProductFruit>>call=ap.getFruitList();
        call.enqueue(new Callback<List<ProductFruit>>() {
            @Override
            public void onResponse(Call<List<ProductFruit>> call, Response<List<ProductFruit>> response) {

                product=response.body();
                if(product==null)
                {
                    emptyview.setVisibility(View.VISIBLE);
                    listView2.setEmptyView(emptyview);

                }
                if(product!=null) {
                    fruitAdapter=new FruitAdapter(FruitActivity.this,product);
                    fruitAdapter.addAll(product);
                   // fruitAdapter.addAll(product);
                    listView2.setAdapter(fruitAdapter);
                    fruitAdapter.notifyDataSetChanged();
                    Log.e(" response P ", " " + product);
                }

            }

            @Override
            public void onFailure(Call<List<ProductFruit>> call, Throwable t) {
                Log.e(" failure P",""+t.getMessage());
            }
        });

    }
}
