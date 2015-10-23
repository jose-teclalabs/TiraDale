package ipae.android.sigcomt.edu.tiradaleandroid.interfaces;

import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by jpulido on 23/10/2015.
 */
public interface EmpleadoInterface {

    @GET("/rest/empleados")      //here is the other url part.best way is to start using /
    public void getEmpleados(@Body List<Empleados> empleado, Callback<Empleados> response);

    @POST("/rest/addEmpleado")
    void addVehicle(@Body Empleados empleado, Callback<Empleados> cb);
}
