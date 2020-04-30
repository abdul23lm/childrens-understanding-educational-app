package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.androidproject.GameEdukasiPemahamanAnak.MathQuizContract.MathQuestionTable;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class MathQuizDbHelper extends SQLiteOpenHelper {


   private static final String DATABASE_NAME = "Matematika.db";
   private static final int DATBASE_VERSION = 1;
    Context context;
    private SQLiteDatabase db;


    MathQuizDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                MathQuestionTable.TABLE_NAME + " ( " +
                MathQuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MathQuestionTable.COLUMN_QUESTION + " TEXT, " +
                MathQuestionTable.COLUMN_IMAGE + " TEXT, " +
                MathQuestionTable.COLUMN_OPTION1 + " TEXT, " +
                MathQuestionTable.COLUMN_OPTION2 + " TEXT, " +
                MathQuestionTable.COLUMN_OPTION3 + " TEXT, " +
                MathQuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        try {
            fillQuestionsTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + MathQuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable() throws IOException {



        MathQuestions q1 = new MathQuestions("Berapa banyak buah apel pada gambar?","https://illastem.sirv.com/Matematika/mb5.png","A.\t\t24","B.\t\t23","C.\t\t22",1);
        addQuestions(q1);

        MathQuestions q2 = new MathQuestions("Hitunglah banyak sepatu di atas!","https://illastem.sirv.com/Matematika/newmb.Png","A.34","B.\t\t32","C.\t\t36",2);
        addQuestions(q2);

        MathQuestions q3 = new MathQuestions("Urutkan berdasarkan angka terkecil ke terbesar!","https://illastem.sirv.com/Matematika/newKB.jpg","A.\t\t2, 6, 4, 8, 10","B.\t\t2, 4, 6, 10, 8","C.\t\t2, 4, 6, 8, 10",3);
        addQuestions(q3);

        MathQuestions q4 = new MathQuestions("Urutkan berdasarkan angka terbesar ke terkecil!","https://illastem.sirv.com/Matematika/BKnew.png","A.\t\t20, 11, 9, 7, 3, 5","B.\t\t20, 11, 9, 7, 5, 3","C.\t\t20, 11, 7, 9, 5, 3",2);
        addQuestions(q4);

        MathQuestions q5 = new MathQuestions("Gunakan tanda > (lebih dari), < (kurang dari) atau = (sama dengan) yang tepat pada gambar di atas!","https://illastem.sirv.com/Matematika/pb3.jpg","A.\t\t<","B.\t\t=","C.\t\t>",1);
        addQuestions(q5);

        MathQuestions q6 = new MathQuestions("Gunakan > (lebih dari), < (kurang dari) atau = (sama dengan) yang tepat pada gambar di atas!","https://illastem.sirv.com/Matematika/pb6.PNG","A.\t\t=","B.\t\t>","C.\t\t>",3);
        addQuestions(q6);

        MathQuestions q7 = new MathQuestions("Berapakah hasil pengurangan di atas?","https://illastem.sirv.com/Matematika/PG9.PNG","A.\t\t2","B.\t\t3","C.\t\t4",1);
        addQuestions(q7);

        MathQuestions q8 = new MathQuestions("Berapakah hasil pengurangan di atas?","https://illastem.sirv.com/Matematika/pg20.png","A.\t\t5","B.\t\t6","C.\t\t7",2);
        addQuestions(q8);

        MathQuestions q9 = new MathQuestions("Berapakah hasil penjumlahan pensil di atas","https://illastem.sirv.com/Matematika/pj7.png","A.\t\t14","B.\t\t12","C.\t\t16",3);
        addQuestions(q9);

        MathQuestions q10 = new MathQuestions("Berapakah hasil penjumlahan  sepeda di atas","https://illastem.sirv.com/Matematika/pj20.jpg","A.\t\t6","B.\t\t7","C.\t\t8",2);
        addQuestions(q10);

        MathQuestions q11 = new MathQuestions("Berapakah jumlah balok pada gambar di atas?","https://illastem.sirv.com/Matematika/ps1.jpg","A,\t\t39","B.\t\t38","C.\t\t36",1);
        addQuestions(q11);

        MathQuestions q12 = new MathQuestions("Berapakah jumlah balok pada gambar di atas?","https://illastem.sirv.com/Matematika/ps3.jpeg","A.\t\t30","B.\t\t21","C.\t\t31",3);
        addQuestions(q12);

        MathQuestions q13 = new MathQuestions("\n\t\t\t\t\t\t\t\t20 + 20 - 15 =....",null,"A.\t\t40","B.\t\t25","C.\t\t5",2);
        addQuestions(q13);

        MathQuestions q14 = new MathQuestions("\n\t\t\t\t\t\t\t\t10 + 15 - 5 =....",null,"A.\t\t20","B.\t\t15","C.\t\t25",1);
        addQuestions(q14);

        MathQuestions q15 = new MathQuestions("\t\t\t\t\t\t\t\t.... , 22 , .... , 24." + "\nLengkapi titik – titik tersebut sehingga dapat mengurutkan angka dari terkecil ke terbesar!",null,"A.\t\t21, 22, 24, 23","B.\t\t24, 23, 22, 21","C.\t\t21, 22, 23, 24",3);
        addQuestions(q15);

        MathQuestions q16 = new MathQuestions("\t\t\t\t\t\t\t\t36, .... , .... , 33." +
                "\nLengkapi titik – titik tersebut sehingga dapat mengurutkan angka dari terbesar ke terkecil!\n",null,"A.\t\t33, 34, 35, 36","B.\t\t36, 35, 34, 33","C.\t\t36, 34, 35, 33",2);
        addQuestions(q16);

        MathQuestions q17 = new MathQuestions("\t\t\t\t\t\t\t\t40 .......... 31." + "\nIsilah titik-titik dengan kata lebih dari, kurang dari atau sama dengan!",null,"A.\t\tLebih dari","B.\t\tKurang dari","C.\t\tSama dengan",1);
        addQuestions(q17);

        MathQuestions q18 = new MathQuestions("\t\t\t\t\t\t\t\t95 .......... 95." + "\nIsilah titik-titik dengan kata lebih dari, kurang dari atau sama dengan!",null,"A.\t\tLebih dari","B.\t\tKurang dari","C.\t\tSama dengan",3);
        addQuestions(q18);

        MathQuestions q19 = new MathQuestions("\n\t\t\t\t8 puluhan + 3 satuan = ....",null,"A.\t\t82","B.\t\t83","C.\t\t84",2);
        addQuestions(q19);

        MathQuestions q20 = new MathQuestions("\n\t\t\t\t2 puluhan + 7 satuan = ....",null,"A.\t\t27","B.\t\t72","C.\t\t37",1);
        addQuestions(q20);
    }


    private void addQuestions(MathQuestions question){


        ContentValues cv = new ContentValues();
        cv.put(MathQuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(MathQuestionTable.COLUMN_IMAGE, question.getObject());
        cv.put(MathQuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(MathQuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(MathQuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(MathQuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(MathQuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<MathQuestions> getAllQuestions() {

        ArrayList<MathQuestions> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                MathQuestionTable._ID,
                MathQuestionTable.COLUMN_QUESTION,
                MathQuestionTable.COLUMN_IMAGE,
                MathQuestionTable.COLUMN_OPTION1,
                MathQuestionTable.COLUMN_OPTION2,
                MathQuestionTable.COLUMN_OPTION3,
                MathQuestionTable.COLUMN_ANSWER_NR
        };



            Cursor c = db.query(MathQuestionTable.TABLE_NAME,
                    Projection,
                    null,
                    null,
                    null,
                    null,
                    null);


            if (c.moveToFirst()) {
                do {

                    MathQuestions question = new MathQuestions();
                    question.setQuestion(c.getString(c.getColumnIndex(MathQuestionTable.COLUMN_QUESTION)));
                    question.setObject(c.getString(c.getColumnIndex(MathQuestionTable.COLUMN_IMAGE)));
                    question.setOption1(c.getString(c.getColumnIndex(MathQuestionTable.COLUMN_OPTION1)));
                    question.setOption2(c.getString(c.getColumnIndex(MathQuestionTable.COLUMN_OPTION2)));
                    question.setOption3(c.getString(c.getColumnIndex(MathQuestionTable.COLUMN_OPTION3)));
                    question.setAnswerNr(c.getInt(c.getColumnIndex(MathQuestionTable.COLUMN_ANSWER_NR)));

                    questionList.add(question);
                } while (c.moveToNext());

            }
            c.close();
            return questionList;

        }

    }


