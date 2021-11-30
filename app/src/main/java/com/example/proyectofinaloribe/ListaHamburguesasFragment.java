package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaHamburguesasFragment extends Fragment {

    private ArrayList<Hamburguesa> listaHambur = new ArrayList<>();
    private RecyclerView rv_hamburguesa;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarLista();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lista_hamburguesas, container, false);
        rv_hamburguesa = v.findViewById(R.id.rv_listaHamburguesas);
        setAdapter();
        return v;
    }

    public void llenarLista(){
        listaHambur.add(new Hamburguesa("Royal","Una hamburguesa que tiene un poco de todo",12.4f,R.drawable.royal,200,17.80f, 13.5f));
        listaHambur.add(new Hamburguesa("Doble","Hamburguesa que tiene de todo doble, doble carne, doble huevo, todo doble",24.52f,R.drawable.doble,210,18.55f,8.8f));
        listaHambur.add(new Hamburguesa("Clasica","Una hamburguesa con los ingredientes escenciales al mejor precio, una hamburguesa sencilla",10.99f,R.drawable.clasica,200,15.99f,9.7f));
        listaHambur.add(new Hamburguesa("Doble Carne","Hamburguesa con doble carne y su porcion de ensalada al mejor precio",12.99f,R.drawable.doblecarne,199,13.6f,7.4f));
        listaHambur.add(new Hamburguesa("Doble Queso","Hamburguesa con doble queso y su porcion de ensalada al mejor precio",14.56f,R.drawable.doblequeso,197,14.12f,5.7f));
        listaHambur.add(new Hamburguesa("Pollo","Hamburguesa de pollo con su porcion de ensalada al mismo costo que la clasica",6.12f,R.drawable.pollo,210,18.5f,9.7f));
        listaHambur.add(new Hamburguesa("Vegana","Hamburguesa a base de plantas, todo a base de vegetales para las personas especiales",30.99f,R.drawable.vegana,159,20.55f,6.7f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapter customAdapter = new CustomAdapter(listaHambur, this.getActivity());
        rv_hamburguesa.setLayoutManager(llm);
        rv_hamburguesa.setAdapter(customAdapter);
    }
}