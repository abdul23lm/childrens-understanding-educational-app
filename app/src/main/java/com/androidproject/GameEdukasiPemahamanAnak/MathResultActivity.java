package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//Ini logika halaman hasil

public class MathResultActivity extends AppCompatActivity {

    TextView txtHighScore;
    TextView txtCorrectQues,txtWrongQues,txtBriliancy;

    Button btStartQuiz;
    Button btMainMenu;

    private int highScore;
    public static final String SHARED_PREFERRENCE = "shread_prefrence";
    public static final String SHARED_PREFERRENCE_HIGH_SCORE = "shread_prefrence_high_score";

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_result);


        btMainMenu = findViewById(R.id.result_bt_mainmenu);
        btStartQuiz = findViewById(R.id.result_bt_playAgain);
        txtHighScore = findViewById(R.id.result_text_High_Score);
        txtCorrectQues = findViewById(R.id.result_Correct_Ques);
        txtWrongQues = findViewById(R.id.result_Wrong_Ques);
        txtBriliancy = findViewById(R.id.result_briliancy);


        btMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MathResultActivity.this,ChooseMenu.class);
                startActivity(intent);

            }
        });

        btStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MathResultActivity.this, MathQuiz.class);
                startActivity(intent);
            }
        });


        loadHighScore();

        Intent intent = getIntent();

        int score = intent.getIntExtra("UserScore",0);
        int correctQues = intent.getIntExtra("CorrectQues",0);
        int wrongQues = intent.getIntExtra("WrongQues",0);

        setText(score);
        txtCorrectQues.setText("Benar: " + String.valueOf(correctQues));
        txtWrongQues.setText("Salah: " + String.valueOf(wrongQues));



        if (score > highScore){

            updatHighScore(score);
        }


    }


    private void updatHighScore(int newHighScore) {

        highScore = newHighScore;
        txtHighScore.setText(" " + String.valueOf(highScore));


    }
//
    private void loadHighScore() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE,MODE_PRIVATE);
        highScore = sharedPreferences.getInt(SHARED_PREFERRENCE_HIGH_SCORE,0);
        txtHighScore.setText(" " + String.valueOf(highScore));

    }

    private void setText(int s){

        if(s > 80) {
            txtBriliancy.setText("Wah Kamu Pintar\uD83E\uDD17");
        }
        else if (s > 50) {
            txtBriliancy.setText("Ayo Tingkatkan Lagi\uD83D\uDE09");
        }
        else if (s > 30) {
            txtBriliancy.setText("Semangat Kamu Pasti Bisa\uD83D\uDCAA\uD83C\uDFFB");
        }
        else if (s > 10) {
            txtBriliancy.setText("Jangan Menyerah!!!");
        }
        else if (s > 0) {
            txtBriliancy.setText("Ayo Coba lagi☺️");
        }
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){

            Intent intent = new Intent(MathResultActivity.this, ChooseMenu.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Tekan lagi untuk kembali", Toast.LENGTH_SHORT).show();

        }
        backPressedTime = System.currentTimeMillis();
    }
}
