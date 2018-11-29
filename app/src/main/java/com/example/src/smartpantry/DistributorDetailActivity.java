package com.example.src.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.src.smartpantry.adapter.AdapterDistributor;
import com.example.src.smartpantry.pojos.Distributor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistributorDetailActivity extends AppCompatActivity {

    Button showbtn1;
    ListView listView1;
    TextView emptytext;
    ApiInterface apiInterface;
    AdapterDistributor adapterDistributor;
    Distributor distributor;
    List<Distributor>distributorList;
    List<Distributor>newList;

    String email,emailId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        Intent intentExtra=getIntent();
        if(intentExtra!=null) {
             email = getIntent().getStringExtra("email");
        }
        listView1=(ListView)findViewById(R.id.listview1);
        emptytext=(TextView)findViewById(R.id.textviewempty);
        showbtn1=(Button)findViewById(R.id.btnshowProduct);

        distributor=new Distributor();
        distributorList=new ArrayList<>();
        newList=new ArrayList<>();
        adapterDistributor=new AdapterDistributor(this,new ArrayList<Distributor>());

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Distributor>>call=apiInterface.getListDistributor();
        call.enqueue(new Callback<List<Distributor>>() {
            @Override
            public void onResponse(Call<List<Distributor>> call, Response<List<Distributor>> response) {
                distributorList=response.body();
                Log.e(" success response  "," "+distributorList);
                for(int i=0;i<distributorList.size();i++)
                {
                  emailId=distributorList.get(i).getDistributorEmailId();
                  if(emailId.equals(email))
                  {
                    String fnm=distributorList.get(i).getDistributorFirstName();
                    String lnm=distributorList.get(i).getDistributorLastName();
                    String em=distributorList.get(i).getDistributorEmailId();
                    String p=distributorList.get(i).getDistributorPass();
                    String c=distributorList.get(i).getDistributorContact();
                    String city=distributorList.get(i).getDistributorCity();
                    String st=distributorList.get(i).getDistributorState();
                    String country=distributorList.get(i).getDistributorCountry();

                    distributor=new Distributor(fnm,lnm,em,p,c,city,st,country);
                    newList.add(distributor);
                    adapterDistributor.addAll(newList);
                    listView1.setAdapter(adapterDistributor);
                    adapterDistributor.notifyDataSetChanged();
                      break;
                  }
                }

               // adapterDistributor.addAll(distributorList);
               // listView1.setAdapter(adapterDistributor);
              //  adapterDistributor.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Distributor>> call, Throwable t) {

                Log.e(" failure  "," "+t.getMessage());
            }
        });

        showbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DistributorDetailActivity.this,ProductCategoryActivity.class);
                startActivity(intent);

            }
        });

    }
}
