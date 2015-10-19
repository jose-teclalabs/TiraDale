package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by gcampos on 15/10/2015.
 */
public class Home extends AppCompatActivity {
    Button btnComoUtilizar;
    Button btnConoceServicios;
    Button btnAfilateComunidad;
    Button btnUltimoNoticias;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnComoUtilizar=(Button)findViewById(R.id.btnComoUtilizar);
        btnConoceServicios=(Button)findViewById(R.id.btnConocerServicios);
        btnAfilateComunidad=(Button)findViewById(R.id.btnAfiliaComunidad);
        btnUltimoNoticias=(Button)findViewById(R.id.btnUltimaNoticias);

        //Listener
        btnComoUtilizar.setOnClickListener(new URLBasico());
        btnConoceServicios.setOnClickListener(new URLBasico());
        btnAfilateComunidad.setOnClickListener(new URLBasico());
        btnUltimoNoticias.setOnClickListener(new URLBasico());


    }

    public class URLBasico implements View.OnClickListener{

        public void onClick(View view){

            Intent intObj = new Intent(Home.this,Servicios.class);
            startActivity(intObj);

        }

    }


}
