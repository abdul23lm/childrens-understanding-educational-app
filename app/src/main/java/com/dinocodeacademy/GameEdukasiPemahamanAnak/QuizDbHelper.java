package com.dinocodeacademy.GameEdukasiPemahamanAnak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dinocodeacademy.GameEdukasiPemahamanAnak.QuizContract.*;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME = "GoQuiz.db";
   private static final int DATBASE_VERSION = 1;

    private SQLiteDatabase db;


    QuizDbHelper(Context context) {
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
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
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

        Questions q1 = new Questions("Bagaimana cara mengajak teman bermain musik?","Marilah kita menjaga & merawat peralatan musik","Ayo, semangat","Mari kita siapkan alat musik","Ayo kita bermain musik",4);
        addQuestions(q1);


        Questions q2 = new Questions("Di bawah ini yang termasuk kalimat ajakan adalah?","Kakak pergi ke pasar","Kakak ayo kita main bola","Kakak jangan main saja","Maaf, ka. Aku lupa mematikan lampu",2);
        addQuestions(q2);


        Questions q3 = new Questions("Kerjasama di sekolah misalnya","Menyontek","Membangun jalan bersama","Memusuhi teman","Piket kelas",4);
        addQuestions(q3);


        Questions q4 = new Questions("Risa ditolong Riska. Maka Risa mengucapkan ... kepada Riska","Selamat","Terimakasih","Maaf","Ayo",2);
        addQuestions(q4);


        Questions q5 = new Questions("Memaafkan teman harus dengan... ","Terpaksa","Ikhlas","Sombong","Acuh",2);
        addQuestions(q5);


        Questions q6 = new Questions("Meminta maaf harus dengan...","Tegas","Cepat","Sopan","Membentak",3);
        addQuestions(q6);

        Questions q7 = new Questions("Manakah di bawah ini yang merupakan kalimat ungkapan pujian","Siti suka gambar rantai","Nyanyianmu bagus sekali","Dimana rumah Edo?","Tolong matikan lampu!",2);
        addQuestions(q7);

        Questions q8 = new Questions("Kamu lupa mengembalikan buku yang kamu pinjam dari teman. Apa yang harus kamu katakan bila mengalami peristiwa tersebut?","Cerita pada bukumu itu sangat mengharukan","Kapan kamu akan mengembalikan buku?","Maafkan aku. Aku lupa mengembalikan bukumu","Aku pamit pulang ya",3);
        addQuestions(q8);
    }

    private void addQuestions(Questions question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<Questions> getAllQuestions() {

        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
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

                    Questions question = new Questions();
                    question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                    question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                    question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                    question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                    question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                    question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                    questionList.add(question);

                } while (c.moveToNext());

            }
            c.close();
            return questionList;

        }

    }


