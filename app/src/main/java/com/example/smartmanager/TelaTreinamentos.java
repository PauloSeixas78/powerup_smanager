package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaTreinamentos extends AppCompatActivity {
    Button novotreinamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_treinamentos);

        novotreinamento = findViewById(R.id.buttonNovoTreinamento);

        novotreinamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaTreinamentos.this, TelaNovoTreinamento.class));
            }
        });
    }
}