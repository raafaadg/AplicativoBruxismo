package br.com.monitoramento.bruxismo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.monitoramento.bruxismo.client.GetLeitura.GetLeitura;
import br.com.monitoramento.bruxismo.client.GetLeitura.GetLeituraResponse;

public class MainActivity2 extends AppCompatActivity {

    TextView btnHit;
    TextView txtJson;
    //ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnHit = (TextView) findViewById(R.id.btnHit);
        txtJson = (TextView) findViewById(R.id.tvJsonItem);

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute("http://192.168.4.1/edit");
            }
        });
//        runThread();

    }


    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            /*pd = new ProgressDialog(MainActivity2.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();*/
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                line = reader.readLine();
                txtJson.setText(line);
//                String total = "";
//                while (line != null){
//                    total += line;
//                    line = reader.readLine();
//                    //buffer.append(line+"\n");
//                    //Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
//                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }



        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            /*if (pd.isShowing()){
                pd.dismiss();
            }*/
            int index1 = result.indexOf(":");
            int index2 = result.indexOf("}");
            result = result.substring(index1+1,index2);
//            addEntry(Float.parseFloat(result));
            txtJson.setText(result);
        }
    }

    public void setInfo(GetLeituraResponse info) {
        Context contexto = getApplicationContext();
        for(String s : info.valor)
            txtJson.setText(s);

    }
    private void runThread() {

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                new GetLeitura(MainActivity2.this);
                            }
                        });
                        Thread.sleep(1000*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}