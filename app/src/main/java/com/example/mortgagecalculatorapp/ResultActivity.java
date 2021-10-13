package com.example.mortgagecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    //TextView widget
    private TextView ans_text;
    public static String mortgage = "mortgage";
    //Button widget
    private Button b_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        b_button = findViewById(R.id.back_button);

        b_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ans_text = findViewById(R.id.answer_text);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra(mortgage, 0);
        ans_text.setText(String.format("%.3f", result));
    }
}