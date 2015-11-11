package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

    }


}
