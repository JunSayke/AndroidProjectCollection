package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ButtonExercise extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4, btn5, btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        btn1 = (Button) findViewById(R.id.btnButton1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ButtonExercise.this, ButtonOne.class);
                startActivity(intent1);
            }
        });

        btn2 = (Button) findViewById(R.id.btnButton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Toast is Working!" , Toast.LENGTH_LONG ).show();
            }
        });

        btn3 = (Button) findViewById(R.id.btnButton3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setVisibility(View.INVISIBLE);
            }
        });

        btn4 = (Button) findViewById(R.id.btnButton4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://ph.linkedin.com/in/von-godinez-8aa349114");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn5 = (Button) findViewById(R.id.btnButton5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.Screen).setBackgroundColor(randomColor());
            }
        });

        btn6 = (Button) findViewById(R.id.btnButton6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6.setBackgroundColor(randomColor());
            }
        });
    }

    private int randomColor() {
        Random random = new Random();

        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}