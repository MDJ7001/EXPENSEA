package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class bills extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        Button sendbutton1 = findViewById(R.id.btn17);
        EditText ppl = findViewById(R.id.butt);

        EditText amt = findViewById(R.id.txty);

        EditText sendtext = findViewById(R.id.txt18);
        EditText sendtext1 = findViewById(R.id.txt20);
        EditText sendtext2 = findViewById(R.id.txt21);
        EditText sendtext3 = findViewById(R.id.txt22);
        EditText sendtext4 = findViewById(R.id.txt23);
        EditText sendtext5 = findViewById(R.id.txt24);



        sendbutton1.setOnClickListener(view -> {
            billmodel ex2 ;
            try {
                int totppl=Integer.parseInt(ppl.getText().toString().trim());
                int totamt=Integer.parseInt(amt.getText().toString().trim());
                float eachamtf=totamt/totppl;
                int eachamt=(int)eachamtf;
                ex2 = new billmodel(sendtext.getText().toString().trim(),Integer.parseInt(ppl.getText().toString().trim()),eachamt, sendtext1.getText().toString().trim(),sendtext2.getText().toString().trim(),sendtext3.getText().toString().trim(),sendtext4.getText().toString().trim(),sendtext5.getText().toString().trim());
                Toast.makeText(bills.this,"SUCCESS",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {   int totppl=Integer.parseInt(ppl.getText().toString().trim());
                int totamt=Integer.parseInt(amt.getText().toString().trim());
                int eachamt=totamt/totppl;

                Toast.makeText(bills.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new billmodel(sendtext.getText().toString().trim(),Integer.parseInt(ppl.getText().toString().trim()),eachamt, sendtext1.getText().toString().trim(),sendtext2.getText().toString().trim(),sendtext3.getText().toString().trim(),sendtext4.getText().toString().trim(),sendtext5.getText().toString().trim());
            }
            DataBase wee = new DataBase(bills.this);
            wee.baddOne(ex2);
        });
    }
    public void gh(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void ss(View v)
    {
        Intent intent = new Intent(this, BillSplitShow.class);
        startActivity(intent);
    }
}