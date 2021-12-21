package com.appsmor.restapirizaluardi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button alamat,kontak,instansi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        alamat = (Button) findViewById(R.id.keAlamat);
        alamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MainActivityAlamat.class));
            }
        });

        kontak = (Button) findViewById(R.id.keKontak);
        kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });

        instansi = (Button) findViewById(R.id.keInstansi);
        instansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MainActivityInstansi.class));
            }
        });

    }
}