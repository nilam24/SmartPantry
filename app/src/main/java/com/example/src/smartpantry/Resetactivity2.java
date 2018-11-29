package com.example.src.smartpantry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.src.smartpantry.pojos.Distributor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Resetactivity2 extends AppCompatActivity {

    EditText editEmail1,editOldps,editNewps,editName1,editContact;
    Button updatbtn,refreshbtn;
    ApiInterface apiInterface;
    Distributor distributor;
    List<Distributor>distributorList;
    String distributor_email;
    String unam,upas,ucon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.reset_layout);

        editEmail1=(EditText)findViewById(R.id.editTextEmail1);
        editOldps=(EditText)findViewById(R.id.editTextOldPass2);
        editNewps=(EditText)findViewById(R.id.editTextNewPass1);
        editName1=(EditText)findViewById(R.id.editTextName1);
        editContact=(EditText)findViewById(R.id.textcontact1);
        updatbtn=(Button)findViewById(R.id.buttonupdatepas1);
        refreshbtn=(Button)findViewById(R.id.buttonrefresh1);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Home Automation");
        distributor =new Distributor();
        distributorList=new ArrayList<>();

        Call<List<Distributor>>listCall=apiInterface.doLoginDistributor();
        listCall.enqueue(new Callback<List<Distributor>>() {
            @Override
            public void onResponse(Call<List<Distributor>> call, Response<List<Distributor>> response) {

                distributorList=response.body();
            }

            @Override
            public void onFailure(Call<List<Distributor>> call, Throwable t) {

            }
        });

        updatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em=editEmail1.getText().toString().trim();
                String olps=editOldps.getText().toString().trim();
                String nps=editNewps.getText().toString().trim();
                String nm=editName1.getText().toString().trim();
                String con=editContact.getText().toString().trim();

                if(em.length()==0){
                    editEmail1.setHint("enter email Id");
                }
                if(olps.length()==0)
                {
                    editOldps.setHint("enter old password");
                }

                if(nps.length()==0)
                {
                    editNewps.setHint("enter new password");
                }


                if(nm.length()==0)
                {
                    editName1.setHint("enter name");
                }
                if(con.length()==0)
                {
                    editContact.setHint("enter contact number");
                }

                 if((em.length()!=0)&& (olps.length()!=0)&&(nps.length()!=0)&&(con.length()!=0))
                {

                    for(int i=0;i<distributorList.size();i++) {

                        distributor_email=distributorList.get(i).getDistributorEmailId();
                        upas=distributorList.get(i).getDistributorPass();
                       // unam=distributorList.get(i).getDistributorFirstName();
                       // ucon=distributorList.get(i).getDistributorContact();

                        if((distributor_email.equals(em))&&(upas.equals(olps))) //&&(unam.equals(nm))&&(ucon.equals(con)))
                             {

                            if(olps.equals(upas)) {

                                doReset(em, nps);
                                Toast.makeText(Resetactivity2.this, "password has been changed", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Resetactivity2.this,"either incorrect entry or password not matched ",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            editEmail1.setHint("check email id");
                            editOldps.setHint("enter previous password");
                            editName1.setHint("enter name");
                            editContact.setHint("enter valid contact");
                        }
                    }
                }

            }
        });

        refreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editEmail1.setText("");
                editOldps.setText("");
                editNewps.setText("");
                editName1.setText("");
                editContact.setText("");

            }
        });

    }

    public int doReset(String em,String nps)
    {
        final int[] res = new int[1];

        Call<List<Distributor>> call=apiInterface.doReset2(em,nps);
        call.enqueue(new Callback<List<Distributor>>() {
            @Override
            public void onResponse(Call<List<Distributor>> call, Response<List<Distributor>> response) {


                res[0] =response.code();
                Toast.makeText(Resetactivity2.this,"password is  reset",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<Distributor>> call, Throwable t) {

                Log.e("failure","-- "+t.getMessage());
            }
        });

        return res[0];
    }

}
