package com.example.mortgagecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //EditText widgets
    private EditText input_amount;
    private EditText input_years;
    private EditText input_interest;
    //TextView widget
    private TextView ans_text;
    //Button widget
    private Button calc_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* matching the variables with their appropriate
        IDs defined in the layout file */
        input_amount = findViewById(R.id.amount_box);
        input_years = findViewById(R.id.years_box);
        input_interest = findViewById(R.id.interest_box);

        ans_text = findViewById(R.id.answer_text);
        calc_button = findViewById(R.id.calculate_button);

        //OnClickListener handles action for when the button is clicked
        calc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcMortgage();
            }
        });
    }

    /* function calculates the mortgage payment and starts an intent that passes the result
    value to the Result Activity */
    public void calcMortgage() {
        //P holds mortgage principle amount
        double P = Double.parseDouble(input_amount.getText().toString());
        //r holds the interest rate in percent
        double r = ((Double.parseDouble(input_interest.getText().toString()) /100) /12);
        // n holds the amortization period in years
        int n = Integer.parseInt(input_years.getText().toString()) * 12;
        double x = Math.pow((1+r),n);
        //final result
        Double M = P*((r*x)/(x-1));
        //Intent created to pass value from the MainActivity to ResultActivity
        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra(ResultActivity.mortgage, M);
        startActivity(intent);
    }
}