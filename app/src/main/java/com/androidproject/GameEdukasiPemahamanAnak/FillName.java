package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FillName extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNamaKamu;

    private Button btnMasuk;

    MediaPlayer sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_name);

        sound = MediaPlayer.create(getBaseContext(),R.raw.backsound);
        sound.start();
        sound.setLooping(true);


        edtNamaKamu = findViewById(R.id.edt_nama);
        btnMasuk = findViewById(R.id.button_masuk);
        btnMasuk.setOnClickListener(this);

    }


    private void ambilNama(){

        String nama = String.valueOf(edtNamaKamu.getText());
        Preferences.setLoggedInUser(getBaseContext(),nama);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_masuk:
                ambilNama();
                Intent intent = new Intent(FillName.this, ChooseMenu.class);
                startActivity(intent);
                break;
        }
    }
}
