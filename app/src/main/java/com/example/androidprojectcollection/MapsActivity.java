package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MapsActivity extends AppCompatActivity {
    FrameLayout layoutBackground;
    LinearLayout layoutMaps;
    ImageButton btnAkihabara, btnBoracay, btnPalawan, btnBaguio, btnEiffelTower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        layoutBackground = findViewById(R.id.layoutBackground);
        layoutMaps = findViewById(R.id.layoutMaps);

        btnAkihabara = findViewById(R.id.btnAkihabara);
        btnAkihabara.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.702210, 139.774145")));
            layoutBackground.setBackground(btnAkihabara.getDrawable());
            layoutMaps.setVisibility(View.GONE);
        });

        btnBoracay = findViewById(R.id.btnBoracay);
        btnBoracay.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.940653, 121.939211")));
            layoutBackground.setBackground(btnBoracay.getDrawable());
            layoutMaps.setVisibility(View.GONE);
        });

        btnPalawan = findViewById(R.id.btnPalawan);
        btnPalawan.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.069128, 120.157512")));
            layoutBackground.setBackground(btnPalawan.getDrawable());
            layoutMaps.setVisibility(View.GONE);
        });

        btnBaguio = findViewById(R.id.btnBaguio);
        btnBaguio.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:16.410045, 120.593598")));
            layoutBackground.setBackground(btnBaguio.getDrawable());
            layoutMaps.setVisibility(View.GONE);
        });

        btnEiffelTower = findViewById(R.id.btnEiffelTower);
        btnEiffelTower.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:48.857811, 2.295180")));
            layoutBackground.setBackground(btnEiffelTower.getDrawable());
            layoutMaps.setVisibility(View.GONE);
        });
    }
}