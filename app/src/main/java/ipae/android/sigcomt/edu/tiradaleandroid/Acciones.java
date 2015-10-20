package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jpulido on 19/10/2015.
 */
public class Acciones  extends AppCompatActivity {
   Button btnPublicar;
    Button btnVerResultados;
    TextView txtColegio;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acciones);

        btnPublicar = (Button)findViewById(R.id.btnPublicar);
        btnVerResultados = (Button)findViewById(R.id.btnVerResultados);
        txtColegio = (TextView)findViewById(R.id.txtColegio);
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("txtColegio");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("txtColegio");
        }
        txtColegio.setText(newString);

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
