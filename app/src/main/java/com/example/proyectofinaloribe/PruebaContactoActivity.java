package com.example.proyectofinaloribe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class PruebaContactoActivity extends AppCompatActivity {

    FragmentTransaction ftc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_contacto);
        ContactoFragment contactoFragment = new ContactoFragment();
        ftc = getSupportFragmentManager().beginTransaction();
        ftc.add(R.id.flayoutcontacto, contactoFragment);
        ftc.commit();
    }

}