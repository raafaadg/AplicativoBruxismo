package br.com.monitoramento.bruxismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rafae on 08/11/2017.
 */

public class ConfigActivity extends AppCompatActivity {
    Button bt_iniciar_moni;
    Button bt_telemetria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.activity_controle);
        // Carregue todas as views do seu layout
        loadViews();
        // Seta o que o botão vai fazer
        bt_iniciar_moni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfigActivity.this, SetupStartActivity.class));
            }
        });
        bt_telemetria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfigActivity.this, MainActivity2.class));
            }
        });

    }

    private void loadViews() {
        bt_iniciar_moni = (Button) findViewById(R.id.bt_iniciar_moni);
        bt_telemetria = (Button) findViewById(R.id.bt_telemetria);
    }
}
