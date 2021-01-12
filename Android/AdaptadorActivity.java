package com.example.joans.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class AdaptadorActivity extends ArrayAdapter{

    private Activity context;
    private List<DadesActivitat> datos;
    private final String tag = this.getClass().getCanonicalName();

    public AdaptadorActivity(Activity context, List<DadesActivitat> datos) {
        super(context, R.layout.textview_llista_projecte, datos);
        this.datos = datos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        TextView nombreActividad;
        TextView duracion;

        //Adaptador de Proyectos
        if (datos.get(position).isProjecte()) {

            convertView = inflater.inflate(R.layout.textview_llista_projecte, null);

            nombreActividad = convertView.findViewById(R.id.titulo_proyecto);
            duracion = convertView.findViewById(R.id.duracion_proyecto);
            final ImageView greenDot = convertView.findViewById(R.id.green_dot);

            nombreActividad.setText(datos.get(position).getNom());
            duracion.setText(datos.get(position).toString());

            if (datos.get(position).isActive()) {
                greenDot.setBackgroundResource(R.drawable.green_dot);
            }else{
                greenDot.setBackgroundResource(0);
            }
        }
        else
        {
            //Adaptador de separaciones
            if(datos.get(position).isHeader()){


                convertView = inflater.inflate(R.layout.textview_llista_header, null);

                nombreActividad = convertView.findViewById(R.id.titulo_header);

                nombreActividad.setText(datos.get(position).getNom());


            //Adaptador de Tareas
            }else {

                convertView = inflater.inflate(R.layout.textview_llista_tasca, null);

                nombreActividad = convertView.findViewById(R.id.titulo_tarea);
                duracion = convertView.findViewById(R.id.duracion_tarea);
                final Button buttonPlay = convertView.findViewById(R.id.play_button);

                nombreActividad.setText(datos.get(position).getNom());
                duracion.setText(datos.get(position).toString());


                if (datos.get(position).isCronometreEngegat()) {
                    buttonPlay.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_pause);
                    buttonPlay.setBackgroundResource(R.drawable.roundedbutton_border);
                }

                // Fer click al botó de play serveix per cronometrar, si es tracta d'una tasca.
                buttonPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inte;
                        if (!datos.get(position).isCronometreEngegat()) {
                            buttonPlay.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_pause);
                            buttonPlay.setBackgroundResource(R.drawable.roundedbutton_border);
                            inte = new Intent(
                                    LlistaActivitatsActivity.ENGEGA_CRONOMETRE);
                            Log.d(tag, "enviat intent ENGEGA_CRONOMETRE de "
                                    + datos.get(position).getNom());
                        } else {
                            inte = new Intent(
                                    LlistaActivitatsActivity.PARA_CRONOMETRE);
                            Log.d(tag, "enviat intent PARA_CRONOMETRE de "
                                    + datos.get(position).getNom());
                        }
                        inte.putExtra("posicio", position);
                        context.sendBroadcast(inte);
                    }
                });
            }
        }

        return convertView;
    }
}
