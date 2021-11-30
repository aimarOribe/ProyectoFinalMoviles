package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GaseosaFantaFragment extends Fragment {

    private ArrayList<Fanta> listafanta = new ArrayList<>();
    private RecyclerView rv_fan;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaFanta();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gaseosa_fanta, container, false);
        rv_fan = view.findViewById(R.id.rv_fanta);
        setAdapter();
        return view;
    }

    public void llenarListaFanta(){
        listafanta.add(new Fanta(R.drawable.fantalata,"Fanta","Lata",2.50f));
        listafanta.add(new Fanta(R.drawable.fantapersonal,"Fanta","Personal",3.10f));
        listafanta.add(new Fanta(R.drawable.fantalitroymedio,"Fanta","1.5 Litros",4.20f));
        listafanta.add(new Fanta(R.drawable.fantadoslitros,"Fanta","2 Litros",6.80f));
        listafanta.add(new Fanta(R.drawable.fantatreslitros,"Fanta","3 Litros",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterFanta customAdapterFanta = new CustomAdapterFanta(listafanta, this.getActivity());
        rv_fan.setLayoutManager(llm);
        rv_fan.setAdapter(customAdapterFanta);
    }
}