package com.androidproject.GameEdukasiPemahamanAnak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidproject.GameEdukasiPemahamanAnak.IndoQuizContract.QuestionTable;

import java.io.IOException;
import java.util.ArrayList;

public class IndoQuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Indonesia.db";
    private static final int DATBASE_VERSION = 2;

    private SQLiteDatabase db;


    IndoQuizDbHelper(Context context) {
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
        try {
            fillQuestionsTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable() throws IOException
    {

        IndoQuestions q1 = new IndoQuestions("Ungkapan pujian yang tepat pada gambar di atas adalah....", "https://illastem.sirv.com/Bahasa%20Indonesia/Lani.png","A.\tApakah kamu sedang menggambar bunga?","B.\tMenurutku gambarmu perlu ditingkatkan lagi","C.\tWah gambarmu bagu sekali Lani",3);
        addQuestions(q1);

        IndoQuestions q2 = new IndoQuestions("Ungkapan pujian yang tepat pada gambar di atas adalah....", "https://illastem.sirv.com/Bahasa%20Indonesia/Dayu.png","A.\tDayu, bagus sekali gerakanmu","B.\tBagus sekali pakaianmu","C.\tAku ini sepertimu, Dayu",1);
        addQuestions(q2);

        IndoQuestions q3 = new IndoQuestions("Udin berbagi kue kepada Edo. Apa yang harus Edo katakan kepada Udin?", "https://illastem.sirv.com/Bahasa%20Indonesia/Udin.jpg","A.\tb.\tKue apa itu Udin?","B.\tTerimakasih, kamu baik sekali Udin","C.\tWah, kuemu enak sekali",2);
        addQuestions(q3);

        IndoQuestions q4 = new IndoQuestions("Kalimat yang cocok dengan gambar di atas adalah....", "https://illastem.sirv.com/Bahasa%20Indonesia/ibu.jpg","A.\tIbu sedang memasak","B.\tIbu sedang berbelanja di pasar","C.\tIbu mencuci pakaian",1);
        addQuestions(q4);

        IndoQuestions q5 = new IndoQuestions("Ungkapan pujian yang tepat pada gambar di atas adalah....", "https://illastem.sirv.com/Bahasa%20Indonesia/Beni.jpg","A.\t\tAyo, Beni kita bernyanyi","B.\t\tWow, kamu mahir sekali bermain gitar","C.\t\tApakah itu gitar?",2);
        addQuestions(q5);

        IndoQuestions q6 = new IndoQuestions("Rahma pamit kepada Ibu sebelum pergi bermain. Sikap Rahma mencerminkan perilaku....", "https://illastem.sirv.com/Bahasa%20Indonesia/Kebiasaan%20baik%20di%20rumah.PNG","A.\t\tKebiasaan buruk di rumah","B.\t\tKebiasaan baik di sekolah","C.\t\tKebiasaan baik di rumah",3);
        addQuestions(q6);

        IndoQuestions q7 = new IndoQuestions("Apa yang sedang dilakukan anak laki-laki di atas?", "https://illastem.sirv.com/Bahasa%20Indonesia/basket.png","A.\t\tBerjalan","B.\t\tBermain","C.\t\tBerlari",2);
        addQuestions(q7);

        IndoQuestions q8 = new IndoQuestions("Benda pada gambar di atas digunakan untuk....", "https://illastem.sirv.com/Bahasa%20Indonesia/sapu%20(2).jpg","A.\t\tMembersihkan rumah","B.\t\tMembersihkan kebun","C.\t\tMembersihkan sawah",1);
        addQuestions(q8);

        IndoQuestions q9 = new IndoQuestions("Apa saja warna lampu lalu lintas?", "https://illastem.sirv.com/Bahasa%20Indonesia/lampulalulintas.jpg","A.\t\tJingga, Kuning, Ungu","B.\t\tMerah, Kuning, Hijau","C.\t\tMerah, Kuning, Biru",3);
        addQuestions(q9);

        IndoQuestions q10 = new IndoQuestions("Alat di atas digunakan untuk mengukur....", "https://illastem.sirv.com/Bahasa%20Indonesia/penggaris.png","A.\t\tKayu","B.\t\tKertas","C.\t\tBuku",2);
        addQuestions(q10);

        IndoQuestions q11 = new IndoQuestions("Contoh kalimat ungkapan pemberitahuan adalah", null,"A.\t\tIbu merebus pisang","B.\t\tDarimana, Beni?","C.\t\tTerimakasih ayah.",1);
        addQuestions(q11);

        IndoQuestions q12 = new IndoQuestions("Manakah di bawah ini yang merupakan kalimat perintah?", null,"A.\t\tBesok adalah hari minggu","B.\t\tBuanglah sampah pada tempatnya","C.\t\tGunakan jalur kiri ketika sedang bersepeda.",2);
        addQuestions(q12);

        IndoQuestions q13 = new IndoQuestions("Di bawah ini yang bukan mencerminkan kebiasaan baik adalah....", null,"A.\t\tRani meyiapkan air minum untuk ayah","B.\t\tJihan Meyapu lantai","C.\t\tQori mencorat-coret tembok",3);
        addQuestions(q13);

        IndoQuestions q14 = new IndoQuestions("Lantai – Hingga – Sapulah – Bersih – Kelas\n" +
                "Susunan kalimat perintah yang tepat dari kata-kata di atas adalah....\n", null,"B.\t\tSapulah lantai kelas hingga bersih","A.\t\tSapulah kelas bersih hingga lantai","C.\t\tSapulah hingga kelas lantai bersih",1);
        addQuestions(q14);

        IndoQuestions q15 = new IndoQuestions("Yang termasuk kalimat tanggapan adalah....", null,"A.\t\tMari kita bermain bola","B.\t\tAyo, kita ajak teman-teman yang lain","C.\t\tMaaf aku tidak bisa",3);
        addQuestions(q15);

        IndoQuestions q16 = new IndoQuestions("....kita belajar! Agar menjadi anak pintar. Titik-titik tersebut diisi dengan kata?\n", null,"A.\t\tSilahkan","B.\t\tAyo","C.\t\tMaaf",2);
        addQuestions(q16);

        IndoQuestions q17 = new IndoQuestions("Sabun – Saat – Tangan – Gunakan – Cuci\n" +
                "Susunlah kalimat di atas menjadi ungkapan petunjuk....\n", null,"A.\t\tGunakan sabun saat cuci tangan","B.\t\tSaat cuci tangan gunakan sabun","C.\t\tCuci tangan saat gunakan sabun",1);
        addQuestions(q17);

        IndoQuestions q18 = new IndoQuestions("Kamu lupa mengembalikan buku yang kamu pinjam dari teman. Apa yang harus kamu katakan bila mengalami peristiwa tersebut?", null,"A.\t\tOops, aku merusak bukumu","B.\t\tAku pinjam dulu bukumu ya","C.\t\tMaaf, aku lupa mengembalikan bukumu",3);
        addQuestions(q18);

        IndoQuestions q19 = new IndoQuestions("Berikut yang merupakan kalimat ajakan untuk menjaga lingkungan adalah....", null,"A.\t\tKita harus memaafkan kesalahanorang lain.","B.\t\tAyo, buang sampah pada tempatnya! ","C.\t\tAyo, kita belajar bersama di rumahErsa!",2);
        addQuestions(q19);

        IndoQuestions q20 = new IndoQuestions("Deni menolong Budi membawakan bukunya. Budi kemudian mengucapkan....", null,"A.\t\tTerimakasih","B.\t\tMaaf","C.\t\tSelamat tinggal",1);
        addQuestions(q20);

    }

    private void addQuestions(IndoQuestions question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_IMAGE, question.getObject());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<IndoQuestions> getAllQuestions() {

        ArrayList<IndoQuestions> questionList = new ArrayList<>();
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

                IndoQuestions question = new IndoQuestions();
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


