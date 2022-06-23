package com.example.employmentic.editables;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.employmentic.MenuPrincipalActivity;
import com.example.employmentic.R;
import com.example.employmentic.database.MyDataBaseHelper;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class VacanteFragment extends Fragment {

    EditText et_nombre, et_ubicacion, et_estudios, et_modalidad,
    et_salario, et_jornada, et_conocimientos, et_nombre_empresa;
    Button btn_registrar;
    Integer guardado = 0;

    public VacanteFragment() {

    }

    public static VacanteFragment newInstance(String param1, String param2) {
        VacanteFragment fragment = new VacanteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vacante,
                container, false);
        et_nombre = (EditText) view.findViewById(R.id.idNombreVacante);
        et_nombre_empresa = (EditText) view.findViewById(R.id.idNombreEmpresa);
        et_ubicacion = (EditText) view.findViewById(R.id.idUbicacionVacante);
        et_estudios = (EditText) view.findViewById(R.id.idEstudiosVacante);
        et_modalidad = (EditText) view.findViewById(R.id.idModalidadVacante);
        et_salario = (EditText) view.findViewById(R.id.idSalarioVacante);
        et_jornada = (EditText) view.findViewById(R.id.idJornadaVacante);
        et_conocimientos = (EditText) view.findViewById(R.id.idConocimientosVacante);
        btn_registrar = (CircularProgressButton) view.findViewById(R.id.btn_registrarVacante);

        btn_registrar .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDataBaseHelper MyDB = new MyDataBaseHelper(getContext());
                MyDB.guardar(et_nombre.getText().toString(),
                        et_nombre_empresa.getText().toString(),
                        et_ubicacion.getText().toString(),
                        et_estudios.getText().toString(),
                        et_modalidad.getText().toString(),
                        et_salario.getText().toString(),
                        et_jornada.getText().toString(),
                        et_conocimientos.getText().toString(), guardado);
            }
        });

        return view;
    }
}