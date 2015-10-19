package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jpulido on 19/10/2015.
 */
public class Acciones  extends AppCompatActivity {
   Button btnPublicar;
    Button btnVerResultados;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acciones);

        btnPublicar = (Button)findViewById(R.id.btnPublicar);
        btnVerResultados = (Button)findViewById(R.id.btnVerResultados);

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intObj = new Intent(Acciones.this,Publicar.class);
                startActivity(intObj);
            }
        });

        btnVerResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intObj = new Intent(Acciones.this,Resultados.class);
                startActivity(intObj);
            }
        });

    }
}
