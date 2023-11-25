package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class TelaNovoTreinamento extends AppCompatActivity {
    EditText nome;
    EditText ementa;
    EditText cargahoraria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_novo_treinamento);

        nome = findViewById(R.id.editTextNome);
        ementa = findViewById(R.id.editTextEmenta);
        cargahoraria = findViewById(R.id.editTextCargaHoraria);
    }
    @Override
    protected void onStart(){
        super.onStart();
        nome.setText("");
        ementa.setText("");
        cargahoraria.setText("");
    }
}