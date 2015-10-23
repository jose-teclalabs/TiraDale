package ipae.android.sigcomt.edu.tiradaleandroid.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.EmpleadoInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados.EmpleadoWS;
import retrofit.RestAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jpulido on 22/10/2015.
 */
public class EmpleadoActivity extends AppCompatActivity {

    EditText txtUsuario,txtClave;
    Button btnAceptar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarempleado);

        txtUsuario = (EditText) findViewById(R.id.editUsuario);
        txtClave = (EditText) findViewById(R.id.editClave);
        btnAceptar = (Button) findViewById(R.id.btnEnviarPost);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String param1 = txtUsuario.getText().toString();
                String param2 = txtClave.getText().toString();
                postData(param1, param2);
                // Intent intObj = new Intent(Home.this,ListaEmpleados.class);
                // startActivity(intObj);
            }
        });

    }


    private void postData(final String param1, final String param2){
        String url = "http://10.0.3.2:8088/Farmacia";
        RestAdapter vehicleAdapter = new RestAdapter.Builder().setEndpoint(
                url).build();

        //create an instance of the VehicleAPIService.
        EmpleadoInterface vehicleService = vehicleAdapter
                .create(EmpleadoInterface.class);

        //create a new vehicle
        Empleados newVehicle = new Empleados();
        newVehicle.setUsuario(param1);
        newVehicle.setClave(param2);


        //call the service to add the new vehicle
        vehicleService.addVehicle(newVehicle, new Callback() {

            @Override
            public void success(Object o, Response response) {
                String hola = response.toString();
            }

            @Override
            public void failure(RetrofitError error) {
                //gets called when a network error occurs
                throw new RuntimeException("Error! " + error.getMessage());
            }



        });
    }

}
