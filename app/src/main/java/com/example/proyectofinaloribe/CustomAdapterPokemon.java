package com.example.proyectofinaloribe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.proyectofinaloribe.models.Pokemon;

import java.util.ArrayList;

public class CustomAdapterPokemon extends RecyclerView.Adapter<CustomAdapterPokemon.CustomViewPokemon> {

    private ArrayList<Pokemon> dataset;
    private Context context;

    public CustomAdapterPokemon(Context context) {
        this.context = context;
        this.dataset = new ArrayList<>();
    }

    @Override
    public CustomViewPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillapokemon,parent,false);
        return new CustomViewPokemon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewPokemon holder, int position) {
        Pokemon p = dataset.get(position);
        holder.tv_nombrepokemon.setText(p.getName());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+p.getNumber()+".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iv_pokemon);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }


    public static class CustomViewPokemon extends RecyclerView.ViewHolder{

        private ImageView iv_pokemon;
        private TextView tv_nombrepokemon;

        public CustomViewPokemon(@NonNull View itemView) {
            super(itemView);
            iv_pokemon = itemView.findViewById(R.id.imagenPokemon);
            tv_nombrepokemon = itemView.findViewById(R.id.nombrePokemon);
        }
    }
}
