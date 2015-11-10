package ipae.android.sigcomt.edu.tiradaleandroid.actividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.configuraciones.ServiceGenerator;
import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.SedeInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Sedes;
import ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados.SedeWS;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by gcampos on 02/11/2015.
 */
public class ListaSedes extends AppCompatActivity {

    ListView listView;
    ArrayAdapter listAdapter;
    List<Sedes> flowerList;
    String url = "http://10.0.3.2:8088/Farmacia";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listasedes);
        listView= (ListView) findViewById(R.id.listView3);

        //  RestAdapter restAdapter = new RestAdapter.Builder()
        //           .setEndpoint(url)
        //           .build();

        // EmpleadoInterface flowerapi = restAdapter.create(EmpleadoInterface.class);

        SedeInterface flowerapi = ServiceGenerator.createService(SedeInterface.class);
        //   List<Empleados> empl = flowerapi.listRepos();
        flowerapi.listsede(new Callback<List<Sedes>>() {
            @Override
            public void success(List<Sedes> tasks, Response response) {
                System.out.print(response.toString());
                listAdapter = new SedeWS(ListaSedes.this,0,tasks);
                //setListAdapter(listAdapter);
                listView.setAdapter(listAdapter);
                String hola;
            }

            @Override
            public void failure(RetrofitError error) {
                // you should handle errors, too
                String hola12;

            }
        });
    }


    public ArrayAdapter getListAdapter() {
        return listAdapter;
    }

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
