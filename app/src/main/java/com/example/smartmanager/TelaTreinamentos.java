package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TelaTreinamentos extends AppCompatActivity {
    Button novotreinamento;

    ListView listatreinamentos;

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

        listatreinamentos = (ListView) findViewById(R.id.ListViewListaTreinamentos);

        String [] treinados = new String[]{"\nC++\nAtraso\n04/11/2020\n","\nCiclano de tal\nAtraso na reunião\n04/11/2020\n","\nAstrobaldo de tal\nBaixo rendimento\n04/11/2020\n"};

        ArrayAdapter <String> novotreinamentoadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,treinados);

        listatreinamentos.setAdapter(novotreinamentoadapter);
    }
}