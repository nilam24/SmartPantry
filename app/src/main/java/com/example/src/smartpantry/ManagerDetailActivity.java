package com.example.src.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.src.smartpantry.adapter.AdapterManager;
import com.example.src.smartpantry.pojos.Manager;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerDetailActivity extends AppCompatActivity {

    Button shobtn,btnalloc;
    ListView listView1;
    TextView emptytext;
    AdapterManager adapterManager;
    Manager manager;
    List<Manager>managerList;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        listView1=(ListView)findViewById(R.id.listview1);
        emptytext=(TextView)findViewById(R.id.textviewempty);
       // shobtn=(Button)findViewById(R.id.btnshowProduct);
        btnalloc=(Button)findViewById(R.id.btnAllocation);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        manager=new Manager();
        managerList=new ArrayList<>();
        adapterManager=new AdapterManager(this,new ArrayList<Manager>());

        Call<List<Manager>>call=apiInterface.getListManager();
        call.enqueue(new Callback<List<Manager>>() {
            @Override
            public void onResponse(Call<List<Manager>> call, Response<List<Manager>> response) {

                managerList=response.body();
                adapterManager.addAll(managerList);
                listView1.setAdapter(adapterManager);
                adapterManager.notifyDataSetChanged();
                Log.e("response  "," "+managerList);
            }

            @Override
            public void onFailure(Call<List<Manager>> call, Throwable t) {

                Log.e("failure "," "+t.getMessage());
            }
        });

//        shobtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(ManagerDetailActivity.this,ProductCategoryActivity.class);
//                startActivity(intent);
//            }
//        });


        btnalloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ManagerDetailActivity.this,AllocationActivity.class);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_alloc,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int option=item.getItemId();
        if(option==R.id.alloc)
        {
            Intent intent=new Intent(ManagerDetailActivity.this,AllocationActivity.class);
            startActivity(intent);
        }
        //Toast.makeText(ManagerDetailActivity.this,"allocation screen",Toast.LENGTH_LONG).show();
        if(option==R.id.addProduct)
        {
            Intent intent=new Intent(ManagerDetailActivity.this,AddProductActivity.class);
            startActivity(intent);
        }
        if(option==R.id.showProduct)
        {
            Intent intent=new Intent(ManagerDetailActivity.this,ProductCategoryActivity.class);
            startActivity(intent);
        }

        return true;
    }
}
