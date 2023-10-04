package com.example.mortgageassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MortgageResults extends AppCompatActivity {
    private TextView x_emi;
    private TextView x_tenure;
    private TextView x_loanAmount;
    private TextView x_interestPayable;
    private TextView x_totalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_results);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.viridian));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.viridian));
        }

        x_emi = (TextView)findViewById(R.id.EMI);
        x_tenure = (TextView)findViewById(R.id.tenure);
        x_loanAmount = (TextView)findViewById(R.id.loanAmount);
        x_interestPayable = (TextView)findViewById(R.id.intPayable);
        x_totalPayment = (TextView)findViewById(R.id.totalPayable);

        double emi1 = getIntent().getDoubleExtra("x_emi", 0.0);
        int tenure1 = getIntent().getIntExtra("x_tenure", 0);
        double loan = getIntent().getDoubleExtra("x_loanAmount", 0.0);
        double interest = getIntent().getDoubleExtra("x_interestPayable", 0.0);
        double total = getIntent().getDoubleExtra("x_totalPayment", 0.0);

        x_emi.setText(String.valueOf(emi1));
        x_tenure.setText(String.valueOf(tenure1));
        x_loanAmount.setText(String.valueOf(loan));
        x_interestPayable.setText(String.valueOf(interest));
        x_totalPayment.setText(String.valueOf(total));
    }



}