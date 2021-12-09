package com.example.proyectofinaloribe.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.fragments.ListaHamburguesasFragment;

public class PruebaHomeActivity extends AppCompatActivity {
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_home);
        ListaHamburguesasFragment listaHamburguesasFragment = new ListaHamburguesasFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.flayout, listaHamburguesasFragment);
        ft.commit();
    }
}