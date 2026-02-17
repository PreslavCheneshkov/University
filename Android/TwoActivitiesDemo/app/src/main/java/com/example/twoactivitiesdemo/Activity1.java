package com.example.twoactivitiesdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity1 extends AppCompatActivity {

    EditText nameInput, numberInput;
    String nameBuffer; String numberBuffer;
    int numberValue;
    Button nextButton;

    Intent nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nextActivity = new Intent(this, Activity2.class);

        nameInput = (EditText)findViewById(R.id.editText1_1);
        numberInput = (EditText)findViewById(R.id.editText1_2);
        nextButton = (Button)findViewById(R.id.button1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameBuffer = nameInput.getText().toString();
                nextActivity.putExtra("name", nameBuffer);

                numberBuffer = numberInput.getText().toString();
                try {
                    numberValue = Integer.parseInt(numberBuffer);
                } catch (NumberFormatException ex) {
                    numberValue = 0;
                }
                nextActivity.putExtra("number", numberValue);

                startActivity(nextActivity);
            }
        });
    }
}