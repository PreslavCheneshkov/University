package com.example.picturedemo3pictures;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.picturedemo3pictures2.R;
//import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1; ImageView iv1; Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.textView1);
        iv1=(ImageView) findViewById(R.id.imageView1);
        btn1=(Button) findViewById(R.id.button1);btn1.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.button2);btn2.setOnClickListener(this);
        btn3=(Button) findViewById(R.id.button3);btn3.setOnClickListener(this);
        btn4=(Button) findViewById(R.id.button4);btn4.setOnClickListener(this);
        iv1.setImageResource(R.drawable.pingvin);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1){
            iv1.setImageResource(R.drawable.super_mario);tv1.setText(getResources().getString(R.string.mario));
            tv1.setTextColor(getResources().getColor(R.color.myBlue,null));
        }
        if (v.getId()==R.id.button2) {
            tv1.setTextColor(Color.CYAN);tv1.setText("Натиснат бутон_2 - URL - load from Internet");
            Bitmap bmp = null;
            String imageURL="http://valveliko.com/pictures_2_tn/some_places/val12b.jpg";
            URL url = null;
            //Зареждането на картинка е асинхронен процес. Трябва да е или в отделна нишка,
            //или да се организира изчакване (чрез "подтискане"):
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            // URL url = new URL(imageURL);
            // Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            //iv1.setImageBitmap(bmp);

            try {
                url = new URL(imageURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println("MalformedURLException");
            }

            try {
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

            } catch (NetworkOnMainThreadException ex){
                System.out.println("NetworkOnMainThreadException...");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException");
            }

            iv1.setImageBitmap(bmp);
        }
        //if (v.getId()==R.id.button3){
        //    tv1.setText("Натиснат бутон Picasso - load using Picasso");
        //    tv1.setTextColor(getResources().getColor(R.color.myGreen,null));
        //    /*
        //    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //    StrictMode.setThreadPolicy(policy);
        //    Няма нужда от тази рестрикция, защото в Manifest има настройка за интернет
//*///
        //    String imageURL="http://valveliko.com/pictures_2_tn/some_places/temza1.JPG";
        //    //String imageURL="E://me4kata.jpg";
//
        //    try {
        //        Context context=getApplicationContext();
        //        Picasso.with(context)
        //                //Picasso.get()
        //                .load(imageURL)
        //                //  .resize(width,height)
        //                .noFade()
        //                .into(iv1);
        //        System.out.println("Picasso - успех");
        //    }catch (Exception ex) {
        //        System.out.println("Picasso - неуспех");
        //    }
//
        //}

        if (v.getId()==R.id.button4) {
            tv1.setText("Натиснат бутон SD_CARD");
            tv1.setTextColor(getResources().getColor(R.color.myRed, null));
            File imageFile;
            try {
// !!! Да се добави тази проверка:
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    },1);

                }

                imageFile = new File("/mnt/sdcard/Pictures/67310.jpg");
                if (imageFile.exists()) {
                    System.out.println("Файлът съществува");
                    // BitmapDrawable bitmap=new BitmapDrawable(getResources(),imageFile.getAbsolutePath());
                    //iv1.setImageDrawable(bitmap);

                    Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                    System.out.println("Файлът декодиран");
                    iv1.setImageBitmap(bitmap);
                    System.out.println("след iv1.setImageBitmap(bitmap);");
                } else System.out.println("Файлът НЕ съществува");
            }catch (Exception ex){
                System.out.println("Неуспех при отваряне на файла...");
            }

        }
    }

//  !!!Да се добави тази функция!!!
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){

            }
            else{
                Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
            }
        }
    }
}