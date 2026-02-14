package com.example.contextmenudemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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
    public static final int IDM_RESTORE = 201;
    public static final int IDM_PAUSE = 202;
    public static final int IDM_FILE = 100;
    public static final int IDM_EDIT = 300;
    public static final int IDM_CUT = 301;
    public static final int IDM_COPY = 302;
    public static final int IDM_PASTE = 303;

    public static final int IDM_ABOUT = 400;
    public static final int IDM_UPDATE = 500;
    public static final int IDM_HELP = 600;


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

        ConstraintLayout constraintLayout = findViewById(R.id.main);
        registerForContextMenu(constraintLayout);

        textView1 = findViewById(R.id.textView1);
        setSupportActionBar(findViewById(R.id.toolbar1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu submenuFile = menu.addSubMenu("File");

        submenuFile.add(Menu.NONE, IDM_NEW, Menu.NONE, "New");
        submenuFile.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open");
        submenuFile.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save");
        submenuFile.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit");

        SubMenu editSubmenu = menu.addSubMenu("Edit");
        editSubmenu.add(Menu.NONE, IDM_CUT, Menu.NONE, "Cut");
        editSubmenu.add(Menu.NONE, IDM_COPY, Menu.NONE, "Copy");
        editSubmenu.add(Menu.NONE, IDM_PASTE, Menu.NONE, "Paste");

        menu.add(Menu.NONE, IDM_ABOUT, Menu.NONE, "About");
        menu.add(Menu.NONE, IDM_UPDATE, Menu.NONE, "Update");
        menu.add(Menu.NONE, IDM_HELP, Menu.NONE, "Help");

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

            case IDM_CUT: textView1.setText("Избрахте CUT"); break;
            case IDM_COPY: textView1.setText("Избрахте COPY"); break;
            case IDM_PASTE: textView1.setText("Избрахте PASTE"); break;

            case IDM_ABOUT: textView1.setText("Избрахте ABOUT"); break;
            case IDM_UPDATE: textView1.setText("Избрахте UPDATE"); break;
            case IDM_HELP: textView1.setText("Избрахте HELP"); break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info)
    {
        menu.add(Menu.NONE, IDM_PAUSE, Menu.NONE, "Pause");
        menu.add(Menu.NONE, IDM_RESTORE, Menu.NONE, "Restore");
        super.onCreateContextMenu(menu, v, info);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();

        switch (id) {
            case IDM_PAUSE: textView1.setText("Избрахте Pause"); break;
            case IDM_RESTORE: textView1.setText("Избрахте Restore"); break;
        }

        return super.onContextItemSelected(item);
    }
}