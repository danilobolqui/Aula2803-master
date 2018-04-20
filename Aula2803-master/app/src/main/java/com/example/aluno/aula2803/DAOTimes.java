package com.example.aluno.aula2803;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aluno on 09/04/18.
 */

public class DAOTimes {
    SQLiteDatabase db;

    public DAOTimes(Context context){
        db = new BDCore(context).getWritableDatabase();
    }

    public void inserir(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("telefone", pessoa.getTelefone());
        values.put("apelido", pessoa.getApelido());
        values.put("img_url", pessoa.getImgUrl());

        db.insert("pessoa", null, values);
    }

    public void alterar(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("telefone", pessoa.getTelefone());
        values.put("apelido", pessoa.getApelido());
        values.put("img_url", pessoa.getImgUrl());

        db.update("pessoa", values,"id="+pessoa.getId(),null);
    }

    public void remover(Pessoa pessoa){
        db.delete("pessoa","id="+pessoa.getId(),null);
    }

    public List<Pessoa> buscarTodos(){
        List<Pessoa> pessoas = new ArrayList<>();
        String[] colunas = {"id","nome", "telefone", "apelido", "img_url"};
        Cursor cursor = db.query("pessoa", colunas,null,null, null, null, null);
        cursor.moveToFirst();
        for(int x=0; x<cursor.getCount();x++){
            Pessoa pessoa = new Pessoa();
            pessoa.setId(cursor.getLong(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setTelefone(cursor.getString(2));
            pessoa.setApelido(cursor.getString(3));
            pessoa.setImgUrl(cursor.getString(4));

            pessoas.add(pessoa);
            cursor.moveToNext();
        }

        return pessoas;
    }

    public Pessoa buscarId(Long id){
        String[] colunas = {"id","nome", "telefone", "apelido", "img_url"};
        Cursor cursor = db.query("pessoa", colunas,"id="+id, null, null, null, null);
        cursor.moveToFirst();
        Pessoa pessoa = new Pessoa();
        if(cursor.getCount()>0) {
            pessoa.setId(cursor.getLong(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setTelefone(cursor.getString(2));
            pessoa.setApelido(cursor.getString(3));
            pessoa.setImgUrl(cursor.getString(4));
        }
        return pessoa;
    }
}
