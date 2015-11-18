package ipae.android.sigcomt.edu.tiradaleandroid;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

/**
 * Created by jpulido on 19/10/2015.
 */
public class Servicios extends AppCompatActivity {

    Button btnColegios;
    Button btnSedes;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicios);
        btnColegios=(Button)findViewById(R.id.btnColegios);

        //btnSedes=(Button)findViewById(R.id.btnSedes);


        //Listener

        btnColegios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intObj = new Intent(Servicios.this, EscogerUniversidad.class);
                startActivity(intObj);
            }
        });

        //TAB Host
        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Servicios",
                res.getDrawable(android.R.color.holo_green_dark));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Entidades",
               res.getDrawable(android.R.color.background_dark));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Comunidades",
                res.getDrawable(android.R.color.holo_green_dark));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);


        //Tab Host Listener

    }




}
