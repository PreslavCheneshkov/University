package com.example.coursework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DrawActivity extends AppCompatActivity {

    ImageView imageView;
    Intent transferInfoIntent;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_draw);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        transferInfoIntent = getIntent();
        int firstNumber = Integer.parseInt(transferInfoIntent.getStringExtra("firstValue"));
        int secondNumber = Integer.parseInt(transferInfoIntent.getStringExtra("secondValue"));

        imageView = findViewById(R.id.imageView1);
        Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imageView.setImageBitmap(bitmap);


        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);

        int cx = 400;
        int cy = 600;

        canvas.drawCircle(cx, cy, firstNumber * 2 * 11, paint);

        if (secondNumber < firstNumber) {
            paint.setColor(Color.RED);

            int rectSide = secondNumber * 11;
            int rectLeft = cx - rectSide;
            int rectTop = cy - rectSide;
            int rectRight = cx + rectSide;
            int rectBottom = cy + rectSide;

            canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paint);
        }

        imageView.draw(canvas);

        backButton = (Button) findViewById(R.id.backButton);

        Intent mainIntent = new Intent(this, MainActivity.class);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainIntent);
            }
        });
    }
}