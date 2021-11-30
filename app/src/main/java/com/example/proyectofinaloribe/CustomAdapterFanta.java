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

public class CustomAdapterFanta extends RecyclerView.Adapter<CustomAdapterFanta.CustomViewHolder> {

    private ArrayList<Fanta> listafanta = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftfanta;

    public CustomAdapterFanta(ArrayList<Fanta> listafanta, FragmentActivity myContext) {
        this.listafanta = listafanta;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillafanta,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Fanta fanta = listafanta.get(position);
        holder.iv_imagenfanta.setImageResource(fanta.getImagen());
        holder.tv_marcafanta.setText(fanta.getMarca());
        holder.tv_nombrefanta.setText(fanta.getNombre());
        String precio = String.valueOf(fanta.getPrecio());
        holder.tv_preciofanta.setText("S/"+precio+"0");
    }

    @Override
    public int getItemCount() {
        return listafanta.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombrefanta, tv_marcafanta, tv_preciofanta;
        private ImageView iv_imagenfanta;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagenfanta = itemView.findViewById(R.id.imagenFanta);
            tv_marcafanta = itemView.findViewById(R.id.tvMarcaFanta);
            tv_nombrefanta = itemView.findViewById(R.id.tvNombreFanta);
            tv_preciofanta = itemView.findViewById(R.id.tvPrecioFanta);
        }
    }
}
