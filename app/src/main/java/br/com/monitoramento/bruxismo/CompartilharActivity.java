package br.com.monitoramento.bruxismo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rafae on 08/11/2017.
 */

public class CompartilharActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.activity_compartilhar);
        // Carregue todas as views do seu layout
        loadViews();
        // Seta o que o botão vai fazer
       // bt_emg_buscar.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View v) {
       //         efetivarCadastro();
       //         Log.e("MyActivity","Teste Clique no botão");
       //     }
       // });

    }

    private void loadViews() {
        //et_emg_comando = (EditText) findViewById(R.id.et_emg_comando);
        //et_emg_nome = (EditText) findViewById(R.id.et_emg_nome);
        //et_emg_idade = (EditText) findViewById(R.id.et_emg_idade);
        //et_emg_peso = (EditText) findViewById(R.id.et_emg_peso);
        //et_emg_tipo = (EditText) findViewById(R.id.et_emg_tipo);
        //et_emg_valor = (EditText) findViewById(R.id.et_emg_valor);
        //bt_emg_buscar = (Button) findViewById(R.id.bt_emg_buscar);
    }
}
