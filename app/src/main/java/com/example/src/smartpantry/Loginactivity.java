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

import com.example.src.smartpantry.pojos.Manager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Loginactivity extends AppCompatActivity {

    EditText editEmail,editPas;
    TextView textReset;
    Button loginbtn,registerbtn,refreshbtn;
    ApiInterface apiInterface;
    Manager manager;
    List<Manager>managerList;
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
         manager=new Manager();
         managerList=new ArrayList<>();

         registerbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent=new Intent(Loginactivity.this,ManagerRegistratioActivity.class);
                 startActivity(intent);

             }
         });

         textReset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent=new Intent(Loginactivity.this,Resetactivity.class);
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

                  if(em.length()==0)
                  {
                      editEmail.setHint("enter valid emailId");

                  }
                  if(ps.length()==0)
                  {
                      editPas.setHint("enter valid password");

                  }
                  else {
                      Call<List<Manager>> call = apiInterface.doLoginManager();
                      call.enqueue(new Callback<List<Manager>>() {
                          @Override
                          public void onResponse(Call<List<Manager>> call, Response<List<Manager>> response) {

                              managerList = response.body();
                              Log.e("list==", "" + managerList);
                              for (int i = 0; i < managerList.size(); i++) {
                                  e = managerList.get(i).getManagerEmailId();
                                  p = managerList.get(i).getManagerPass();
                                  if ((e.equals(em)) && (p.equals(ps))) {
                                      Intent in = new Intent(Loginactivity.this, ManagerDetailActivity.class);
                                      startActivity(in);
                                      Toast.makeText(Loginactivity.this, "login success:-)", Toast.LENGTH_LONG).show();
                                      break;
                                  }
                              }
                          }

                          @Override
                          public void onFailure(Call<List<Manager>> call, Throwable t) {

                              Log.e("failure", "" + t.getMessage());
                          }
                      });
                  }

             }
         });



    }
}
