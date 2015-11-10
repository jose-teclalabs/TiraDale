package ipae.android.sigcomt.edu.tiradaleandroid.interfaces;

import ipae.android.sigcomt.edu.tiradaleandroid.Response.LoginResponse;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by gcampos on 05/11/2015.
 */
public interface LoginInterface {

    @POST("/rest/Login")
    void addLogin(@Body Empleados empleado, Callback<LoginResponse> cb);





}
