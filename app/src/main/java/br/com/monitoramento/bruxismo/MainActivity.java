package br.com.monitoramento.bruxismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tv_emg_cadastro;
    TextView tv_emg_grafico;
    TextView tv_emg_controle;
    TextView tv_emg_compartilar;

    CadastroActivity cadastro = new CadastroActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.activity_main);
        // Carregue todas as views do seu layout
        loadViews();


        tv_emg_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(numbersIntent);
            }
        });

        tv_emg_grafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, TimeGraficoActivity.class);
                startActivity(numbersIntent);
            }
        });

        tv_emg_controle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, ConfigActivity.class);
                startActivity(numbersIntent);
            }
        });

        tv_emg_compartilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, CompartilharActivity.class);
                startActivity(numbersIntent);
            }
        });
    }

    private void loadViews() {
        tv_emg_cadastro=(TextView) findViewById(R.id.cadastro);
        tv_emg_grafico=(TextView) findViewById(R.id.grafico);
        tv_emg_controle=(TextView) findViewById(R.id.controle);
        tv_emg_compartilar=(TextView) findViewById(R.id.compartilhar);

    }

}
