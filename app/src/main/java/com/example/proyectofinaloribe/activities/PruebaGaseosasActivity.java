package com.example.proyectofinaloribe.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.fragments.ListaLogoGaseosasFragment;

public class PruebaGaseosasActivity extends AppCompatActivity {

    FragmentTransaction ftg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_gaseosas);
        //ListaGaseosasFragment listaGaseosasFragment = new ListaGaseosasFragment();
        ListaLogoGaseosasFragment listaLogoGaseosasFragment = new ListaLogoGaseosasFragment();
        ftg = getSupportFragmentManager().beginTransaction();
        //ftg.add(R.id.flayoutgaseosas, listaGaseosasFragment);
        ftg.add(R.id.flayoutgaseosas, listaLogoGaseosasFragment);
        ftg.commit();
    }
}