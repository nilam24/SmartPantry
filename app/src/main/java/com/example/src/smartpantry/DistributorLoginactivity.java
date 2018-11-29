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

import com.example.src.smartpantry.pojos.Distributor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistributorLoginactivity extends AppCompatActivity {

    EditText editEmail, editPas;
    TextView textReset;
    Button loginbtn, registerbtn, refreshbtn;
    ApiInterface apiInterface;
    Distributor distributor;
    List<Distributor> distributorList;
    String em, ps, e, p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        editEmail = (EditText) findViewById(R.id.editId);
        editPas = (EditText) findViewById(R.id.editpass);
        textReset = (TextView) findViewById(R.id.textreset);
        loginbtn = (Button) findViewById(R.id.btnlogin);
        registerbtn = (Button) findViewById(R.id.btnregister);
        refreshbtn = (Button) findViewById(R.id.btnreset);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        distributor = new Distributor();
        distributorList = new ArrayList<>();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DistributorLoginactivity.this, DistributorRegistrationActivity.class);
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

                em = editEmail.getText().toString().trim();
                ps = editPas.getText().toString().trim();
                Call<List<Distributor>> call = apiInterface.doLoginDistributor();
                call.enqueue(new Callback<List<Distributor>>() {
                    @Override
                    public void onResponse(Call<List<Distributor>> call, Response<List<Distributor>> response) {

                        distributorList = response.body();
                        Log.e("list==", "" + distributorList);
                        for (int i = 0; i < distributorList.size(); i++) {
                            e = distributorList.get(i).getDistributorEmailId();
                            p = distributorList.get(i).getDistributorPass();
                            if ((e.equals(em)) && (p.equals(ps))) {
                                Intent in = new Intent(DistributorLoginactivity.this, DistributorDetailActivity.class);
                                in.putExtra("email",e);
                                startActivity(in);
                                Toast.makeText(DistributorLoginactivity.this, "login success:-)", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Distributor>> call, Throwable t) {

                        Log.e("failure", "" + t.getMessage());
                    }
                });

            }
        });

        textReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(DistributorLoginactivity.this,Resetactivity2.class);
                startActivity(in);
            }
        });


    }
}
