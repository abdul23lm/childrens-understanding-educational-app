package com.androidproject.GameEdukasiPemahamanAnak;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class TutorialGame extends AppCompatActivity {

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_game);

    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){

            Intent intent = new Intent(TutorialGame.this, ChooseMenu.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Tekan lagi untuk kembali", Toast.LENGTH_SHORT).show();

        }
        backPressedTime = System.currentTimeMillis();
    }
}