package com.example.employmentic.editables;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.employmentic.R;

public class addEmpleo extends Fragment {

    public addEmpleo() {

    }

    public static addEmpleo newInstance(String param1, String param2) {
        addEmpleo fragment = new addEmpleo();
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
        return inflater.inflate(R.layout.fragment_add_empleo, container, false);
    }
}