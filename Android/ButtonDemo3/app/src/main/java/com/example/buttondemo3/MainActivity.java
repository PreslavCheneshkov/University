package com.example.buttondemo3;

import android.graphics.Color;
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

    TextView textView1;
    Button button1;
    Button button2;
    Button button3;

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

        textView1 = (TextView)findViewById(R.id.textView1);
        button1 = (Button)findViewById(R.id.button1);
        //button1.setOnClickListener(this);

        button2 = (Button)findViewById(R.id.button2);
        //button2.setOnClickListener(this);

        button3 = (Button)findViewById(R.id.button3);
        //button3.setOnClickListener(this);
    }

    public void myClick(View v) {
        int sourceId = v.getId();
        int color = 0;
        int buttonNumber = 0;
        String text = "Натиснат бутон ";
        if(sourceId == button1.getId()) {
            color = Color.RED;
            buttonNumber = 1;
        } else if (sourceId == button2.getId()) {
            color = Color.GREEN;
            buttonNumber = 2;
        } else if (sourceId == button3.getId()) {
            color = Color.CYAN;
            buttonNumber = 3;
        }

        textView1.setTextColor(color);
        textView1.setText(text + buttonNumber);
    }
}