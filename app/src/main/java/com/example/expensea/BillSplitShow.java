package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class BillSplitShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_split_show);

        ListView lv= findViewById(R.id.liss);
        DataBase debe = new DataBase(BillSplitShow.this);
        List<billreturn> all = debe.bgetall();
        ArrayAdapter trippy =  new ArrayAdapter<billreturn>(BillSplitShow.this, android.R.layout.simple_list_item_1,all);
        lv.setAdapter(trippy);

    }    public void gh(View v)
    {
        Intent intent = new Intent(this, bills.class);
        startActivity(intent);
    }

}