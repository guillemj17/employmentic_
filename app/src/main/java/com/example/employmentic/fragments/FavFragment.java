package com.example.employmentic.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.employmentic.Empresa;
import com.example.employmentic.R;

public class FavFragment extends Fragment {

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

        Empresa[] empresas = {


                // Deben ir de tal forma que solo aparezcan aquellas likeadas en el otro fragment

//  Ejemplo        new Empresa("Google", "Madrid", R.drawable.ucjc),
        };



    }
}