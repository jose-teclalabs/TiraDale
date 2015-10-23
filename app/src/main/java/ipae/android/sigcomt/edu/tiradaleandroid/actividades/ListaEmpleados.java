package ipae.android.sigcomt.edu.tiradaleandroid.actividades;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados.EmpleadoWS;

/**
 * Created by jpulido on 21/10/2015.
 */
public class ListaEmpleados extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaempleados);
        listView= (ListView) findViewById(R.id.listView);
        // Crear adaptador y setear
       // adapter = new EmpleadoWS(this);
        //listView.setAdapter(adapter);
    }
}
