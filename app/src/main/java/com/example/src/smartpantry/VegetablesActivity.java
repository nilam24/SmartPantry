package com.example.src.smartpantry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.example.src.smartpantry.adapter.VegetableAdapter;
import com.example.src.smartpantry.pojos.ProductVegetable;

import java.util.ArrayList;
import java.util.List;

public class VegetablesActivity extends AppCompatActivity {

    ListView listView1;
    VegetableAdapter vegetableAdapter;
    ApiInterface ap;
    ProductVegetable vegetable;
    List<ProductVegetable> productList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_layout);
        listView1=(ListView)findViewById(R.id.listviewProduct);
        ap=ApiClient.getApiClient().create(ApiInterface.class);
        vegetable=new ProductVegetable();
        productList=new ArrayList<>();

        vegetableAdapter=new VegetableAdapter(this,new ArrayList<ProductVegetable>());

    }
}
