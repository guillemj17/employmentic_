package com.example.employmentic.fragments;

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
import com.example.employmentic.Empresa;
import com.example.employmentic.R;
import com.example.employmentic.database.MyDataBaseHelper;

import java.util.ArrayList;

public class FavFragment extends Fragment {

    RecyclerView recyclerview_empresasLiked;
    MyDataBaseHelper MyDB;
    ArrayList<String> id_vacante, nombre_vacante, nombreEmpresa_vacante,ubicacion_vacante, estudios_vacante, modalidad_vacante, salario_vacante, jornada_vacante, conocimientos_vacante;

    CustomAdapter customAdapter;

    public FavFragment() {

    }

    public static FavFragment newInstance() {
        FavFragment fragment = new FavFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerViewEmpresa = (RecyclerView) getView().findViewById(R.id.recyclerview_empresasLiked);

        // RecyclerView Empresas
        recyclerview_empresasLiked = (RecyclerView) view.findViewById(R.id.recyclerview_empresasLiked);


        MyDB = new MyDataBaseHelper(getContext());
        id_vacante = new ArrayList<>();
        nombre_vacante = new ArrayList<>();
        nombreEmpresa_vacante = new ArrayList<>();
        ubicacion_vacante = new ArrayList<>();
        estudios_vacante = new ArrayList<>();
        modalidad_vacante = new ArrayList<>();
        salario_vacante = new ArrayList<>();
        jornada_vacante = new ArrayList<>();
        conocimientos_vacante = new ArrayList<>();

        customAdapter = new CustomAdapter(getActivity(), id_vacante, nombre_vacante, nombreEmpresa_vacante,ubicacion_vacante,
                estudios_vacante, modalidad_vacante, salario_vacante, jornada_vacante, conocimientos_vacante);

        recyclerViewEmpresa.setAdapter(customAdapter);

        almacenardatosarray();
    }

    void almacenardatosarray() {

        Cursor cursor = MyDB.consultarFav();

        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "No hay registros", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                id_vacante.add(cursor.getString(0));
                nombre_vacante.add(cursor.getString(1));
                nombreEmpresa_vacante.add(cursor.getString(8));
                ubicacion_vacante.add(cursor.getString(2));
            }
        }

    }
}