package com.example.proyectofinaloribe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinaloribe.models.Inkakola;
import com.example.proyectofinaloribe.R;

import java.util.ArrayList;

public class CustomAdapterInkakola extends RecyclerView.Adapter<CustomAdapterInkakola.CustomViewHolder> {

    private ArrayList<Inkakola> listaInkaKola = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftinkakola;

    public CustomAdapterInkakola(ArrayList<Inkakola> listaInkaKola, FragmentActivity myContext) {
        this.listaInkaKola = listaInkaKola;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillainkakola,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Inkakola inkakola = listaInkaKola.get(position);
        holder.iv_imageninkakola.setImageResource(inkakola.getImagen());
        holder.tv_marcainkakola.setText(inkakola.getMarca());
        holder.tv_nombreinkakola.setText(inkakola.getNombre());
        String precioString = String.valueOf(inkakola.getPrecio());
        holder.tv_precioinkakola.setText("S/"+precioString+"0");
    }

    @Override
    public int getItemCount() {
        return listaInkaKola.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombreinkakola, tv_marcainkakola, tv_precioinkakola;
        private ImageView iv_imageninkakola;

        public CustomViewHolder(@NonNull View itemView) {

            super(itemView);
            iv_imageninkakola = itemView.findViewById(R.id.imagenInkaKola);
            tv_marcainkakola = itemView.findViewById(R.id.tvMarcaInkakola);
            tv_nombreinkakola = itemView.findViewById(R.id.tvNombreInkaKola);
            tv_precioinkakola = itemView.findViewById(R.id.tvPrecioInkaKola);
        }
    }



}
