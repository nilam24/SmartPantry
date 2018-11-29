package com.example.src.smartpantry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textm,textd,textc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        textm=(TextView)findViewById(R.id.textView);
        textd=(TextView)findViewById(R.id.textView2);
        textc=(TextView)findViewById(R.id.textView3);

        textm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,Loginactivity.class);
                startActivity(in);
            }
        });

        textd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DistributorLoginactivity.class);
                startActivity(intent);
            }
        });

        textc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CatrLoginactivity.class);
                startActivity(intent);
            }
        });
    }
}
