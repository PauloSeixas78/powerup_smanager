package com.example.smartmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TelaListaFeedbacks extends AppCompatActivity {

    Button NovoFeedback;

    ListView ListaFeedbacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_feedbacks);

        NovoFeedback = findViewById(R.id.buttonNovoFeedback);

        NovoFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaFeedbacks.this, TelaNovoFeedback.class));
            }
        });

        ListaFeedbacks = (ListView) findViewById(R.id.ListaFeedbacks);

        String [] Feedback = new String[]{"\nFulano de tal\nAtraso\n04/11/2020\n","\nSiclano de tal\nAtraso na Reunião\n04/11/2020\n","\nAstrobaldo de tal\nBaixo Rendimento\n04/11/2020\n"};

        ArrayAdapter <String> NovoFeedbackadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Feedback);

        ListaFeedbacks.setAdapter(NovoFeedbackadapter);


    }
}