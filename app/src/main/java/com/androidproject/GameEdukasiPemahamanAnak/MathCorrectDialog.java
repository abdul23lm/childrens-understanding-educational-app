package com.androidproject.GameEdukasiPemahamanAnak;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MathCorrectDialog {

    private Context mContext;

    private Dialog correctDialog;

    private MathQuiz mquizActivity;

    public MathCorrectDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void correctDialog(int score, final MathQuiz mathQuizActivity){

        mquizActivity = mathQuizActivity;

        correctDialog = new Dialog(mContext);
        correctDialog.setContentView(R.layout.correct_dialog);

        Button btCorrectDilaog = (Button) correctDialog.findViewById(R.id.bt_correct_dialog);

        score(score);


        btCorrectDilaog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctDialog.dismiss();
                try {
                    mathQuizActivity.showQuestions();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        correctDialog.show();
        correctDialog.setCancelable(false);
        correctDialog.setCanceledOnTouchOutside(false);

        correctDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    private void score(int score) {

        TextView textViewScore = (TextView) correctDialog.findViewById(R.id.text_score);
        textViewScore.setText("Skor: " + String.valueOf(score));
    }


}
