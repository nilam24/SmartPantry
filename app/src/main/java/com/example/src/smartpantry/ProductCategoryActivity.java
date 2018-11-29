package com.example.src.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ProductCategoryActivity extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5,text6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        text1=(TextView)findViewById(R.id.textView);
        text2=(TextView)findViewById(R.id.textView2);
        text3=(TextView)findViewById(R.id.textView3);
        text4=(TextView)findViewById(R.id.textView7);
        text5=(TextView)findViewById(R.id.textView8);
        text6=(TextView)findViewById(R.id.textView9);

        text1.setText("Fruits");
        text2.setText("Vegetables");
        text3.setText("Grains");
        text4.setVisibility(View.VISIBLE);
        text4.setText("Oil Products");
        text5.setVisibility(View.VISIBLE);
        text5.setText("Milk Products");
        text6.setVisibility(View.VISIBLE);
        text6.setText("Beverages");


        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductCategoryActivity.this,FruitActivity.class);
                startActivity(intent);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductCategoryActivity.this,VegetablesActivity.class);
                startActivity(intent);
            }
        });



    }
}
