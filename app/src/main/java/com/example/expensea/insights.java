package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

public class insights extends AppCompatActivity {
    BarChart bar1;
    BarChart bar2;
    BarChart bar3;
    TextView receivermsg1;
    TextView receivermsg2;
    TextView receivermsg3;
    TextView receivermsg4;
    TextView receivermsg5;
    TextView receivermsg6;

    TextView receivermsgg1;
    TextView receivermsgg2;
    TextView receivermsgg3;
    TextView receivermsgg4;
    TextView receivermsgg5;
    TextView receivermsgg6;

    TextView receivermsggg1;
    TextView receivermsggg2;
    TextView receivermsggg3;
    TextView receivermsggg4;
    TextView receivermsggg5;
    TextView receivermsggg6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);
        bar1 = findViewById(R.id.daily);
        bar2 = findViewById(R.id.weekly);
        bar3 = findViewById(R.id.monthly);

        DataBase dave = new DataBase(insights.this);

        bar1.addBar(new BarModel(dave.getfood(), 0xFF563456));
        bar1.addBar(new BarModel(dave.gettrans(), 0xFF873F56));
        bar1.addBar(new BarModel(dave.getgross(), 0xFF56B7F1));
        bar1.addBar(new BarModel(dave.getcloth(), 0xFF343456));
        bar1.addBar(new BarModel(dave.getenter(), 0xFF1FF4AC));
        bar1.addBar(new BarModel(dave.getother(), 0xFF1BA4E6));


        bar2.addBar(new BarModel(dave.getmon(),0xFF563456));
        bar2.addBar(new BarModel(dave.gettue(), 0xFF873F56));
        bar2.addBar(new BarModel(dave.getwed(), 0xFF56B7F1));
        bar2.addBar(new BarModel(dave.getthur(), 0xFF343456));
        bar2.addBar(new BarModel(dave.getfri(), 0xFF1FF4AC));
        bar2.addBar(new BarModel(dave.getsat(), 0xFF1BA4B6));
        bar2.addBar(new BarModel(dave.getsun(), 0xFF1BA4E6));


        bar3.addBar(new BarModel(dave.getmonth1(), 0xFF563456));
        bar3.addBar(new BarModel(dave.getmonth2(), 0xFF873F56));
        bar3.addBar(new BarModel(dave.getmonth3(), 0xFF56B7F1));
        bar3.addBar(new BarModel(dave.getmonth4(), 0xFF343456));


        bar1.startAnimation();
        bar2.startAnimation();
        bar3.startAnimation();

        receivermsg1=findViewById(R.id.num1);
        receivermsg2=findViewById(R.id.num2);
        receivermsg3=findViewById(R.id.num3);
        receivermsg4=findViewById(R.id.num4);
        receivermsg5=findViewById(R.id.num5);
        receivermsg6=findViewById(R.id.num6);

        receivermsgg1=findViewById(R.id.numm1);
        receivermsgg2=findViewById(R.id.numm2);
        receivermsgg3=findViewById(R.id.numm3);
        receivermsgg4=findViewById(R.id.numm4);
        receivermsgg5=findViewById(R.id.numm5);
        receivermsgg6=findViewById(R.id.numm6);

        receivermsggg1=findViewById(R.id.nummm1);
        receivermsggg2=findViewById(R.id.nummm2);
        receivermsggg3=findViewById(R.id.nummm3);
        receivermsggg4=findViewById(R.id.nummm4);
        receivermsggg5=findViewById(R.id.nummm5);
        receivermsggg6=findViewById(R.id.nummm6);


        receivermsg1.setText(String.valueOf(dave.getfood()));
        receivermsg2.setText(String.valueOf(dave.gettrans()));
        receivermsg3.setText(String.valueOf(dave.getgross()));
        receivermsg4.setText(String.valueOf(dave.getcloth()));
        receivermsg5.setText(String.valueOf(dave.getenter()));
        receivermsg6.setText(String.valueOf(dave.getother()));

        receivermsgg1.setText(String.valueOf(dave.getfoodweek()));
        receivermsgg2.setText(String.valueOf(dave.gettransweek()));
        receivermsgg3.setText(String.valueOf(dave.getgrossweek()));
        receivermsgg4.setText(String.valueOf(dave.getclothweek()));
        receivermsgg5.setText(String.valueOf(dave.getenterweek()));
        receivermsgg6.setText(String.valueOf(dave.getotherweek()));

        receivermsggg1.setText(String.valueOf(dave.getfoodmonth()));
        receivermsggg2.setText(String.valueOf(dave.gettransmonth()));
        receivermsggg3.setText(String.valueOf(dave.getgrossmonth()));
        receivermsggg4.setText(String.valueOf(dave.getclothmonth()));
        receivermsggg5.setText(String.valueOf(dave.getentermonth()));
        receivermsggg6.setText(String.valueOf(dave.getothermonth()));



    }
    public void gh(View v)
        {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        }

    }

