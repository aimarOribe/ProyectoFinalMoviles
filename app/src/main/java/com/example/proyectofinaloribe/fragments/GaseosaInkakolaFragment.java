package com.example.proyectofinaloribe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinaloribe.models.Inkakola;
import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.adapters.CustomAdapterInkakola;

import java.util.ArrayList;

public class GaseosaInkakolaFragment extends Fragment {

    private ArrayList<Inkakola> listaInkaKola = new ArrayList<>();
    private RecyclerView rv_inka;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaInkakola();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaseosa_inkakola, container, false);
        rv_inka = view.findViewById(R.id.rv_inkakola);
        setAdapter();
        return view;
    }

    public void llenarListaInkakola(){
        listaInkaKola.add(new Inkakola(R.drawable.inkakolapersonal,"Inka Kola","Personal",2.50f));
        listaInkaKola.add(new Inkakola(R.drawable.inkakolagordita,"Inka Kola","Gordita",3.10f));
        listaInkaKola.add(new Inkakola(R.drawable.inkakolalitroymedio,"Inka Kola","1.5 Litros",4.20f));
        listaInkaKola.add(new Inkakola(R.drawable.inkakoladoslitros,"Inka Kola","2 Litros",6.80f));
        listaInkaKola.add(new Inkakola(R.drawable.inkakolatreslitros,"Inka Kola","3 Litros",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterInkakola customAdapterInkakola = new CustomAdapterInkakola(listaInkaKola, this.getActivity());
        rv_inka.setLayoutManager(llm);
        rv_inka.setAdapter(customAdapterInkakola);
    }
}