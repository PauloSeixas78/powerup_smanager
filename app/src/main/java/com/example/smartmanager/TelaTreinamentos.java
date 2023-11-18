package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TelaTreinamentos extends AppCompatActivity {

    Databasehelper helper;
    ArrayList<Treinamentos> treinamentoscadastrados;

    Button novotreinamento;
    ListView listatreinamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_treinamentos);

        helper = new Databasehelper(this);

        treinamentoscadastrados = new ArrayList<Treinamentos>();

        novotreinamento = findViewById(R.id.buttonNovoTreinamento);

        novotreinamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaTreinamentos.this, TelaNovoTreinamento.class));
            }
        });

        listatreinamentos = (ListView) findViewById(R.id.ListViewListaTreinamentos);

        ArrayAdapter <String> novotreinamentoadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lerTreinamentos());

        listatreinamentos.setAdapter(novotreinamentoadapter);

        listatreinamentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TelaTreinamentos.this, TelaNovoTreinamento.class);
                intent.putExtra("treinamento_id",treinamentoscadastrados.get(i).getId().toString());
                startActivity(intent);
            }
        });
    }

    private String [] lerTreinamentos(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id,nome,ementa,cargahoraria from treinamentos",null);
        cursor.moveToFirst();
        String [] treinamentoslidos = new String[cursor.getCount()];
        for(int item = 0; item <cursor.getCount(); item++){
            treinamentoscadastrados.add(new Treinamentos(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
            treinamentoslidos[item] = cursor.getString(1);
            cursor.moveToNext();
        }
        cursor.close();

        return treinamentoslidos;
    }
}