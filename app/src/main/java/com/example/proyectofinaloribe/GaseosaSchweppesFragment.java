package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GaseosaSchweppesFragment extends Fragment {

    private ArrayList<Schweppes> listaSchweppes = new ArrayList<>();
    private RecyclerView rv_schwe;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaSchweppes();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaseosa_schweppes, container, false);
        rv_schwe = view.findViewById(R.id.rv_schweppes);
        setAdapter();
        return view;
    }

    public void llenarListaSchweppes(){
        listaSchweppes.add(new Schweppes(R.drawable.schweppeslatanuevo,"Schweppes","Lata",2.50f));
        listaSchweppes.add(new Schweppes(R.drawable.schweppespersonal,"Schweppes","Personal",3.10f));
        listaSchweppes.add(new Schweppes(R.drawable.shweppespersonalvidrio,"Schweppes","Personal de Vidrio",4.20f));
        listaSchweppes.add(new Schweppes(R.drawable.schweppesdoslitroscon25,"Schweppes","2.25 Litros",6.80f));
        listaSchweppes.add(new Schweppes(R.drawable.schweppestreslitros,"Schweppes","3 Litros",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterSchweppes customAdapterSchweppes = new CustomAdapterSchweppes(listaSchweppes, this.getActivity());
        rv_schwe.setLayoutManager(llm);
        rv_schwe.setAdapter(customAdapterSchweppes);
    }
}