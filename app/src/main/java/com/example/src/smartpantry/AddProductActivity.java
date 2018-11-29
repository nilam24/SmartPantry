package com.example.src.smartpantry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {

    EditText category, pName, pQuantity;
    ImageView imgProduct;
    Button savebtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product_layout);
        category = (EditText) findViewById(R.id.editProductCategory);
        pName = (EditText) findViewById(R.id.editProductName);
        pQuantity = (EditText) findViewById(R.id.editQuant);
        imgProduct = (ImageView) findViewById(R.id.imageView2);
        savebtn = (Button) findViewById(R.id.save);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String categoryproduct = category.getText().toString().trim();


                if (categoryproduct.equalsIgnoreCase("fruit")) {
                    Toast.makeText(AddProductActivity.this, "fruit", Toast.LENGTH_LONG).show();

                }
                if (categoryproduct.equalsIgnoreCase("vegetable")) {
                    Toast.makeText(AddProductActivity.this, "vegetable", Toast.LENGTH_LONG).show();

                }
                if (categoryproduct.equalsIgnoreCase("grain")) {
                    Toast.makeText(AddProductActivity.this, "grain", Toast.LENGTH_LONG).show();
                }
                if (categoryproduct.equalsIgnoreCase("oil")) {
                    Toast.makeText(AddProductActivity.this, "oil", Toast.LENGTH_LONG).show();
                }
                if (categoryproduct.equalsIgnoreCase("nonveg")) {
                    Toast.makeText(AddProductActivity.this, "nonveg", Toast.LENGTH_LONG).show();
                }
                if (categoryproduct.equalsIgnoreCase("beverages")) {
                    Toast.makeText(AddProductActivity.this, "beverages", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}
