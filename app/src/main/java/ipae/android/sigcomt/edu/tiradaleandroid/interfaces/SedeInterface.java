package ipae.android.sigcomt.edu.tiradaleandroid.interfaces;

import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Sedes;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by gcampos on 28/10/2015.
 */
public interface SedeInterface {

    @POST("/rest/addSede")
    void addSedes(@Body Sedes sedes, Callback<Sedes> cb);
    @GET("/rest/sedes")
    void listsede(Callback<List<Sedes>> cb);
}
