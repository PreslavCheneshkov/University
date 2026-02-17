package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView firstNumber, secondNumber, operator, result;
    Button calculateButton, drawButton;

    Intent drawIntent;//, transferInformationIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //transferInformationIntent = new Intent();
        drawIntent = new Intent(this, DrawActivity.class);

        firstNumber = (TextView) findViewById(R.id.operand1);
        secondNumber = (TextView) findViewById(R.id.operand2);
        operator = (TextView) findViewById(R.id.operator);
        result = (TextView) findViewById(R.id.result);

        result.setActivated(false);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        drawButton = (Button) findViewById(R.id.drawButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operation = operator.getText().toString();
                int firstValue = Integer.parseInt(firstNumber.getText().toString());
                int secondValue = Integer.parseInt(secondNumber.getText().toString());
                double operationResult = 0;
                switch (operation) {
                    case "+":
                        operationResult = firstValue + secondValue;
                        break;
                    case "-":
                        operationResult = firstValue - secondValue;
                        break;
                    case "*":
                        operationResult = firstValue * secondValue;
                        break;
                    case "/":
                        operationResult = firstValue / (double)secondValue;
                        break;
                }

                result.setText(Double.toString(operationResult));
            }
        });

        drawButton.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                drawIntent.putExtra("firstValue", firstNumber.getText().toString());
                drawIntent.putExtra("secondValue", secondNumber.getText().toString());
                startActivity(drawIntent);
            }});
    }
}