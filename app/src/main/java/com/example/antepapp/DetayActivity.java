package com.example.antepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetayActivity extends AppCompatActivity {
    private ImageView imageViewDetay;
    private TextView textViewIsim;
    private TextView textViewAciklama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        imageViewDetay = findViewById(R.id.imageViewDetay);
        textViewIsim = findViewById(R.id.textViewIsim);
        textViewAciklama = findViewById(R.id.textViewAciklama);

        Intent intent = getIntent();
        if (intent != null) {
            String isim = intent.getStringExtra("isim");
            String fotourl = intent.getStringExtra("fotourl");
            String aciklama = intent.getStringExtra("aciklama");

            textViewIsim.setText(isim);
            textViewAciklama.setText(aciklama);
            Picasso.get().load(fotourl).into(imageViewDetay);
        }
    }
}