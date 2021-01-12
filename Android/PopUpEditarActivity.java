package com.example.joans.timetracker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

public class PopUpEditarActivity extends Activity {

    public static final String EDITAR_ACTIVITY = "Editar_activity";
    ImageButton btn_close;
    Button btn_guardar;
    EditText txt_nombre;
    EditText txt_descripcion;
    TextView txt_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_editar);

        /*Linkeamos cada variable a su botón correspondiente
         *  */
        txt_titulo = findViewById(R.id.titulo_editar_actividad);
        txt_nombre = (EditText) findViewById(R.id.et_nombre_actividad);
        txt_descripcion = (EditText) findViewById(R.id.et_descripcion_actividad);

        btn_close = (ImageButton) findViewById(R.id.btn_close);


        /*
         * Al clicar este botón se cierra el PopUp
         * */
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_guardar = (Button) findViewById(R.id.btn_guardar);

        /*
         * Al clickar añadir se modifica la actividad en el arbol de actividades y
         * se cierra el PopUp correspondiente
         * */

        Intent myIntent = getIntent();
        String tipo = myIntent.getStringExtra("tipo");
        String nombre = myIntent.getStringExtra("nombre");
        String descripcion = myIntent.getStringExtra("descripcion");

        txt_nombre.setText(nombre);
        txt_descripcion.setText(descripcion);

        //Se cambia el titulo segun si es un proyecto o tarea
        if(tipo.equals("Proyecto")){
            txt_titulo.setText("Editar Proyecto");
        }else{
            txt_titulo.setText("Editar Tarea");
        }

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre;
                String descripcion = "Sin descripcion";

                nombre = txt_nombre.getText().toString();
                descripcion = txt_descripcion.getText().toString();

                if(!nombre.equals("")){
                    Intent i = new Intent(PopUpEditarActivity.EDITAR_ACTIVITY);
                    i.putExtra("nombre",nombre);
                    i.putExtra("descripcion", descripcion);
                    sendBroadcast(i);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Introduce un nombre válido", Toast.LENGTH_SHORT).show();
                }

            }
        });

        /*
         * Creamos y personalizamos el PopUp
         * */

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width), (int)(height*.67));
        getWindow().setElevation(100);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }

}