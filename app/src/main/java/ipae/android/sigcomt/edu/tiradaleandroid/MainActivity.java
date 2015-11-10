package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ipae.android.sigcomt.edu.tiradaleandroid.Response.LoginResponse;
import ipae.android.sigcomt.edu.tiradaleandroid.interfaces.LoginInterface;
import ipae.android.sigcomt.edu.tiradaleandroid.modelos.Empleados;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    Button btnIngresar;
    EditText txtUsuario;
    EditText txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtClave=(EditText)findViewById(R.id.txtClave);
        btnIngresar=(Button)findViewById(R.id.button);

        //Listener

        btnIngresar.setOnClickListener(new ButtonOnClick());

    }



    public class ButtonOnClick implements View.OnClickListener{

        public void onClick(View view){

            String param1 = txtUsuario.getText().toString();
            String param2 = txtClave.getText().toString();
            postData(param1, param2);
            Intent intObj = new Intent(MainActivity.this, Home.class);
            startActivity(intObj);

            //if (param1.equals("galo") && param2.equals("campos")) {

            //}
           // else {
               // Context context = getApplicationContext();
               // CharSequence text = "Ingreso Incorrecto";
               // int duration = Toast.LENGTH_SHORT;

               // Toast toast = Toast.makeText(context, text, duration);
               // toast.show();
            //}

        }
    }


    private void postData(final String param1, final String param2){
        String url = "http://10.0.3.2:8088/Farmacia";
        RestAdapter vehicleAdapter = new RestAdapter.Builder().setEndpoint(
                url).build();

        //create an instance of the VehicleAPIService.
       LoginInterface vehicleService = vehicleAdapter
                .create(LoginInterface.class);

        //create a new vehicle
        Empleados newVehicle = new Empleados();
        newVehicle.setUsuario(param1);
        newVehicle.setClave(param2);


        //call the service to add the new vehicle
        vehicleService.addLogin(newVehicle, new Callback<LoginResponse>(){
            @Override
            public void success(LoginResponse loginResponse, Response response) {


                if( loginResponse.getSucces().booleanValue()) {
                    Object IdUsuario=loginResponse.getValor();
                    Intent intObj = new Intent(MainActivity.this, Home.class);
                    startActivity(intObj);

                }
                else{Context context = getApplicationContext();
                     CharSequence text = "Usuario o Contraseña Incorrecto";
                     int duration = Toast.LENGTH_SHORT;

                     Toast toast = Toast.makeText(context, text, duration);
                     toast.show();}
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });






}









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
