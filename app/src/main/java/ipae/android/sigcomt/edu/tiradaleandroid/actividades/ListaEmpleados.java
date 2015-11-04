package ipae.android.sigcomt.edu.tiradaleandroid.actividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.configuraciones.ServiceGenerator;
import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.EmpleadoInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jpulido on 21/10/2015.
 */
public class ListaEmpleados extends AppCompatActivity {

    ListView listView;
    ArrayAdapter listAdapter;
    List<Empleados> flowerList;
    String url = "http://10.0.3.2:8088/Farmacia";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaempleados);
        listView= (ListView) findViewById(R.id.listView2);

      //  RestAdapter restAdapter = new RestAdapter.Builder()
     //           .setEndpoint(url)
     //           .build();

       // EmpleadoInterface flowerapi = restAdapter.create(EmpleadoInterface.class);

       EmpleadoInterface flowerapi = ServiceGenerator.createService(EmpleadoInterface.class);

     //   List<Empleados> empl = flowerapi.listRepos();

        flowerapi.listRepos(new Callback<List<Empleados>>() {
            @Override
            public void success(List<Empleados> tasks, Response response) {
            System.out.print(response.toString());
                listAdapter = new EmpleadoWS(ListaEmpleados.this,0,tasks);
                //setListAdapter(listAdapter);
                listView.setAdapter(listAdapter);

                String hola;
                // here you do stuff with returned tasks
            }

            @Override
            public void failure(RetrofitError error) {
                // you should handle errors, too
                String hola12;

            }
        });
    }

    public ArrayAdapter getListAdapter() {return listAdapter;}

    public void setListAdapter(ArrayAdapter listAdapter) {
        this.listAdapter = listAdapter;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }
}
