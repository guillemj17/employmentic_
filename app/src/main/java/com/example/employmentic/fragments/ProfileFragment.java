package com.example.employmentic.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.employmentic.R;
import com.example.employmentic.editables.SettingsFragment;
import com.example.employmentic.editables.VacanteFragment;
import com.example.employmentic.editables.addEmpresa;
import com.example.employmentic.editables.changeEmailFragment;
import com.example.employmentic.editables.changePasswordFragment;
import com.example.employmentic.editables.faqFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileFragment extends Fragment {

    FloatingActionButton fab, fab1, fab2, fab3;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    public ProfileFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,
                container, false);
        ImageButton edit_password_button = (ImageButton) view.findViewById(R.id.edit_password);
        ImageButton edit_email_button = (ImageButton) view.findViewById(R.id.edit_email);

        // FAB
        fab = (FloatingActionButton) view.findViewById(R.id.fab_button);
        fab1 = (FloatingActionButton) view.findViewById(R.id.fab_empresa);
        fab2 = (FloatingActionButton) view.findViewById(R.id.fab_help);
        fab3 = (FloatingActionButton) view.findViewById(R.id.fab_vacante);

        // Animations
        fabOpen = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);
        rotateBackward = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_backward);
        rotateForward = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_forward);

        // Edit password
        edit_password_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (v == edit_password_button) {

                    // Creación de los fragmentos
                    Fragment changePasswordFragment = new changePasswordFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.frame_layout, changePasswordFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }
        });

        // Edit email
        edit_email_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (v == edit_email_button) {

                    // Creación de los fragmentos
                    Fragment changeEmailFragment = new changeEmailFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.frame_layout, changeEmailFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }
        });

        // FAB
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                animateFab();

            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fab1", Toast.LENGTH_SHORT).show();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fab2", Toast.LENGTH_SHORT).show();
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fab3", Toast.LENGTH_SHORT).show();
            }
        });

        // Fab crear empresa
        fab1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (v == fab1) {

                    // Creación de los fragmentos
                    Fragment addEmpresa = new addEmpresa();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.frame_layout, addEmpresa);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }
        });

        // Fab preguntas
        fab2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (v == fab2) {

                    // Creación de los fragmentos
                    Fragment faqFragment = new faqFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.frame_layout, faqFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }
        });

        //Fab crear vacante
        fab3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (v == fab3) {

                    // Creación de los fragmentos
                    Fragment VacanteFragment = new VacanteFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.frame_layout, VacanteFragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
            }
        });
        return view;
    }

    private void animateFab() {

        if(isOpen) {

            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isOpen = false;

        } else {

            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isOpen = true;

        }
    }
}