package ipae.android.sigcomt.edu.tiradaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by jpulido on 19/10/2015.
 */
public class EscogerUniversidad extends AppCompatActivity {

    Integer jugada1 = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escogeruniversidad);
        //universidades_array

        final Spinner spinner = (Spinner)findViewById(R.id.spnUniversidad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.universidades_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String spinnerString = spinner.getSelectedItem().toString();
                int nPos = spinner.getSelectedItemPosition();
                 if(jugada1 > 0 ){
                     Intent intObj = new Intent(EscogerUniversidad.this,Acciones.class);
                     intObj.putExtra("txtColegio",spinnerString);
                     startActivity(intObj);
                 }
                jugada1++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public Integer getJugada1() {
        return jugada1;
    }

    public void setJugada1(Integer jugada1) {
        this.jugada1 = jugada1;
    }
}
