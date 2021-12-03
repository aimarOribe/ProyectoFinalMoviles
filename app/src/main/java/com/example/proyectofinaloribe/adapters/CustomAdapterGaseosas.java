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

import com.example.proyectofinaloribe.models.Gaseosa;
import com.example.proyectofinaloribe.R;

import java.util.ArrayList;

public class CustomAdapterGaseosas extends RecyclerView.Adapter<CustomAdapterGaseosas.CustomViewHolder> {

    private ArrayList<Gaseosa> listaGaseosas = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftd;

    public CustomAdapterGaseosas(ArrayList<Gaseosa> listaGaseosas, FragmentActivity myContext) {
        this.listaGaseosas = listaGaseosas;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillagaseosa,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Gaseosa gaseosa = listaGaseosas.get(position);
        holder.iv_imagen.setImageResource(gaseosa.getImagen());
        holder.tv_nombre.setText(gaseosa.getNombre());
        holder.tv_descripcion.setText(gaseosa.getDescripcion());
        String precio = String.valueOf(gaseosa.getPrecio());
        holder.tv_precio.setText("S/"+precio);
    }

    @Override
    public int getItemCount() {
        return listaGaseosas.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombre, tv_descripcion, tv_precio;
        private ImageView iv_imagen;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tvNombreGaseosa);
            tv_descripcion = itemView.findViewById(R.id.tvDescripcionGaseosa);
            tv_precio = itemView.findViewById(R.id.tvPrecioGaseosa);
            iv_imagen = itemView.findViewById(R.id.imagenGaseosa);
        }
    }
}
