package com.example.helloworld2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    TextView textView1;
    Button buttonOK;
    Button buttonCancel;

    CheckBox maleGender;
    CheckBox femaleGender;
    CheckBox customGender;

    RadioGroup radioGroup;
    RadioButton radioGreen;
    RadioButton radioBlue;
    RadioButton radioBlack;
    RadioButton radioBrown;

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

        textView1 = findViewById(R.id.textView1);
        buttonOK = findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(this);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);

        maleGender = findViewById(R.id.checkBoxMale);
        maleGender.setOnCheckedChangeListener(this);

        femaleGender = findViewById(R.id.checkBoxFemale);
        femaleGender.setOnCheckedChangeListener(this);

        customGender = findViewById(R.id.checkBoxCustom);
        customGender.setOnCheckedChangeListener(this);

        radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(this);

        radioGreen = findViewById(R.id.radioGreen);

        radioBlue = findViewById(R.id.radioBlue);

        radioBlack = findViewById(R.id.radioBlack);

        radioBrown = findViewById(R.id.radioBrown);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCancel)
            textView1.setText("Натиснат бутон 'Cancel'");
        if (v.getId() == R.id.buttonOK)
            textView1.setText("Натиснат бутон 'ОК");
    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        if (group.getId() == radioGroup.getId() && radioGreen.isChecked())
            textView1.setText("Очи --> ЗЕЛЕНИ");

        if (group.getId() == radioGroup.getId() && radioBlue.isChecked())
            textView1.setText("Очи --> СИНИ");

        if (group.getId() == radioGroup.getId() && radioBlack.isChecked())
            textView1.setText("Очи --> ЧЕРНИ");

        if (group.getId() == radioGroup.getId() && radioBrown.isChecked())
            textView1.setText("Очи --> КАФЯВИ");
    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == maleGender.getId() && isChecked)
            textView1.setText("МЪЖ --> ON");
        if (buttonView.getId() == maleGender.getId() && !isChecked)
            textView1.setText("МЪЖ --> OFF");

        if (buttonView.getId() == femaleGender.getId() && isChecked)
            textView1.setText("ЖЕНА --> ON");
        if (buttonView.getId() == femaleGender.getId() && !isChecked)
            textView1.setText("ЖЕНА --> OFF");

        if (buttonView.getId() == customGender.getId() && isChecked)
            textView1.setText("CustomGender --> ON");
        if (buttonView.getId() == customGender.getId() && !isChecked)
            textView1.setText("CustomGender --> OFF");
    }
}