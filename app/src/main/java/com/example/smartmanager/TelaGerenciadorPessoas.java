package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaGerenciadorPessoas extends AppCompatActivity {
    Button treinamentos;
    Button time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gerenciador_pessoas);
        time = findViewById(R.id.buttonTime);


        treinamentos = findViewById(R.id.buttonTreinamentos);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaGerenciadorPessoas.this, TelaTime.class));
            }
        });
        treinamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaGerenciadorPessoas.this, TelaTreinamentos.class));
            }
        });
    }
}