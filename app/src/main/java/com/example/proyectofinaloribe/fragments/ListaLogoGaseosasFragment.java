package com.example.proyectofinaloribe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinaloribe.models.Logogaseosa;
import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.adapters.CustomAdapterLogoGaseosas;

import java.util.ArrayList;

public class ListaLogoGaseosasFragment extends Fragment {

    private ArrayList<Logogaseosa> listaLogo = new ArrayList<>();
    private RecyclerView rv_logogas;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarlistalogo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista_logo_gaseosas, container, false);
        rv_logogas = view.findViewById(R.id.rv_listalogogaseosas);
        setAdapter();
        return view;
    }

    public void llenarlistalogo(){
        listaLogo.add(new Logogaseosa(R.drawable.logoinkakola));
        listaLogo.add(new Logogaseosa(R.drawable.logococacola));
        listaLogo.add(new Logogaseosa(R.drawable.logofanta));
        listaLogo.add(new Logogaseosa(R.drawable.logopepsi));
        listaLogo.add(new Logogaseosa(R.drawable.logodasani));
        listaLogo.add(new Logogaseosa(R.drawable.logoschweppes));
        listaLogo.add(new Logogaseosa(R.drawable.logosprite));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterLogoGaseosas customAdapterLogoGaseosas = new CustomAdapterLogoGaseosas(listaLogo, this.getActivity());
        rv_logogas.setLayoutManager(llm);
        rv_logogas.setAdapter(customAdapterLogoGaseosas);
    }
}