package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class TelaNovoFeedback extends AppCompatActivity {

    Databasehelper helper;

    Spinner Matricula;
    EditText Situacao;
    EditText Comportamento;
    EditText Impacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_novo_feedbacks);

        Matricula = findViewById(R.id.spinnerMatricula);
        Situacao = findViewById(R.id.editTextTextSituacao);
        Comportamento = findViewById(R.id.editTextTextComportamento);
        Impacto = findViewById(R.id.editTextTextImpacto);
        helper = new Databasehelper(this);

    }

    public void salvar(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("Matricula",Matricula.getSelectedItem().toString());
        valores.put("Situacao",Situacao.getText().toString());
        valores.put("Comportamento",Comportamento.getText().toString());
        valores.put("Impacto",Impacto.getText().toString());

    }

    @Override
    protected void onStart(){
        super.onStart();
        //Matricula.("");
        Situacao.setText("");
        Comportamento.setText("");
        Impacto.setText("");
    }

}