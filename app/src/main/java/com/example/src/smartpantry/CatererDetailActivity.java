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

import com.example.src.smartpantry.adapter.AdapterCaterer;
import com.example.src.smartpantry.pojos.Caterer;
import com.example.src.smartpantry.pojos.Distributor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatererDetailActivity extends AppCompatActivity {

    Button showbtn1;
    ListView listView1;
    TextView emptytext;
    ApiInterface apiInterface;
    AdapterCaterer adapterCaterer;
    Caterer caterer;
    List<Caterer>catererList;
    String eml,emailId;
    List<Caterer>newList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        Intent intentEx=getIntent();
        if(intentEx!=null)
        {
            eml=intentEx.getStringExtra("email");
        }

        listView1=(ListView)findViewById(R.id.listview1);
        emptytext=(TextView)findViewById(R.id.textviewempty);
        showbtn1=(Button)findViewById(R.id.btnshowProduct);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        caterer=new Caterer();
        catererList=new ArrayList<>();
        adapterCaterer=new AdapterCaterer(this,new ArrayList<Caterer>());

        Call<List<Caterer>>call=apiInterface.getListCaterer();
        call.enqueue(new Callback<List<Caterer>>() {
            @Override
            public void onResponse(Call<List<Caterer>> call, Response<List<Caterer>> response) {
                catererList=response.body();

                for(int i=0;i<catererList.size();i++)
                {
                    emailId=catererList.get(i).getCatererEmailId();
                    if(emailId.equals(eml))
                    {
                        String fnm=catererList.get(i).getCatererFirstName();
                        String lnm=catererList.get(i).getCatererLastName();
                        String em=catererList.get(i).getCatererEmailId();
                        String p=catererList.get(i).getCatererPass();
                        String c=catererList.get(i).getCatererContact();
                        String city=catererList.get(i).getCatererCity();
                        String st=catererList.get(i).getCatererState();
                        String country=catererList.get(i).getCatererCountry();

                        caterer=new Caterer(fnm,lnm,em,p,c,city,st,country);
                        newList.add(caterer);
                        adapterCaterer.addAll(newList);
                        listView1.setAdapter(adapterCaterer);
                        adapterCaterer.notifyDataSetChanged();
                        break;
                    }
                }
                adapterCaterer.addAll(catererList);
                listView1.setAdapter(adapterCaterer);
                adapterCaterer.notifyDataSetChanged();
                Log.e("response C",""+catererList);
            }

            @Override
            public void onFailure(Call<List<Caterer>> call, Throwable t) {

                Log.e("failure  ",""+t.getMessage());
            }
        });
        showbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(CatererDetailActivity.this,ProductCategoryActivity.class);
                startActivity(in);
            }
        });
    }
}
