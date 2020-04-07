package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidproject.GameEdukasiPemahamanAnak.EnglishQuizContract.QuestionTable;

import java.util.ArrayList;

public class EnglishQuizDbHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME = "GoQuiz.db";
   private static final int DATBASE_VERSION = 1;

    private SQLiteDatabase db;


    EnglishQuizDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable()
    {

        EnglishQuestions q1 = new EnglishQuestions("Soal Bahasa Inggris Jawaban A","Option A","Option B","Option C",1);
        addQuestions(q1);

        EnglishQuestions q2 = new EnglishQuestions("Soal Bahasa Inggris Jawaban A","Option A","Option B","Option C",1);
        addQuestions(q2);

        EnglishQuestions q3 = new EnglishQuestions("Soal Bahasa Inggris Jawaban A","Option A","Option B","Option C",1);
        addQuestions(q3);

        EnglishQuestions q4 = new EnglishQuestions("Soal Bahasa Inggris Jawaban A","Option A","Option B","Option C",1);
        addQuestions(q4);

        EnglishQuestions q5 = new EnglishQuestions("Soal Bahasa Inggris Jawaban A","Option A","Option B","Option C",1);
        addQuestions(q5);


    }

    private void addQuestions(EnglishQuestions question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<EnglishQuestions> getAllQuestions() {

        ArrayList<EnglishQuestions> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_ANSWER_NR
        };



            Cursor c = db.query(QuestionTable.TABLE_NAME,
                    Projection,
                    null,
                    null,
                    null,
                    null,
                    null);


            if (c.moveToFirst()) {
                do {

                    EnglishQuestions question = new EnglishQuestions();
                    question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                    question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                    question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                    question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                    question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                    questionList.add(question);

                } while (c.moveToNext());

            }
            c.close();
            return questionList;

        }

    }


