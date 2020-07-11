package com.androidproject.GameEdukasiPemahamanAnak;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.AcousticEchoCanceler;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.WindowManager;
import android.widget.ImageButton;


public class ChooseMenu extends AppCompatActivity {


    Button btn_play, btn_about, btn_tutorial, btn_exit;
    TextView tvNama;
    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        tvNama = findViewById(R.id.edt_nama);
        tvNama.setText("Hallo, " + Preferences.getLoggedInUser(getBaseContext()));


        btn_play = (Button) findViewById(R.id.button_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;

                i = new Intent(getApplicationContext(), ChooseQuiz.class);
                startActivity(i);
            }
        });

        btn_about = (Button) findViewById(R.id.button_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;

                i = new Intent(getApplicationContext(), AboutGame.class);
                startActivity(i);
            }
        });

        btn_tutorial = (Button) findViewById(R.id.button_tutorial);
        btn_tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;

                i = new Intent(getApplicationContext(), TutorialGame.class);
                startActivity(i);
            }
        });

        btn_exit = (Button) findViewById(R.id.button_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogConfirm();

            }
        });
    }

    private void dialogConfirm(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(ChooseMenu.this);
        builder.setMessage("Apakah kamu yakin ingin keluar?");
        builder.setCancelable(true);
        builder.setNegativeButton("Ya", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                moveTaskToBack(true);
            }
        });
        builder.setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }

            public void OnClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}


