package com.example.proyectofinaloribe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

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