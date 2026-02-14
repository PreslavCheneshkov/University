package com.example.menudemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar1;
    TextView textView1;

    public static final int IDM_NEW = 101;
    public static final int IDM_OPEN = 102;
    public static final int IDM_SAVE = 103;
    public static final int IDM_EXIT = 104;

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
        setSupportActionBar(findViewById(R.id.toolbar1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_NEW, Menu.NONE, "New").setIcon(getDrawable(R.drawable.new2));
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open").setIcon(R.drawable.open2);
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save").setIcon(R.drawable.save);
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit").setIcon(R.drawable.exit2);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id) {
            case IDM_NEW: textView1.setText("Избрахте NEW"); break;
            case IDM_OPEN: textView1.setText("Избрахте OPEN"); break;
            case IDM_SAVE: textView1.setText("Избрахте SAVE"); break;
            case IDM_EXIT: textView1.setText("Избрахте EXIT"); break;
        }

        return super.onOptionsItemSelected(item);
    }

}