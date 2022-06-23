package com.example.employmentic.editables;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employmentic.CustomAdapter;
import com.example.employmentic.R;
import com.example.employmentic.database.MyDataBaseHelper;

import java.util.ArrayList;

public class EmpleoFragment extends Fragment {

    TextView nombre_empleo, ubicacion_empleo,estudios_empleo, modalidad_empleo, salario_empleo, jornada_empleo, conocimientos_empleo;
    Button btn_inscribir;
    ImageView imagen_empleo;
    String id, nombre, ubicacion, estudios, modalidad, salario, jornada, conocimientos;

    public EmpleoFragment() {
    }

    public static EmpleoFragment newInstance(String param1, String param2) {
        EmpleoFragment fragment = new EmpleoFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_empleo, container, false);

        imagen_empleo = (ImageView) view.findViewById(R.id.imagenEmpresaEmpleo);
        nombre_empleo = (TextView) view.findViewById(R.id.nombreEmpleo);
        ubicacion_empleo = (TextView) view.findViewById(R.id.tv_ubicacionEmpleo);
        estudios_empleo = (TextView) view.findViewById(R.id.tv_experienciaEmpleo);
        modalidad_empleo = (TextView) view.findViewById(R.id.tv_modalidadEmpleo);
        salario_empleo = (TextView) view.findViewById(R.id.tv_salarioEmpleo);
        jornada_empleo = (TextView) view.findViewById(R.id.tv_jornadaEmpleo);
        conocimientos_empleo = (TextView) view.findViewById(R.id.tv_conocimientosEmpleo);
        btn_inscribir = (Button) view.findViewById(R.id.btn_inscribirse);

        recuperarDatosIntent();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    void recuperarDatosIntent() {

        if (requireActivity().getIntent().hasExtra("id") && requireActivity().getIntent().hasExtra("nombre") &&
                requireActivity().getIntent().hasExtra("ubicacion") && requireActivity().getIntent().hasExtra("estudios")
                && requireActivity().getIntent().hasExtra("modalidad") && requireActivity().getIntent().hasExtra("salario")
                && requireActivity().getIntent().hasExtra("jornada") && requireActivity().getIntent().hasExtra("conocimientos")) {

            id = requireActivity().getIntent().getStringExtra("id");
            nombre = requireActivity().getIntent().getStringExtra("nombre");
            ubicacion = requireActivity().getIntent().getStringExtra("ubicacion");
            estudios = requireActivity().getIntent().getStringExtra("estudios");
            modalidad = requireActivity().getIntent().getStringExtra("modalidad");
            salario = requireActivity().getIntent().getStringExtra("salario");
            jornada = requireActivity().getIntent().getStringExtra("jornada");
            conocimientos = requireActivity().getIntent().getStringExtra("conocimientos");

            nombre_empleo.setText(nombre);
            ubicacion_empleo.setText(ubicacion);
            estudios_empleo.setText(estudios);
            modalidad_empleo.setText(modalidad);
            salario_empleo.setText(salario);
            jornada_empleo.setText(jornada);
            conocimientos_empleo.setText(conocimientos);
        } else {
        }
    }
}