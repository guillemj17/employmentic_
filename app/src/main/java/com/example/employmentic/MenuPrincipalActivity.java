package com.example.employmentic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.employmentic.editables.addEmpresa;
import com.example.employmentic.fragments.FavFragment;
import com.example.employmentic.fragments.HomeFragment;
import com.example.employmentic.fragments.ProfileFragment;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener {
    //Inicializar variable
    MeowBottomNavigation bottomNavigation;

    ImageButton btn_edit_email;
    ToggleButton favButton;
    String email_ejemplo = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Asigno variable
        bottomNavigation = findViewById(R.id.bottom_navigation);

        //Añadimos el item al menú
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_fav));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_profile));

        Bundle bundle = new Bundle();
        bundle.putString("message", "From Activity");

        // Set Fragmentclass Arguments
        ProfileFragment email = new ProfileFragment();
        email.setArguments(bundle);

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //Inicializamos fragmento
                Fragment fragment = null;

                //Chequeamos las condiciones
                switch (item.getId()) {
                    case 1:
                        //Cuando el ID sea 1 inicializamos el FavFragment
                        fragment = new FavFragment();
                        break;
                    case 2:
                        //Cuando el ID sea 2 inicalizamos el HomeFragment
                        fragment = new HomeFragment();
                        break;
                    case 3:
                        //Cuando el ID sea 3 inicializamos el ProfileFragment
                        fragment = new ProfileFragment();
                        break;
                }
                //Cargamos los fragmentos
                loadFragment(fragment);
            }
        });

        //Establecemos los contadores
        //bottomNavigation.setCount(1,"");

        //Establecemos homeFragment al iniciar activity
        bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });

    }

    private void loadFragment(Fragment fragment) {

        //Reemplazamos fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment).commit();
    }

    public void onCustomToggleClick(View view) {

    }


    @Override
    public void onClick(View view) {


    }
}