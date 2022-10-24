package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.Calendar;

public class setgoal extends AppCompatActivity {
    Button send_button;
    EditText send_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setgoal);
    send_button = findViewById(R.id.button3);
    send_text = findViewById(R.id.editTextTextPersonName2);

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

    // add the OnClickListener in sender button
    // after clicked this button following Instruction will run
        send_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            expensemodel ex2 ;
            try {
                ex2 = new expensemodel("Goal", Integer.parseInt(send_text.getText().toString().trim()),day,dayno,month,year);
                Toast.makeText(setgoal.this,"success",Toast.LENGTH_LONG).show();

            }
            catch (Exception e)
            {Toast.makeText(setgoal.this,"ERROR",Toast.LENGTH_LONG).show();
                ex2= null;
            }
            DataBase wee = new DataBase(setgoal.this);
            wee.addOne(ex2);
        }
    });}
    public void onc (View vad){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
    public void gh(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

