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
import android.widget.TextView;

public class MapsActivity extends AppCompatActivity {
    LinearLayout layoutBackground;
    LinearLayout layoutMaps;
    TextView tvMapIndicator;
    ImageButton btnAkihabara, btnBoracay, btnPalawan, btnBaguio, btnEiffelTower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        layoutBackground = findViewById(R.id.layoutBackground);
        layoutMaps = findViewById(R.id.layoutMaps);
        tvMapIndicator = findViewById(R.id.tvMapIndicator);

        btnAkihabara = findViewById(R.id.btnAkihabara);
        btnAkihabara.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.702210, 139.774145")));
            layoutBackground.setBackgroundResource(R.drawable.akihabaraview);
            tvMapIndicator.setText("Akihabara Japan");
        });

        btnBoracay = findViewById(R.id.btnBoracay);
        btnBoracay.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.940653, 121.939211")));
            layoutBackground.setBackgroundResource(R.drawable.boracayview);
            tvMapIndicator.setText("Boracay Philippines");
        });

        btnPalawan = findViewById(R.id.btnPalawan);
        btnPalawan.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.069128, 120.157512")));
            layoutBackground.setBackgroundResource(R.drawable.palawanview);
            tvMapIndicator.setText("Palawan Philippines");
        });

        btnBaguio = findViewById(R.id.btnBaguio);
        btnBaguio.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:16.410045, 120.593598")));
            layoutBackground.setBackgroundResource(R.drawable.baguioview);
            tvMapIndicator.setText("Baguio Philippines");
        });

        btnEiffelTower = findViewById(R.id.btnEiffelTower);
        btnEiffelTower.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:48.857811, 2.295180")));
            layoutBackground.setBackgroundResource(R.drawable.eiffeltowerview);
            tvMapIndicator.setText("Eiffel Tower France");
        });
    }
}