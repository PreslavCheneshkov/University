package com.example.twoactivitiesdemo;

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

public class Activity2 extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button buttonBack;

    Intent backActivity, takeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backActivity = new Intent(this, Activity1.class);
        takeActivity = getIntent();

        textView1 = findViewById(R.id.textView2_1);
        textView2 = findViewById(R.id.textView2_2);
        buttonBack = findViewById(R.id.button2_1);

        textView1.setText("name: " + takeActivity.getStringExtra("name"));
        textView2.setText("number: " + takeActivity.getIntExtra("number", 0));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backActivity);
            }
        });
    }
}