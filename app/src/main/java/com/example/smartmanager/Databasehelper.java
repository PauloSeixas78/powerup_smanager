package com.example.smartmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS_NOME = "Smanager";
    private static final int BANCO_DADOS_VERSAO = 1;

    public Databasehelper(Context context){
        super(context,BANCO_DADOS_NOME,null,BANCO_DADOS_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE treinamentos(_id INTEGER PRIMARY KEY, nome TEXT, ementa TEXT, cargahoraria INTEGER);");
        db.execSQL("CREATE TABLE pessoa(_id INTEGER PRIMARY KEY,nome TEXT,matricula TEXT,cargoatual TEXT, datadeamissao DATE);");
        db.execSQL("CREATE TABLE feedbacks(_id INTEGER, matricula TEXT,situacao TEXT,comportamento TEXT,impacto TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int versaoAnterior, int novaVersao){

    }



}
