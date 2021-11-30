package com.example.proyectofinaloribe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterCocaCola extends RecyclerView.Adapter<CustomAdapterCocaCola.CustomViewHolder> {

    private ArrayList<CocaCola> listacocacola = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftcocacola;

    public CustomAdapterCocaCola(ArrayList<CocaCola> listacocacola, FragmentActivity myContext) {
        this.listacocacola = listacocacola;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillacocacola,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        CocaCola cocaCola = listacocacola.get(position);
        holder.iv_imagencocacola.setImageResource(cocaCola.getImagen());
        holder.tv_marcacocacola.setText(cocaCola.getMarca());
        holder.tv_nombrecocacola.setText(cocaCola.getNombre());
        String precio = String.valueOf(cocaCola.getPrecio());
        holder.tv_preciococacola.setText("S/"+precio+"0");
    }

    @Override
    public int getItemCount() {
        return listacocacola.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombrecocacola, tv_marcacocacola, tv_preciococacola;
        private ImageView iv_imagencocacola;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagencocacola = itemView.findViewById(R.id.imagenCocaCola);
            tv_marcacocacola = itemView.findViewById(R.id.tvMarcaCocaCola);
            tv_nombrecocacola = itemView.findViewById(R.id.tvNombreCocaCola);
            tv_preciococacola = itemView.findViewById(R.id.tvPrecioCocaCola);
        }
    }
}
