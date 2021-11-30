package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaGaseosasFragment extends Fragment {

    private ArrayList<Gaseosa> listaGas = new ArrayList<>();
    private RecyclerView rv_gaseosas;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaGaseosas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lista_gaseosas, container, false);
        rv_gaseosas = v.findViewById(R.id.rv_listaGaseosas);
        setAdapter();
        return v;
    }

    public void llenarListaGaseosas(){
        listaGas.add(new Gaseosa(R.drawable.inkakola, "Inka Kola", "Personal",5.45f));
        listaGas.add(new Gaseosa(R.drawable.cocacola, "Coca Cola", "Personal",5.45f));
        listaGas.add(new Gaseosa(R.drawable.dasani, "Dasani", "Personal",8.99f));
        listaGas.add(new Gaseosa(R.drawable.fanta, "Fanta", "Personal",3.99f));
        listaGas.add(new Gaseosa(R.drawable.pepsi, "Pepsi", "Personal",6.50f));
        listaGas.add(new Gaseosa(R.drawable.schweppes, "Schweppes", "Personal",10.89f));
        listaGas.add(new Gaseosa(R.drawable.spritedoslitros, "Sprite", "Personal",4.99f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterGaseosas customAdapterGaseosas = new CustomAdapterGaseosas(listaGas, this.getActivity());
        rv_gaseosas.setLayoutManager(llm);
        rv_gaseosas.setAdapter(customAdapterGaseosas);
    }
}