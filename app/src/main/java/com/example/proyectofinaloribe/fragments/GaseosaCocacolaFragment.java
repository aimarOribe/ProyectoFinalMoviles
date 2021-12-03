package com.example.proyectofinaloribe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.adapters.CustomAdapterCocaCola;
import com.example.proyectofinaloribe.models.CocaCola;

import java.util.ArrayList;

public class GaseosaCocacolaFragment extends Fragment {

    private ArrayList<CocaCola> listaCocaCola = new ArrayList<>();
    private RecyclerView rv_coca;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaCocaCola();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gaseosa_cocacola, container, false);
        rv_coca = view.findViewById(R.id.rv_cocacola);
        setAdapter();
        return view;
    }

    public void llenarListaCocaCola(){
        listaCocaCola.add(new CocaCola(R.drawable.cocacolalata,"Coca Cola","Lata",2.50f));
        listaCocaCola.add(new CocaCola(R.drawable.cocacolalitroymedio,"Coca Cola","1.5 Litros",3.10f));
        listaCocaCola.add(new CocaCola(R.drawable.cocacoladoslitros,"Coca Cola","2 Litros",6.20f));
        listaCocaCola.add(new CocaCola(R.drawable.cocacolatreslitros,"Coca Cola","3 Litros",8.80f));
        listaCocaCola.add(new CocaCola(R.drawable.cocacolapersonalplasctico,"Coca Cola","Personal",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterCocaCola customAdapterCocaCola = new CustomAdapterCocaCola(listaCocaCola,this.getActivity());
        rv_coca.setLayoutManager(llm);
        rv_coca.setAdapter(customAdapterCocaCola);
    }
}