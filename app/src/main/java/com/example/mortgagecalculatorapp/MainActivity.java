package com.example.mortgagecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

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

        input_amount = findViewById(R.id.amount_box);
        input_years = findViewById(R.id.years_box);
        input_interest = findViewById(R.id.interest_box);

        ans_text = findViewById(R.id.answer_text);
        calc_button = findViewById(R.id.calculate_button);

        calc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double P = Double.parseDouble(input_amount.getText().toString());
                double r = ((Double.parseDouble(input_interest.getText().toString()) /100) /12);
                int n = Integer.parseInt(input_years.getText().toString()) * 12;
                double x = Math.pow((1+r),n);
                Double M = P*((r*x)/(x-1));
                ans_text.setText(String.format("%.1f",M));
            }
        });
    }








}