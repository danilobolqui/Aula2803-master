package com.example.aluno.aula2803;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aluno on 09/04/18.
 */

public class BDCore extends SQLiteOpenHelper {
    private static final String NOME="aula";
    private static final int VERSAO=2;

    public BDCore(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table pessoa" +
                        "(" +
                        "id integer primary key AUTOINCREMENT, " +
                        "nome varchar(100), " +
                        "telefone varchar(15), " +
                        "apelido varchar(100)," +
                        "img_url varchar(200)" +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("drop table pessoa;");*/
        onCreate(db);
    }
}