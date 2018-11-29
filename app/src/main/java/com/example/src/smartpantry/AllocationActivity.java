package com.example.src.smartpantry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.src.smartpantry.adapter.AdapterAllocation;
import com.example.src.smartpantry.pojos.AllocationPojo;
import com.example.src.smartpantry.pojos.Distributor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationActivity extends AppCompatActivity {

    Spinner spinnerDis, spinnerCate;
    TextView textRefreshlist;
    ListView listView1;
    List<String> stringList, stringList2;
    List<Distributor> distributorList;
    List<AllocationPojo> listalloccated;
    String disNam,disCont,cate;
    Button btnsave;
    AdapterAllocation adapterAlloc;
    ApiInterface ap1, ap2, ap3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allocation_layout);

        spinnerDis = (Spinner) findViewById(R.id.spinner);
        spinnerCate = (Spinner) findViewById(R.id.spinner2);
        btnsave = (Button) findViewById(R.id.btnAlloc);
        textRefreshlist = (TextView) findViewById(R.id.textrefresh);
        listView1=(ListView)findViewById(R.id.listalloc);

        distributorList = new ArrayList<>();
        stringList = new ArrayList<>();
        stringList2 = new ArrayList<>();
        listalloccated = new ArrayList<>();
        adapterAlloc=new AdapterAllocation(AllocationActivity.this,new ArrayList<AllocationPojo>());
        listView1.setAdapter(adapterAlloc);

        ap1 = ApiClient.getApiClient().create(ApiInterface.class);
        ap2 = ApiClient.getApiClient().create(ApiInterface.class);
        ap3 = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Distributor>> calldoc = ap1.getListDistributor();

        calldoc.enqueue(new Callback<List<Distributor>>() {
            @Override
            public void onResponse(Call<List<Distributor>> call, Response<List<Distributor>> response) {
                if (response.isSuccessful()) {
                    distributorList = response.body();
                    int i = 0;
                    for (i = 0; i < distributorList.size(); i++) {

                       // stringList.add(distributorList.get(i).getDistributorEmailId());
                        stringList.add(distributorList.get(i).getDistributorFirstName());
                        disCont=distributorList.get(i).getDistributorContact();
                       // stringList.add(distributorList.get(i).getDistributorContact());
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AllocationActivity.this, android.R.layout.simple_spinner_item, stringList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

                    spinnerDis.setAdapter(dataAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Distributor>> call, Throwable t) {

                t.printStackTrace();
            }
        });


// Fruits
//  2. vegetables
//  3. Grains
//  4. Non-veg
//  5. Oil Products
//  6. Milk products
//  7. Beverages
//                     }
        stringList2.add("Grains");
        stringList2.add("Vegetables");
        stringList2.add("Fruits");
        stringList2.add("Non-veg");
        stringList2.add("Oil products");
        stringList2.add("Milk Products");
        stringList2.add("Beverages");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(AllocationActivity.this, android.R.layout.simple_spinner_dropdown_item, stringList2);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCate.setAdapter(dataAdapter1);


        spinnerDis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                disNam = adapterView.getItemAtPosition(pos).toString();
               // disCont=adapterView.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerCate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                cate = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveAllocation(disNam,disCont,cate);
                Toast.makeText(AllocationActivity.this, "allocated", Toast.LENGTH_LONG).show();
            }
        });



        textRefreshlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AllocationActivity.this, "refreshed", Toast.LENGTH_LONG).show();
                Call<List<AllocationPojo>> callalloc = ap1.getAlloc();
                callalloc.enqueue(new Callback<List<AllocationPojo>>() {
                    @Override
                    public void onResponse(Call<List<AllocationPojo>> call, Response<List<AllocationPojo>> response) {
                        listalloccated = response.body();

                        adapterAlloc.addAll(listalloccated);
                        //adapterAlloc=new AdapterAllocation(AllocationActivity.this,listalloccated);
                        listView1.setAdapter(adapterAlloc);
                        adapterAlloc.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<AllocationPojo>> call, Throwable t) {

                    }
                });
               // adapterAlloc.notifyDataSetChanged();
            }
        });

    }

    public int saveAllocation(String nm,String Cont, String category) {

        final int[] res = {0};
        nm = disNam;
        Cont=disCont;
        category = cate;
        Call<AllocationPojo> call = ap3.saveAllocation(nm,Cont,category);
        call.enqueue(new Callback<AllocationPojo>() {
            @Override
            public void onResponse(Call<AllocationPojo> call, Response<AllocationPojo> response) {
                if (response.isSuccessful()) {
                   res[0] = response.code();
                    Toast.makeText(AllocationActivity.this, "data saved" + res, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<AllocationPojo> call, Throwable t) {

               if (call.isCanceled()) {
                    res[0] = 0;
                    t.printStackTrace();
                }
            }
        });

       return res[0];
    }

}
