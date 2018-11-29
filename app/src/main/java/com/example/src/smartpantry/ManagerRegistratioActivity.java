package com.example.src.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.src.smartpantry.pojos.Manager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerRegistratioActivity extends AppCompatActivity {

    Button reg;
    EditText fnm, lnm, emailid, pas, contact, cityy, stat, country;
    ApiInterface apiInterface;
    String fname;
    String lname;
    String em;
    String pass;
    String contactnum;
    String city;
    String state;
    String country1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        reg = (Button) findViewById(R.id.btnRegister1);
        fnm = (EditText) findViewById(R.id.editF);
        lnm = (EditText) findViewById(R.id.editL);
        emailid = (EditText) findViewById(R.id.editE);
        pas = (EditText) findViewById(R.id.editP);
        contact = (EditText) findViewById(R.id.editC);
        cityy = (EditText) findViewById(R.id.editcity);
        stat = (EditText) findViewById(R.id.editS);
        country = (EditText) findViewById(R.id.editCon);


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ManagerRegistratioActivity.this, "registration success", Toast.LENGTH_LONG).show();
                fname = fnm.getText().toString().trim();
                lname = lnm.getText().toString().trim();
                em = emailid.getText().toString().trim();
                pass = pas.getText().toString().trim();
                contactnum = contact.getText().toString().trim();
                city = cityy.getText().toString().trim();
                state = stat.getText().toString().trim();
                country1 = country.getText().toString().trim();

                if (fname.length() == 0) {
                    fnm.setHint("first name");

                }
                if (lname.length() == 0) {
                    lnm.setHint("last name");
                }
                if (em.length() == 0) {
                    emailid.setHint("email Id");

                }
                if (pass.length() == 0) {
                    pas.setHint("password");

                }
                if (contactnum.length() == 0) {
                    contact.setHint("mobile number");

                }
                if (city.length() == 0) {
                    cityy.setHint("city");

                }
                if (state.length() == 0) {

                    stat.setHint("state name");
                }
                if (country1.length() == 0) {
                    country.setHint("country");

                }

                if ((fname.length() != 0) && (lname.length() != 0) && (em.length() != 0) && (pass.length() != 0) && (contactnum.length() != 0) && (city.length() != 0) && (state.length() != 0) && (country1.length() != 0)) {

                    int count = insertUser(fname, lname, em, pass, contactnum, city, state, country1);
                    Toast.makeText(ManagerRegistratioActivity.this, "registration success"+count, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(ManagerRegistratioActivity.this, Loginactivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private int insertUser(String fnm1, String lnm1, String emailid1, String pas1, String contact1, String cityy1, String stat1, String country1) {

        final int[] res = {0};

        Call<Manager> call = apiInterface.insertUser(fnm1, lnm1, emailid1, pas1, contact1, cityy1, stat1, country1);
        call.enqueue(new Callback<Manager>() {
            @Override
            public void onResponse(Call<Manager> call, Response<Manager> response) {
                if (response.isSuccessful())
                    res[0] = response.code();
                Log.e("", "" + res);

            }

            @Override
            public void onFailure(Call<Manager> call, Throwable t) {

                if (call.isCanceled()) {
                    t.getMessage();
                    Log.e("", "" + t.getMessage());
                }

            }
        });

        return res[0];

    }

}
