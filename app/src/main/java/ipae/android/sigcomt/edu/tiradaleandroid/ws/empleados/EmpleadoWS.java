package ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.EmpleadoInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EmpleadoWS extends ArrayAdapter {

    private Context context;
    private List<Empleados> empleadosList;


    public EmpleadoWS(Context context, int resource, List<Empleados> objects) {
        super(context, resource, objects);
        this.context = context;
        this.empleadosList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.empleado, parent, false);
        Empleados flower = empleadosList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.txtCodigoUsuario);
        TextView tv1 = (TextView) view.findViewById(R.id.txtUsuario);
        TextView tv2 = (TextView) view.findViewById(R.id.txtClave);
        tv.setText(flower.getIdUsuario());
        tv1.setText(flower.getUsuario());
        tv2.setText(flower.getClave());
        return view;
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