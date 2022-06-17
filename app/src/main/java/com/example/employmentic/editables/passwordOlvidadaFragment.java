package com.example.employmentic.editables;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.employmentic.R;

public class passwordOlvidadaFragment extends Fragment {

    public passwordOlvidadaFragment() {

    }

    public static passwordOlvidadaFragment newInstance(String param1, String param2) {
        passwordOlvidadaFragment fragment = new passwordOlvidadaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_password_olvidada, container, false);

        Button btn_aceptar = (Button) view.findViewById(R.id.btn_aceptar);
        EditText et_email = (EditText) view.findViewById(R.id.et_email_forg);
        EditText et_dni = (EditText) view.findViewById(R.id.et_dni_forg);

        // Campos deshabilitados
        EditText et_nuevapass1 = (EditText) view.findViewById(R.id.et_nuevapass1);
        EditText et_nuevapass2 = (EditText) view.findViewById(R.id.et_nuevapass2);
        Button btn_confirmar = (Button) view.findViewById(R.id.btn_confirmarpass);

        et_nuevapass1.setVisibility(View.INVISIBLE);
        et_nuevapass2.setVisibility(View.INVISIBLE);
        btn_confirmar.setVisibility(View.INVISIBLE);


        // OnClick el botón
        btn_aceptar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (v == btn_aceptar) {

                    // Si los campos coinciden:
                    // Mientras tanto con que email = DNI, irá a la siguiente pantalla
                    if(et_dni.getText().toString().equals(et_email.getText().toString())){

                        // Se habilitan dos nuevos campos, los cuales serán la nueva contraseña
                        et_dni.setVisibility(View.INVISIBLE);
                        et_email.setVisibility(View.INVISIBLE);
                        btn_aceptar.setVisibility(View.INVISIBLE);

                        et_nuevapass1.setVisibility(View.VISIBLE);
                        et_nuevapass2.setVisibility(View.VISIBLE);
                        btn_confirmar.setVisibility(View.VISIBLE);

                    } else{

                        Toast.makeText(getContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show(); //Correcto

                    }
                }
            }
        });

        return view;
    }
}