package com.example.proyectofinaloribe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.adapters.CustomAdapterDasani;
import com.example.proyectofinaloribe.models.Dasani;

import java.util.ArrayList;

public class GaseosaDanasiFragment extends Fragment {

    private ArrayList<Dasani> listadasani = new ArrayList<>();
    private RecyclerView rv_das;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaDasani();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gaseosa_danasi, container, false);
        rv_das = view.findViewById(R.id.rv_dasani);
        setAdapter();
        return view;
    }

    public void llenarListaDasani(){
        listadasani.add(new Dasani(R.drawable.dasanilata,"Dasani","Lata Sparkling",2.50f));
        listadasani.add(new Dasani(R.drawable.dasanicongas,"Dasani","Lata Con Gas",3.10f));
        listadasani.add(new Dasani(R.drawable.dasani990ml,"Dasani","990 mililitros",4.20f));
        listadasani.add(new Dasani(R.drawable.dasani2litros,"Dasani","2 Litros",6.80f));
        listadasani.add(new Dasani(R.drawable.dasanitreslitros,"Dasani","3 Litros",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterDasani customAdapterDasani = new CustomAdapterDasani(listadasani, this.getActivity());
        rv_das.setLayoutManager(llm);
        rv_das.setAdapter(customAdapterDasani);
    }
}