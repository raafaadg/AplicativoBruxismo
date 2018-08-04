package br.com.monitoramento.bruxismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.monitoramento.bruxismo.client.GetLeitura.GetLeitura;
import br.com.monitoramento.bruxismo.client.GetLeitura.GetLeituraResponse;

public class SetupDadosActivity extends AppCompatActivity {
    EditText et_tele_ssid;
    EditText et_tele_bateria;
    EditText et_tele_nomearquivo;
    EditText et_tele_tamarquivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.activity_setup_dados);
        // Carregue todas as views do seu layout
        loadViews();
        // Seta o que o botão vai fazer
//        tv_iniciar_setup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SetupDadosActivity.this, SetupDadosActivity.class));
//            }
//        });
        new GetLeitura(SetupDadosActivity.this);

    }

    private void loadViews() {
        et_tele_ssid = (EditText) findViewById(R.id.et_tele_ssid);
        et_tele_bateria = (EditText) findViewById(R.id.et_tele_bateria);
        et_tele_nomearquivo = (EditText) findViewById(R.id.et_tele_nomearquivo);
        et_tele_tamarquivo = (EditText) findViewById(R.id.et_tele_tamarquivo);
    }

    public void setInfo(GetLeituraResponse info) {
        et_tele_ssid.setText(info.nomeSSID);
        et_tele_bateria.setText(Float.toString(info.bateria));
        et_tele_nomearquivo.setText(info.nomeArquivo);
        et_tele_tamarquivo.setText(String.valueOf(info.tamanhoArquivo));
    }
}
