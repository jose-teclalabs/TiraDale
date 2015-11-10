package ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.SedeInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Sedes;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by gcampos on 05/11/2015.
 */
public class LoginWS extends ArrayAdapter {

    private Context context;
    private List<Sedes> sedesList;

    public LoginWS(Context context, int resource, List<Sedes> objects) {

        super(context, resource, objects);
        this.context = context;
        this.sedesList = objects;

    }


    //postdata
    private void postDataLogin(final String param1){
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