package com.example.expensea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.LegendModel;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {
    TextView receiver_msg;
    TextView receiver_msg1;
    PieChart mp;
    PieChart sp;
    int oldValue;
    int oldValue2;
    int oldValue3;
    int oldValue4;
    DataBase dab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        receiver_msg = findViewById(R.id.t4);
        receiver_msg1 = findViewById(R.id.t3);
        mp = findViewById(R.id.pie);
        sp = findViewById(R.id.smallpie);


        changeTextViewValueRandomlyOnButtonClick();
        DataBase damb = new DataBase(MainActivity.this);


        mp.addPieSlice(new PieModel("Food", damb.getfood(), Color.parseColor("#1D3D52")));
        mp.addPieSlice(new PieModel("Transport", damb.gettrans(), Color.parseColor("#51ADC6")));
        mp.addPieSlice(new PieModel("Groceries", damb.getgross(), Color.parseColor("#174576")));
        mp.addPieSlice(new PieModel("Clothing", damb.getcloth(), Color.parseColor("#1466BA")));
        mp.addPieSlice(new PieModel("Entertainment", damb.getenter(), Color.parseColor("#66D6EA")));
        mp.addPieSlice(new PieModel("Other", damb.getother(), Color.parseColor("#3E849E")));

        receiver_msg1.setText(String.valueOf(damb.getall()));
        sp.addPieSlice(new PieModel("Spent", damb.getall(), Color.parseColor("#4B9F36")));

        receiver_msg.setText(String.valueOf(damb.getgoal()));
        sp.addPieSlice(new PieModel("Goal", damb.getgoal(), Color.parseColor("#C93232")));



    }
    private void changeTextViewValueRandomlyOnButtonClick() {
        final String[] manyDifferentStrings = {"Firstly cover for life's risk", "Start saving now", "No matter how small", "Check your account statements", "Categorize your expenses.", "Explore other expense trackers.", "Identify room for change.", "Record the costs", "claim the proportion of your costs", "Create a Financial Calendar", "Check Your Interest Rate", "Track Your Net Worth", "Set a Budget, Period", "Consider an All-Cash Diet", "Take a Daily Money Minute", "Allocate at Least 20% of Your Income Toward Financial Priorities", "Budget About 30% of Your Income for Lifestyle Spending", "Draft a Financial Vision Board", "Set Specific Financial Goal", "Adopt a Spending Mantra", "Love Yourself", "Make Bite-Size Money Goals", "Banish Toxic Money Thoughts", "Get Your Finances–and Body—in Shape", "Learn How to Savor", "Get a Money Buddy", "When Negotiating a Salary, Get the Company to Name Figures First", "You Can Negotiate More Than Just Your Salary", "Consider Switching to a Credit Union", "There Are 5 Types of Financial Emergencies", "You Can Have Too Much Savings", "Pay Attention to Fees", "Rebalance Your Portfolio Once a Year"};
        final String[] manyDifferentStrings2 = {"Don’t Assume You Don’t Qualify for Unemployment", "Make Salary Discussions at Your Current Job About Your Company’s Needs", "Start With Small Debts to Help You Conquer the Big Ones", "Don’t Ever Cosign a Loan", "Every Student Should Fill Out the FAFSA", "Always Choose Federal Student Loans Over Private Loans", "If You’re Struggling With Federal Student Loan Payments, Investigate Repayment Options", "Opt for Mortgage Payments Below 28% of Your Monthly Income", "Evaluate Purchases by Cost Per Use", "Spend on Experiences, Not Things", "Shop Solo", "Spend on the Real You—Not the Imaginary You", "Ditch the Overdraft Protection", "Start Saving ASAP", "Do Everything Possible Not to Cash Out Your Retirement Account Early", "Give Money to Get Money", "When You Get a Raise, Raise Your Retirement Savings, Too", "Review Your Credit Report Regularly—and Keep an Eye on Your Credit Score", "Keep Your Credit Use Below 30% of Your Total Available Credit", "If You Have Bad Credit, Get a Secured Credit Card", "Get More Life Insurance on Top of Your Company’s Policy", "Make Savings Part of Your Monthly Budget", "Keep Your Savings Out of Your Checking Account", "Open a Savings Account at a Different Bank Than Where You Have Your Checking Account", "Direct Deposit is (Almost) Magic"};
        final String[] manyDifferentStrings3 = {"Firstly cover for life's risk", "Start saving now", "No matter how small", "Check your account statements", "Categorize your expenses.", "Explore other expense trackers.", "Identify room for change.", "Record the costs", "claim the proportion of your costs", "Create a Financial Calendar", "Check Your Interest Rate", "Track Your Net Worth", "Set a Budget, Period", "Consider an All-Cash Diet", "Take a Daily Money Minute", "Allocate at Least 20% of Your Income Toward Financial Priorities", "Budget About 30% of Your Income for Lifestyle Spending", "Draft a Financial Vision Board", "Set Specific Financial Goal", "Adopt a Spending Mantra", "Love Yourself", "Make Bite-Size Money Goals", "Banish Toxic Money Thoughts", "Get Your Finances–and Body—in Shape", "Learn How to Savor", "Get a Money Buddy", "When Negotiating a Salary, Get the Company to Name Figures First", "You Can Negotiate More Than Just Your Salary", "Consider Switching to a Credit Union", "There Are 5 Types of Financial Emergencies", "You Can Have Too Much Savings", "Pay Attention to Fees", "Rebalance Your Portfolio Once a Year"};
        final String[] manyDifferentStrings4 = {"Don’t Assume You Don’t Qualify for Unemployment", "Make Salary Discussions at Your Current Job About Your Company’s Needs", "Start With Small Debts to Help You Conquer the Big Ones", "Don’t Ever Cosign a Loan", "Every Student Should Fill Out the FAFSA", "Always Choose Federal Student Loans Over Private Loans", "If You’re Struggling With Federal Student Loan Payments, Investigate Repayment Options", "Opt for Mortgage Payments Below 28% of Your Monthly Income", "Evaluate Purchases by Cost Per Use", "Spend on Experiences, Not Things", "Shop Solo", "Spend on the Real You—Not the Imaginary You", "Ditch the Overdraft Protection", "Start Saving ASAP", "Do Everything Possible Not to Cash Out Your Retirement Account Early", "Give Money to Get Money", "When You Get a Raise, Raise Your Retirement Savings, Too", "Review Your Credit Report Regularly—and Keep an Eye on Your Credit Score", "Keep Your Credit Use Below 30% of Your Total Available Credit", "If You Have Bad Credit, Get a Secured Credit Card", "Get More Life Insurance on Top of Your Company’s Policy", "Make Savings Part of Your Monthly Budget", "Keep Your Savings Out of Your Checking Account", "Open a Savings Account at a Different Bank Than Where You Have Your Checking Account", "Direct Deposit is (Almost) Magic"};

        final TextView changingText = (TextView) findViewById(R.id.text_to_change);
        final TextView changingText2 = (TextView) findViewById(R.id.text_to_change2);
        final TextView changingText3 = (TextView) findViewById(R.id.text_to_change3);
        final TextView changingText4 = (TextView) findViewById(R.id.text_to_change4);
        Button changeTextButton = (Button) findViewById(R.id.refresh);


        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * manyDifferentStrings.length);
                int random2 = (int) (Math.random() * manyDifferentStrings2.length);
                int random3 = (int) (Math.random() * manyDifferentStrings3.length);
                int random4 = (int) (Math.random() * manyDifferentStrings4.length);
                if (random == oldValue && random == oldValue2) {
                    random = (int) (Math.random() * manyDifferentStrings.length);
                    random2 = (int) (Math.random() * manyDifferentStrings2.length);
                }
                changingText.setText(manyDifferentStrings[random]);
                changingText2.setText(manyDifferentStrings2[random2]);
                if (random3 == oldValue3) { `random3 = (int) (Math.random() * manyDifferentStrings3.length);
                    random4 = (int) (Math.random() * manyDifferentStrings4.length);
                }
                changingText3.setText(manyDifferentStrings3[random3]);
                changingText4.setText(manyDifferentStrings4[random4]);
                oldValue = random;
                oldValue2 = random2;
                oldValue3 = random3;
                oldValue4 = random4;
            }
     });
        q
    }
    public void ha(View v) {
        Intent intent = new Intent(this, setgoal.class);
        startActivity(intent);
    }

    public void ba(View v) {
        Intent intent = new Intent(this, newexpense.class);
        startActivity(intent);
    }

    public void ga(View v) {
        Intent intent = new Intent(this, insights.class);
        startActivity(intent);
    }

    public void mt(View v) {
        Intent intent = new Intent(this, meettheteam.class);
        startActivity(intent);
    }
    public void bs(View v) {
        Intent intent = new Intent(this, bills.class);
        startActivity(intent);
    }
    public void tb(View v) {
            Intent intent = new Intent(this, travel.class);
            startActivity(intent);
    }
    public void clr(View v) {
        DataBase damn = new DataBase(MainActivity.this);
        damn.deleteall(this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
