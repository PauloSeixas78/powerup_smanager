package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaNovoTreinamento extends AppCompatActivity {

    Databasehelper helper;

    EditText nome;
    EditText ementa;
    EditText cargahoraria;

    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_novo_treinamento);

        nome = findViewById(R.id.editTextNome);
        ementa = findViewById(R.id.editTextEmenta);
        cargahoraria = findViewById(R.id.editTextCargaHoraria);

        salvar = findViewById(R.id.buttonTelaCadastroSalvarTreinamentos);

        helper = new Databasehelper(this);



        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarTreinamento(view);
            }
        });
    }

    public void salvarTreinamento(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();

        if (nome.getText().length() > 0 && ementa.getText().length() > 0 && cargahoraria.getText().length() > 0) {
            valores.put("nome", nome.getText().toString());
            valores.put("ementa", ementa.getText().toString());
            valores.put("cargahoraria", cargahoraria.getText().toString());

            long resultado = db.insert("treinamentos", null, valores);

            if (resultado != -1) {
                Toast.makeText(this, getString(R.string.activity_tela_novo_treinamento_salvo_com_sucesso), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.activity_tela_novo_treinamento_erro_ao_salvar), Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, getString(R.string.activity_tela_novo_treinamento_campos_vazios),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart(){
        super.onStart();
        nome.setText("");
        ementa.setText("");
        cargahoraria.setText("");
    }
}