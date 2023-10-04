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

public class MainActivity extends AppCompatActivity {

    private EditText principalAmount;
    private EditText interest;
    private EditText inYear;
    private EditText inMonth;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalAmount = (EditText)findViewById(R.id.principalAmount);
        interest = (EditText)findViewById(R.id.interest);
        inYear = (EditText)findViewById(R.id.year);
        inMonth = (EditText)findViewById(R.id.month);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.viridian));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.viridian));
        }


        Button loanSummaryButton = findViewById(R.id.buttonTotal);
        loanSummaryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                calculate(view);
            }
        });
    }

//            Button clearButton = findViewById(R.id.buttonClear);



            public void calculate(View view) {
                try {
                    double M_principalAmount = Double.parseDouble(principalAmount.getText().toString());
                    double M_interest = Double.parseDouble(interest.getText().toString());
                    int M_year = Integer.parseInt(inYear.getText().toString());
                    int M_month = Integer.parseInt(inMonth.getText().toString());

                    int yearExchange = (M_year * 12) + M_month;
                    double principal = M_principalAmount * (M_interest / 100);
                    double power = Math.pow(M_interest / 100 + 1, yearExchange);
                    double sum = principal / (1 - (1 / power));

                    double TotalInterest = sum * yearExchange - M_principalAmount;
                    double TotalPayment = M_principalAmount + TotalInterest;

                    Intent i = new Intent(this, MortgageResults.class);
                    i.putExtra("x_emi", sum);
                    i.putExtra("x_tenure", yearExchange);
                    i.putExtra("x_loanAmount", M_principalAmount);
                    i.putExtra("x_interestPayable", TotalInterest);
                    i.putExtra("x_totalPayment", TotalPayment);

                    startActivity(i);



                } catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Please enter a valid numeric value. Enter 0 when applicable.", Toast.LENGTH_SHORT).show();
                }


            }

//        clearButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                principalAmount.setText("");
//                interest.setText("");
//                inYear.setText("");
//                inMonth.setText("");
//
//
//            }
//        });
    }
