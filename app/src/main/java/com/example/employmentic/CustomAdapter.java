package com.example.employmentic;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsService;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employmentic.database.MyDataBaseHelper;
import com.example.employmentic.editables.EmpleoFragment;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList id_vacante, nombre_vacante, nombreEmpresa_vacante,ubicacion_vacante, estudios_vacante, modalidad_vacante, salario_vacante, jornada_vacante, conocimientos_vacante;;
    private Context context;
    MyDataBaseHelper MyDB;

    public CustomAdapter(Context context, ArrayList<String> id_vacante, ArrayList<String> nombre_vacante, ArrayList<String> nombreEmpresa_vacante,ArrayList<String> ubicacion_vacante,
                         ArrayList<String> estudios_vacante, ArrayList<String> modalidad_vacante, ArrayList<String> salario_vacante,
                         ArrayList<String> jornada_vacante, ArrayList<String> conocimientos_vacante) {

        this.context = context;
        this.id_vacante = id_vacante;
        this.nombre_vacante = nombre_vacante;
        this.nombreEmpresa_vacante = nombreEmpresa_vacante;
        this.ubicacion_vacante = ubicacion_vacante;
        this.estudios_vacante = estudios_vacante;
        this.modalidad_vacante = modalidad_vacante;
        this.salario_vacante = salario_vacante;
        this.jornada_vacante = jornada_vacante;
        this.conocimientos_vacante = conocimientos_vacante;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empresa, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nombre_vacante_textview.setText(String.valueOf(nombre_vacante.get(position)));
        holder.nombreEmpresa_vacante_textview.setText(String.valueOf(nombreEmpresa_vacante.get(position)));
        holder.ubicacion_vacante_textview.setText((String.valueOf(ubicacion_vacante.get(position))));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                EmpleoFragment empleoFragment = new EmpleoFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec,empleoFragment).addToBackStack(null).commit();

            }
        });

        holder.favButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {


                    Toast.makeText(buttonView.getContext(), "Guardado!",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return id_vacante.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id_vacante_textview, nombre_vacante_textview, nombreEmpresa_vacante_textview,
                ubicacion_vacante_textview, estudios_vacante_textview, modalidad_vacante_textview,
                salario_vacante_textview, jornada_vacante_textview, conocimientos_vacante_textview;
        ToggleButton favButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre_vacante_textview = itemView.findViewById(R.id.tv_nombreVacante);
            nombreEmpresa_vacante_textview = itemView.findViewById(R.id.tv_nombreEmpresa);
            ubicacion_vacante_textview = itemView.findViewById(R.id.ubicacionEmpresa);
            favButton = itemView.findViewById(R.id.favButton);

        }
    }
}
