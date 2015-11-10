package ipae.android.sigcomt.edu.tiradaleandroid.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.SedeInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Sedes;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by gcampos on 28/10/2015.
 */


public class SedesActivity extends AppCompatActivity {

    EditText txtBusqueda;
    Button btnAceptar;
    Button btnVerSedes;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sedes);
        txtBusqueda= (EditText) findViewById(R.id.txtBusqueda);

        btnAceptar = (Button) findViewById(R.id.btnEnviarP);

        btnVerSedes=(Button) findViewById(R.id.btnMostrarSedes);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String param1 = txtBusqueda.getText().toString();

                postData(param1);
               txtBusqueda.setText("");


                // Intent intObj = new Intent(Home.this,ListaEmpleados.class);
                // startActivity(intObj);

            }
        });

        btnVerSedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intObj = new Intent(SedesActivity.this,ListaSedes.class);
                startActivity(intObj);
            }
        });

    }


    private void postData(final String param1){

        String url = "http://10.0.3.2:8088/Farmacia";

        RestAdapter vehicleAdapter = new RestAdapter.Builder().setEndpoint(
                url).build();

        //create an instance of the VehicleAPIService.
        SedeInterface vehicleService = vehicleAdapter
                .create(SedeInterface.class);

        //create a new vehicle
        Sedes newVehicle = new Sedes();
        newVehicle.setDescripcion(param1);

        //call the service to add the new vehicle
        vehicleService.addSedes(newVehicle, new Callback() {

            @Override
            public void success(Object o, Response response) {

                Context context = getApplicationContext();
                CharSequence text = "Envio del POST Exitoso";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                String hola = response.toString();
            }

            @Override
            public void failure(RetrofitError error) {

                Context context = getApplicationContext();
                CharSequence text = "Problema al Enviar el Post";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                //gets called when a network error occurs
                throw new RuntimeException("Error! " + error.getMessage());
            }


        });
    }


}
