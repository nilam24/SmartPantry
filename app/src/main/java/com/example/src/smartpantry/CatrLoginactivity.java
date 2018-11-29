package com.example.src.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.src.smartpantry.pojos.Caterer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatrLoginactivity extends AppCompatActivity {

    EditText editEmail,editPas;
    TextView textReset;
    Button loginbtn,registerbtn,refreshbtn;
    ApiInterface apiInterface;
    Caterer caterer;
    List<Caterer>catererList;
    String em,ps,e,p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        editEmail=(EditText)findViewById(R.id.editId);
        editPas=(EditText)findViewById(R.id.editpass);
        textReset=(TextView)findViewById(R.id.textreset);
        loginbtn=(Button)findViewById(R.id.btnlogin);
        registerbtn=(Button)findViewById(R.id.btnregister);
        refreshbtn=(Button)findViewById(R.id.btnreset);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        caterer=new Caterer();
        catererList=new ArrayList<>();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(CatrLoginactivity.this,CatererRegistrationActivity.class);
                startActivity(intent);
            }
        });
        refreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editEmail.setText("");
                editPas.setText("");
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                em=editEmail.getText().toString().trim();
                ps=editPas.getText().toString().trim();
                Call<List<Caterer>>call=apiInterface.doLoginCaterer();
                call.enqueue(new Callback<List<Caterer>>() {
                    @Override
                    public void onResponse(Call<List<Caterer>> call, Response<List<Caterer>> response) {

                        catererList=response.body();
                        Log.e("list==",""+catererList);
                        for(int i=0;i<catererList.size();i++)
                        {
                            e=catererList.get(i).getCatererEmailId();
                            p=catererList.get(i).getCatererPass();
                            if((e.equals(em))&&(p.equals(ps)))
                            {
                                Intent in=new Intent(CatrLoginactivity.this,CatererDetailActivity.class);
                                in.putExtra("email",e);
                                startActivity(in);
                                Toast.makeText(CatrLoginactivity.this,"login success:-)",Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Caterer>> call, Throwable t) {

                        Log.e("failure",""+t.getMessage());
                    }
                });

            }
        });

        textReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(CatrLoginactivity.this,Resetactivity3.class);
                startActivity(in);
            }
        });


    }
}
