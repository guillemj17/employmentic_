package com.example.employmentic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.employmentic.editables.passwordOlvidadaFragment;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_pwOlvidada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);


//       getSupportFragmentManager().beginTransaction().add(R.id.container, new passwordOlvidadaFragment()).commit();

        // variables
        tv_pwOlvidada = findViewById(R.id.tv_pwOlvidada);
        tv_pwOlvidada.setOnClickListener(this);

        // FrameLayout
        FrameLayout container = findViewById(R.id.container);

        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }

    @Override
    public void onClick(View view) {

        ((FrameLayout)findViewById(R.id.container)).removeAllViews();


        if (view.getId() == R.id.tv_pwOlvidada) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new passwordOlvidadaFragment())
                    .commit();
        }
    }
}