package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tripadd extends AppCompatActivity {
    EditText tex1;
    EditText tex2;
    Button sendd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tripadd);
        tex1 = findViewById(R.id.t2);
        tex2 = findViewById(R.id.t3);
        sendd = findViewById(R.id.btn17);
        sendd.setOnClickListener(view -> {
            tripmodel t1 ;
            try {
                t1= new tripmodel( tex1.getText().toString(),Integer.parseInt(tex2.getText().toString().trim()));
                Toast.makeText(tripadd.this,"success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {
                Toast.makeText(tripadd.this,"ERROR",Toast.LENGTH_LONG).show();
                t1 = new tripmodel("ERROR", Integer.parseInt(tex1.getText().toString().trim()));
            }
            DataBase wee = new DataBase(tripadd.this);
            wee.tadd(t1);
        });
        }
    public void ant(View v)
    {
        Intent intent = new Intent(this, travel.class);
        intent.putExtra("key",1);
        startActivity(intent);    }

    public void gh(View v)
    {
        Intent intent = new Intent(this, travel.class);
        startActivity(intent);
    }
}