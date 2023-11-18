package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

    Button excluir;

    String treinamento_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_novo_treinamento);

        treinamento_id = getIntent().getStringExtra("treinamento_id");

        nome = findViewById(R.id.editTextNome);
        ementa = findViewById(R.id.editTextEmenta);
        cargahoraria = findViewById(R.id.editTextCargaHoraria);

        salvar = findViewById(R.id.buttonTelaCadastroSalvarTreinamentos);
        excluir = findViewById(R.id.buttonTelaCadastroExcluirTreinamentos);

        helper = new Databasehelper(this);

        if(treinamento_id != null){
            prepararEdicao();
        }else{
            nome.setText("");
            ementa.setText("");
            cargahoraria.setText("");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarTreinamento(view);
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirTreinamento(view);
            }
        });
    }

    public void prepararEdicao(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nome, ementa, cargahoraria from treinamentos WHERE _id = ?",new String[]{treinamento_id});
        cursor.moveToFirst();
        nome.setText(cursor.getString(0));
        ementa.setText(cursor.getString(1));
        cargahoraria.setText(cursor.getString(2));
    }

    public void salvarTreinamento(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();

        if (nome.getText().length() > 0 && ementa.getText().length() > 0 && cargahoraria.getText().length() > 0) {
            valores.put("nome", nome.getText().toString());
            valores.put("ementa", ementa.getText().toString());
            valores.put("cargahoraria", cargahoraria.getText().toString());

            long resultado;
            if(treinamento_id == null) {
                resultado = db.insert("treinamentos", null, valores);
            }else{
                resultado = db.update("treinamentos",valores, "_id = ?",new String[]{treinamento_id});
            }

            if (resultado != -1) {
                Toast.makeText(this, getString(R.string.activity_tela_novo_treinamento_salvo_com_sucesso), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.activity_tela_novo_treinamento_erro_ao_salvar), Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, getString(R.string.activity_tela_novo_treinamento_campos_vazios),Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(TelaNovoTreinamento.this, TelaTreinamentos.class));
    }

    public void excluirTreinamento(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        long resultado = db.delete("treinamentos", "_id = ?", new String[]{treinamento_id});
        if (resultado != -1) {
            Toast.makeText(this, "Treinamento excluído com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha ao excluir treinamento!", Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(TelaNovoTreinamento.this, TelaTreinamentos.class));
    }

}