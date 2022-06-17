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
import android.widget.Toast;

import com.example.employmentic.CustomAdapter;
import com.example.employmentic.R;
import com.example.employmentic.database.MyDataBaseHelper;

import java.util.ArrayList;

public class EmpleoFragment extends Fragment {

    RecyclerView recyclerView;
    MyDataBaseHelper MyDB;
    ArrayList<String> id_vacante, nombreEmpleo, nombreEmpresa_vacante,tv_ubicacionEmpleo, estudios_vacante, modalidad_vacante, salario_vacante, jornada_vacante, conocimientos_vacante;

    CustomAdapter customAdapter;

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

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}