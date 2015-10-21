package ipae.android.sigcomt.edu.tiradaleandroid.ws.empleados;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ipae.android.sigcomt.edu.tiradaleandroid.R;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import ipae.android.sigcomt.edu.tiradaleandroid.contantes.Constantes;
/**
 * Created by jpulido on 21/10/2015.
 */
public class EmpleadoWS extends ArrayAdapter {

    // Atributos
    private RequestQueue requestQueue;
    JsonArrayRequest jsArrayRequest;
    private static final String TAG = "PostAdapter";
    List<Empleados> empleados;

    public EmpleadoWS (Context context){
        super(context,0);

        // Crear nueva cola de peticiones
        requestQueue= Volley.newRequestQueue(context);

        // Nueva petición JSONObject
        jsArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                Constantes.URL_BASE + Constantes.URL_JSON_EMPLEADOS,
                (String)null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        empleados = parseJson(response);
                        notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());

                    }
                }
        );
        // Añadir petición a la cola
        requestQueue.add(jsArrayRequest);
    }

    @Override
    public int getCount() {
        return empleados != null ? empleados.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Referencia del view procesado
        View listItemView;

        //Comprobando si el View no existe
        listItemView = null == convertView ? layoutInflater.inflate(
                R.layout.empleado,
                parent,
                false) : convertView;


        // Obtener el item actual
        Empleados item = empleados.get(position);

        // Obtener Views
        TextView txtCodigoUsuario = (TextView) listItemView.
                findViewById(R.id.txtCodigoUsuario);
        TextView txtUsuario = (TextView) listItemView.
                findViewById(R.id.txtUsuario);
        TextView txtClave = (TextView) listItemView.
                findViewById(R.id.txtClave);

        // Actualizar los Views
        txtCodigoUsuario.setText(item.getIdUsuario().toString());
        txtUsuario.setText(item.getUsuario().toString());
        txtClave.setText(item.getClave().toString());


        // Añadir petición a la cola
        //requestQueue.add(request);


        return listItemView;
    }

    public List<Empleados> parseJson(JSONArray jsonObject){
        // Variables locales
        List<Empleados> posts = new ArrayList<>();
        JSONArray jsonArray= null;

        try {
            // Obtener el array del objeto
          //  jsonArray = jsonObject.getJSONArray("items");

           // JSONObject person = (JSONObject) response
             //       .get(i);

            for(int i=0; i<jsonObject.length(); i++){
                JSONObject objeto= jsonObject.getJSONObject(i);
                try {

                    Empleados post = new Empleados(
                            objeto.getInt("idUsuario"),
                            objeto.getString("usuario"),
                            objeto.getString("clave"));
                    posts.add(post);
                } catch (JSONException e) {
                    Log.e(TAG, "Error de parsing: "+ e.getMessage());
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }
}