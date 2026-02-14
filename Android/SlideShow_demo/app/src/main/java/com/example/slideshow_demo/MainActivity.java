package com.example.slideshow_demo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button _nextButton;
    Button _previousButton;
    ImageView _imageView;

    int[] _imageIDs;

    int _currentImageIndex;

    Dictionary<Integer, String> _animalNames;

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
        _currentImageIndex = 0;
        _nextButton = findViewById(R.id.nextButton);
        _previousButton = findViewById(R.id.previousButton);
        _imageView = findViewById(R.id.imageView);

        _imageIDs = new int[] {
                R.drawable.bear,
                R.drawable.elephant,
                R.drawable.monkey,
                R.drawable.panda,
                R.drawable.zebra,
                R.drawable.tiger,
                R.drawable.doe,
                R.drawable.kangaroo,
        };

        _imageView.setImageResource(_imageIDs[_currentImageIndex]);

        _nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_currentImageIndex < _imageIDs.length - 1) {
                    _currentImageIndex++;
                }
                else {
                    _currentImageIndex = 0;
                }
                _imageView.setImageResource(_imageIDs[_currentImageIndex]);
            }
        });

        _previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_currentImageIndex > 0){
                    _currentImageIndex--;
                }
                else {
                    _currentImageIndex = _imageIDs.length - 1;
                }
                _imageView.setImageResource(_imageIDs[_currentImageIndex]);
            }
        });
    }
}