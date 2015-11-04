package ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

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
public class SedeWS extends ArrayAdapter {

    private Context context;
    private List<Sedes> sedesList;

    public SedeWS(Context context, int resource, List<Sedes> objects) {
        super(context, resource, objects);
        this.context = context;
        this.sedesList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sedes, parent, false);
        Sedes flower = sedesList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.txtIdSede);
        TextView tv1 = (TextView) view.findViewById(R.id.txtDescripcion);

        tv.setText(flower.getIdSede());
        tv1.setText(flower.getDescripcion());

        return view;
    }







    //postdata
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
