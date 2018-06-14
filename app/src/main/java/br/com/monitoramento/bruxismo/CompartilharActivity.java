package br.com.monitoramento.bruxismo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by rafae on 08/11/2017.
 */

public class CompartilharActivity extends AppCompatActivity {

    Button btn_share_wa;
    Button btn_share_gm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.activity_compartilhar);
        // Carregue todas as views do seu layout
        loadViews();
//         Seta o que o botão vai fazer
        btn_share_wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWhats();
            }
        });
        btn_share_gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareGMail("raafaadg@gmail.com","teste","oi");
            }
        });

    }

    private void loadViews() {
        btn_share_wa = (Button) findViewById(R.id.btn_share_wa);
        btn_share_gm = (Button) findViewById(R.id.btn_share_gm);
    }
    private void shareWhats(){
        PackageManager pm=getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "YOUR TEXT HERE";

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void shareGMail(String email, String subject, String content) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
        final PackageManager pm = getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
        ResolveInfo best = null;
        for(final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") || info.activityInfo.name.toLowerCase().contains("gmail"))
                best = info;
        if (best != null)
            emailIntent.setClassName(best.activityInfo.packageName, best.activityInfo.name);
       startActivity(emailIntent);
    }

}
