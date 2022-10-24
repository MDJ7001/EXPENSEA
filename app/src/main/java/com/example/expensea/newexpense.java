package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;


public class newexpense extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newexpense);

        Button sendbutton1;
        Button sendbutton2;
        Button sendbutton3;
        Button sendbutton4;
        Button sendbutton5;
        Button sendbutton6;

        EditText sendtext;

        sendbutton1 = findViewById(R.id.button6);
        sendbutton2 = findViewById(R.id.button7);
        sendbutton3 = findViewById(R.id.button5);
        sendbutton4 = findViewById(R.id.button2);
        sendbutton5 = findViewById(R.id.button3);
        sendbutton6 = findViewById(R.id.btn4);
        sendtext = findViewById(R.id.expense);
        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance().format(calendar.getTime());
        MonthDay md = MonthDay.now();
        YearMonth nd = YearMonth.now();
        LocalDate date2 = LocalDate.now();
        String day = String.valueOf(date2.getDayOfWeek());
        String monthday = String.valueOf(md);
        String yearmonth = String.valueOf(nd);
        String dayno1 = monthday.substring(monthday.length()-2,monthday.length());
        String month1 = monthday.substring(2,4);
        String year1 = yearmonth.substring(0,4);
        int dayno = Integer.parseInt(dayno1);
        int month = Integer.parseInt(month1);
        int year = Integer.parseInt(year1);



        sendbutton1.setOnClickListener(view -> {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(newexpense.this,"Success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {
                Toast.makeText(newexpense.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
            }
            DataBase wee = new DataBase(newexpense.this);
            wee.addOne(ex2);
        });
        sendbutton2.setOnClickListener(view -> {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Transport", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(newexpense.this,"Success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {Toast.makeText(newexpense.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
            }
            DataBase wee = new DataBase(newexpense.this);
            wee.addOne(ex2);
        });
        sendbutton3.setOnClickListener(view -> {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Groceries", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(newexpense.this,"Success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {Toast.makeText(newexpense.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
            }
            DataBase wee = new DataBase(newexpense.this);
            wee.addOne(ex2);
        });
        sendbutton4.setOnClickListener(view -> {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Clothing", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(newexpense.this,"success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {Toast.makeText(newexpense.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
            }
            DataBase wee = new DataBase(newexpense.this);
            wee.addOne(ex2);
        });
        sendbutton5.setOnClickListener(view -> {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Entertainment", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(newexpense.this,"success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {Toast.makeText(newexpense.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
            }
            DataBase wee = new DataBase(newexpense.this);
            wee.addOne(ex2);
        });
        sendbutton6.setOnClickListener(view -> {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Other", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(newexpense.this,"success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {Toast.makeText(newexpense.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2 = new expensemodel("Food", Integer.parseInt(sendtext.getText().toString().trim()),day,dayno,month,year);
            }
            DataBase wee = new DataBase(newexpense.this);
            wee.addOne(ex2);
        });


        int[] Id = {1};



    }
    public void gh(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

