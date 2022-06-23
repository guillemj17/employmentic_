package com.example.employmentic.editables;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employmentic.MenuPrincipalActivity;
import com.example.employmentic.R;
import com.example.employmentic.fragments.ProfileFragment;

public class changeEmailFragment extends Fragment {

    EditText nuevoEmail1, nuevoEmail2;
    String email, email2;
    Button btn_confirmar;

    public changeEmailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_email,
                container, false);

        nuevoEmail1 = (EditText) view.findViewById(R.id.et_email1);
        nuevoEmail2 = (EditText) view.findViewById(R.id.et_email2);
        btn_confirmar = (Button) view.findViewById(R.id.btn_aceptar);

        String valueEmail1 = nuevoEmail1.getText().toString();
        String valueEmail2 = nuevoEmail2.getText().toString();

        email = nuevoEmail1.getText().toString();
        email2 = nuevoEmail2.getText().toString();

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email == email2){

                    // Cerrar fragment y pasar el nuevo email

                    Log.i("Email 1", valueEmail1);
                    Log.i("Email 2", valueEmail2);

                    Toast.makeText(getActivity(), "Correo cambiado correctamente",
                            Toast.LENGTH_LONG).show();

                    getActivity().getFragmentManager().popBackStack();

                } else {

                    Toast.makeText(getActivity(), "Los correos no coinciden",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
        return view;
    }
}