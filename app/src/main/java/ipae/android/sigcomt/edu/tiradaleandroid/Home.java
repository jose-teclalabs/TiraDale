package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import ipae.android.sigcomt.edu.tiradaleandroid.actividades.ListaEmpleados;

/**
 * Created by gcampos on 15/10/2015.
 */
public class Home extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button btnComoUtilizar;
    Button btnConoceServicios;
    Button btnAfilateComunidad;
    Button btnUltimoNoticias;
    private DrawerLayout mDrawer;
    private ListView mDrawerOptions;
    private static final String[] values = {"Publicar", "Ver Resultado"};
    private MenuItem item;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mDrawerOptions = (ListView) findViewById(R.id.left_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        mDrawerOptions.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values));
        mDrawerOptions.setOnItemClickListener(this);

        btnComoUtilizar=(Button)findViewById(R.id.btnComoUtilizar);
        btnConoceServicios=(Button)findViewById(R.id.btnConocerServicios);
        btnAfilateComunidad=(Button)findViewById(R.id.btnAfiliaComunidad);
        btnUltimoNoticias=(Button)findViewById(R.id.btnUltimaNoticias);

        //Listener
        btnComoUtilizar.setOnClickListener(new URLBasico());
        btnConoceServicios.setOnClickListener(new URLBasico());
        btnAfilateComunidad.setOnClickListener(new URLBasico());
      //  btnUltimoNoticias.setOnClickListener(new URLBasico());

        btnUltimoNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intObj = new Intent(Home.this,ListaEmpleados.class);
                startActivity(intObj);
            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Pulsado " + values[i], Toast.LENGTH_SHORT).show();
        //Intent intObj = new Intent(Home.this,Servicios.class);
        //startActivity(intObj);
        mDrawer.closeDrawers();
    }


    public class URLBasico implements View.OnClickListener{

        public void onClick(View view){

            Intent intObj = new Intent(Home.this,Servicios.class);
            startActivity(intObj);

        }

    }


}
