package com.example.proyectofinaloribe.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.fragments.ContactoFragment;

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