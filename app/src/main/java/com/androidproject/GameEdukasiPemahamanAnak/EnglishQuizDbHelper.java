package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidproject.GameEdukasiPemahamanAnak.EnglishQuizContract.QuestionTable;

import java.util.ArrayList;

public class EnglishQuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Inggris.db";
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
                QuestionTable.COLUMN_IMAGE + " TEXT, " +
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

        EnglishQuestions q1 = new EnglishQuestions("\tMrs. Emi\t: Good morning, students! \n" +
                "\tStudents\t: ...................., Mrs. \t\t\t\t\tEmi.\n",null,"A.\t\tGood morning","B.\t\tGood afternoon","C.\t\tGood evening",1);
        addQuestions(q1);

        EnglishQuestions q2 = new EnglishQuestions("\tMata, hidung, dan telinga. In English is....", null,"A.\t\tears, eyes, cheek ","B.\t\tnose, lip, ears ","C.\t\teyes, nose, ears",3);
        addQuestions(q2);

        EnglishQuestions q3 = new EnglishQuestions("\tSendok dan Garpu. In English is....",null,"A.\t\tspoon and plate","B.\t\tspoon and fork","C.\t\tfork and plate",2);
        addQuestions(q3);

        EnglishQuestions q4 = new EnglishQuestions("\tLibrary. In Indonesia is ....", null,"A.\t\tPerpustakaan","B.\t\tRuang Kelas","C.\t\tKantor",1);
        addQuestions(q4);

        EnglishQuestions q5 = new EnglishQuestions("\tEvening – Dita – Good. Arrange these letters into a word is ....\n" , null,"A.\t\tGood Dita, Evening","B.\t\tGood Evening, Dita","C.\t\tDita,  Good Evening",2);
        addQuestions(q5);

        EnglishQuestions q6 = new EnglishQuestions("\tA\t: What is your name?\n" +
                "\tB\t:....\n",null," A.\t\tOh...that’s great","B.\t\tNo, it isn’t","C.\t\tMy name is Shinta",3);
        addQuestions(q6);

        EnglishQuestions q7 = new EnglishQuestions("\tA\t: Hi...my name is Dicky\n" +
                "\tB\t: How do you spell your name?\n", null,"A.\t\t[di:] [ai] [si:] [kei] [wai]","B.\t\t[di:] [i:] [es] [ti:] [ai]","C.\t\t[di:] [ai] [en] [di:] [ei]",1);
        addQuestions(q7);

        EnglishQuestions q8 = new EnglishQuestions("\tSeragam sekolah dalam Bahasa Inggris adalah....", null,"A.\t\tClothes","B.\t\tUniform ","C.\t\tT-Shirt",2);
        addQuestions(q8);

        EnglishQuestions q9 = new EnglishQuestions("\tAm – Fine – I. Arrange these letters into a word is...." , null,"A.\t\tFine I Am","B.\t\tAm Fine I","C.\t\tI Am Fine",3);
        addQuestions(q9);

        EnglishQuestions q10 = new EnglishQuestions("\tThis is....", "https://illastem.sirv.com/English/student.jpg", "A.\t\tTeacher", "B.\t\t A boy", "C.\t\tStudent", 3);
        addQuestions(q10);

        EnglishQuestions q11 = new EnglishQuestions("\tWhat is this?", "https://illastem.sirv.com/English/newbedroom.jpg", "A.\t\tBathroom","B.\t\tBedrom","C.\t\tLiving room",2);
        addQuestions(q11);

        EnglishQuestions q12 = new EnglishQuestions("\tIs it a cage?", "https://illastem.sirv.com/English/new%20cage.jpg","A.\t\tYes, it is","B.\t\tNo, it is not","C.\t\tIt is a trash",1);
        addQuestions(q12);

        EnglishQuestions q13 = new EnglishQuestions("\tWhat is the english of the picture?", "https://illastem.sirv.com/English/Classroom.jpg","A.\t\tClassroom","B.\t\tOffice","C.\t\tLibrary",1);
        addQuestions(q13);

        EnglishQuestions q14 = new EnglishQuestions("\tIt is....", "https://illastem.sirv.com/English/xicara.gif","A.\t\tA spoon","B.\t\tA glass","C.\t\tA cup",3);
        addQuestions(q14);

        EnglishQuestions q15 = new EnglishQuestions("\tIt is...", "https://illastem.sirv.com/English/pencil.png","A.\t\tA pencil","B.\t\tA pen","C.\t\tA ruler",1);
        addQuestions(q15);

        EnglishQuestions q16 = new EnglishQuestions("\tHow many flowers are in the \t\tpicture?", "https://illastem.sirv.com/English/new%20flower.png","A.\t\tOne","B.\t\tTwo","C.\t\tThree",3);
        addQuestions(q16);

        EnglishQuestions q17 = new EnglishQuestions("\tThis is....", "https://illastem.sirv.com/English/Giraffe%20(2).jpg","A.\t\tCow","B.\t\tZebra","C.\t\tGiraffe",3);
        addQuestions(q17);

        EnglishQuestions q18 = new EnglishQuestions("\tWhat is it?", "https://illastem.sirv.com/English/Lamp.jpg","A.\t\tA lamp","B.\t\tA pillow","C.\t\tA clock",1);
        addQuestions(q18);

        EnglishQuestions q19 = new EnglishQuestions("\tThis is....", "https://illastem.sirv.com/English/teacher%20new%20(2).jpg","A.\t\tMother","B.\t\tTeacher","C.\t\tOffice girl",2);
        addQuestions(q19);

        EnglishQuestions q20 = new EnglishQuestions("\tSusi\t: How are you, Putra ?\n" +
                "\tPutra\t: ............., thanks\n", null,"A.\t\tGood bye","b.\t\tHello","C.\t\tI am fine",3);
        addQuestions(q20);


    }

    private void addQuestions(EnglishQuestions question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_IMAGE,question.getObject());
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
                QuestionTable.COLUMN_IMAGE,
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
                question.setObject(c.getString(c.getColumnIndex(QuestionTable.COLUMN_IMAGE)));
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


