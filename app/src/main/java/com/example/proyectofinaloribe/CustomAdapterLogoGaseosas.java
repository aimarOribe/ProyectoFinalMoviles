package com.example.proyectofinaloribe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterLogoGaseosas extends RecyclerView.Adapter<CustomAdapterLogoGaseosas.CustomViewHolder> {

    private ArrayList<Logogaseosa> listalogos = new ArrayList<>();
    private FragmentTransaction ftl;
    private FragmentActivity myContext;

    public CustomAdapterLogoGaseosas(ArrayList<Logogaseosa> listalogos, FragmentActivity myContext) {
        this.listalogos = listalogos;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillalogogaseosas,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Logogaseosa logogaseosa = listalogos.get(position);
        holder.iv_logo.setImageResource(logogaseosa.getLogo());
        holder.iv_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        GaseosaInkakolaFragment gaseosaInkakolaFragment = new GaseosaInkakolaFragment();
                        FragmentTransaction ftgi = myContext.getSupportFragmentManager().beginTransaction();
                        ftgi.replace(R.id.flayoutgaseosas, gaseosaInkakolaFragment);
                        ftgi.addToBackStack(null);
                        ftgi.commit();
                        break;
                    case 1:
                        GaseosaCocacolaFragment gaseosaCocacolaFragment = new GaseosaCocacolaFragment();
                        FragmentTransaction ftgc = myContext.getSupportFragmentManager().beginTransaction();
                        ftgc.replace(R.id.flayoutgaseosas, gaseosaCocacolaFragment);
                        ftgc.addToBackStack(null);
                        ftgc.commit();
                        break;
                    case 2:
                        GaseosaFantaFragment gaseosaFantaFragment = new GaseosaFantaFragment();
                        FragmentTransaction ftgf = myContext.getSupportFragmentManager().beginTransaction();
                        ftgf.replace(R.id.flayoutgaseosas, gaseosaFantaFragment);
                        ftgf.addToBackStack(null);
                        ftgf.commit();
                        break;
                    case 3:
                        GaseosaPepsiFragment gaseosaPepsiFragment = new GaseosaPepsiFragment();
                        FragmentTransaction ftgp = myContext.getSupportFragmentManager().beginTransaction();
                        ftgp.replace(R.id.flayoutgaseosas, gaseosaPepsiFragment);
                        ftgp.addToBackStack(null);
                        ftgp.commit();
                        break;
                    case 4:
                        GaseosaDanasiFragment gaseosaDanasiFragment = new GaseosaDanasiFragment();
                        FragmentTransaction ftgd = myContext.getSupportFragmentManager().beginTransaction();
                        ftgd.replace(R.id.flayoutgaseosas, gaseosaDanasiFragment);
                        ftgd.addToBackStack(null);
                        ftgd.commit();
                        break;
                    case 5:
                        GaseosaSchweppesFragment gaseosaSchweppesFragment = new GaseosaSchweppesFragment();
                        FragmentTransaction ftgs = myContext.getSupportFragmentManager().beginTransaction();
                        ftgs.replace(R.id.flayoutgaseosas, gaseosaSchweppesFragment);
                        ftgs.addToBackStack(null);
                        ftgs.commit();
                        break;
                    case 6:
                        GaseosaSpriteFragment gaseosaSpriteFragment = new GaseosaSpriteFragment();
                        FragmentTransaction ftgsp = myContext.getSupportFragmentManager().beginTransaction();
                        ftgsp.replace(R.id.flayoutgaseosas, gaseosaSpriteFragment);
                        ftgsp.addToBackStack(null);
                        ftgsp.commit();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listalogos.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_logo;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_logo = itemView.findViewById(R.id.imagenlogogaseosa);
        }
    }
}
