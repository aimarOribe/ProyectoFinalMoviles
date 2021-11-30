package com.example.proyectofinaloribe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

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