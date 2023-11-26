package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class TelaNovoFeedback extends AppCompatActivity {

    EditText Matricula;
    EditText Situação;
    EditText Comportamento;
    EditText Impacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_novo_feedbacks);

        Matricula = findViewById(R.id.spinnerMatricula);
        Situação = findViewById(R.id.editTextTextSituacao);
        Comportamento = findViewById(R.id.editTextTextComportamento);
        Impacto = findViewById(R.id.editTextTextImpacto);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Matricula.setText("");
        Situação.setText("");
        Comportamento.setText("");
        Impacto.setText("");
    }

}