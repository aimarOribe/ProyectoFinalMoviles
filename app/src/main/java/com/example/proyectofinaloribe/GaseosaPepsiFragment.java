package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GaseosaPepsiFragment extends Fragment {

    private ArrayList<Pepsi> listaPepsi = new ArrayList<>();
    private RecyclerView rv_pep;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaPepsi();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaseosa_pepsi, container, false);
        rv_pep = view.findViewById(R.id.rv_pepsi);
        setAdapter();
        return view;
    }

    public void llenarListaPepsi(){
        listaPepsi.add(new Pepsi(R.drawable.pepsilata,"Pepsi","Lata",2.50f));
        listaPepsi.add(new Pepsi(R.drawable.pepsicero,"Pepsi","Lata Cero",3.10f));
        listaPepsi.add(new Pepsi(R.drawable.pepsipersonal,"Pepsi","Personal",4.20f));
        listaPepsi.add(new Pepsi(R.drawable.pepsilitroymedio,"Pepsi","1.5 Litros",6.80f));
        listaPepsi.add(new Pepsi(R.drawable.pepsitreslitros,"Pepsi","3 Litros",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterPepsi customAdapterPepsi = new CustomAdapterPepsi(listaPepsi, this.getActivity());
        rv_pep.setLayoutManager(llm);
        rv_pep.setAdapter(customAdapterPepsi);
    }
}