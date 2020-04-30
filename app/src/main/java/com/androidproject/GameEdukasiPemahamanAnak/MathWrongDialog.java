package com.androidproject.GameEdukasiPemahamanAnak;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MathWrongDialog {


    private Context mContext;

    private Dialog wrongDialog;

    private MathQuiz mquizActivity;

    public MathWrongDialog(Context mContext) {
        this.mContext = mContext;
    }


    public void wrongDialog(String correctAnswer,final MathQuiz mathQuizActivity){
        mquizActivity = mathQuizActivity;
        wrongDialog = new Dialog(mContext);
        wrongDialog.setContentView(R.layout.wrong_dialog);
        Button btWrongDialog = (Button) wrongDialog.findViewById(R.id.bt_wrong_dialog);
        TextView textViewCorrectAnswer = (TextView) wrongDialog.findViewById(R.id.text_correct_ans);

        textViewCorrectAnswer.setText("Jawaban Benar: " + String.valueOf(correctAnswer));

        btWrongDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongDialog.dismiss();
                try {
                    mquizActivity.showQuestions();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        wrongDialog.show();
        wrongDialog.setCancelable(false);
        wrongDialog.setCanceledOnTouchOutside(false);

        wrongDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }



}
