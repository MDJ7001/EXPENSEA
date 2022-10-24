package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class travel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        TextView te = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance().format(calendar.getTime());
        ListView lv= findViewById(R.id.liss);
        te.setText(date);

        DataBase debe = new DataBase(travel.this);
        List<tripmodel> all = debe.tgetall();
        ArrayAdapter trippy =  new ArrayAdapter<tripmodel>(travel.this, android.R.layout.simple_list_item_1,all);
        lv.setAdapter(trippy);
    }



    public void ta(View v) {
        Intent intent = new Intent(this, tripadd.class);
        startActivity(intent);
    }
    public void gh(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}