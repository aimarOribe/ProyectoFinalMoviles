package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GaseosaSpriteFragment extends Fragment {

    private ArrayList<Sprite> listaSprite = new ArrayList<>();
    private RecyclerView rv_spri;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaSprite();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gaseosa_sprite, container, false);
        rv_spri = view.findViewById(R.id.rv_sprite);
        setAdapter();
        return view;
    }

    public void llenarListaSprite(){
        listaSprite.add(new Sprite(R.drawable.spritepersonal,"Sprite","Personal",2.50f));
        listaSprite.add(new Sprite(R.drawable.spritepersonalvidrio,"Sprite","Personal de Vidrio",3.10f));
        listaSprite.add(new Sprite(R.drawable.spritedoslitros,"Sprite","2 Litros",4.20f));
        listaSprite.add(new Sprite(R.drawable.spritedoslitrosmas25,"Sprite","2.25 Litros",6.80f));
        listaSprite.add(new Sprite(R.drawable.spritetreslitros,"Sprite","3 Litros",8.50f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapterSprite customAdapterSprite = new CustomAdapterSprite(listaSprite, this.getActivity());
        rv_spri.setLayoutManager(llm);
        rv_spri.setAdapter(customAdapterSprite);
    }
}