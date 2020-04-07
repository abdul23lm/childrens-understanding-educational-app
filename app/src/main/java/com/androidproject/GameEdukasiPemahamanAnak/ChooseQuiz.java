package com.androidproject.GameEdukasiPemahamanAnak;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_quiz);

        Button btmath = findViewById(R.id.button_math);
        Button btindo = findViewById(R.id.button_indo);
        Button btenglish = findViewById(R.id.button_english);

        btmath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseQuiz.this, MathQuiz.class);
                startActivity(intent);

            }
        });
        btindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseQuiz.this, IndoQuiz.class);
                startActivity(intent);

            }
        });
        btenglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseQuiz.this, EnglishQuiz.class);
                startActivity(intent);

            }
        });

    }
}
