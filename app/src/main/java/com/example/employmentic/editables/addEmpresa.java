package com.example.employmentic.editables;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.employmentic.R;


public class addEmpresa extends Fragment {


    public addEmpresa() {

    }

    public static addEmpresa newInstance() {
        addEmpresa fragment = new addEmpresa();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_empresa, container, false);
    }
}