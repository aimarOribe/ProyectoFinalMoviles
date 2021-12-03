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

import com.example.proyectofinaloribe.models.Dasani;
import com.example.proyectofinaloribe.R;

import java.util.ArrayList;

public class CustomAdapterDasani extends RecyclerView.Adapter<CustomAdapterDasani.CustomViewHolder> {

    private ArrayList<Dasani> listadasani = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftdasani;

    public CustomAdapterDasani(ArrayList<Dasani> listadasani, FragmentActivity myContext) {
        this.listadasani = listadasani;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilladasani,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Dasani dasani = listadasani.get(position);
        holder.iv_imagendasani.setImageResource(dasani.getImagen());
        holder.tv_marcadasani.setText(dasani.getMarca());
        holder.tv_nombredasani.setText(dasani.getNombre());
        String precio = String.valueOf(dasani.getPrecio());
        holder.tv_preciodasani.setText("S/"+precio+"0");
    }

    @Override
    public int getItemCount() {
        return listadasani.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombredasani, tv_marcadasani, tv_preciodasani;
        private ImageView iv_imagendasani;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagendasani = itemView.findViewById(R.id.imagenDasani);
            tv_marcadasani = itemView.findViewById(R.id.tvMarcaDasani);
            tv_nombredasani = itemView.findViewById(R.id.tvNombreDasani);
            tv_preciodasani = itemView.findViewById(R.id.tvPrecioDasani);
        }
    }
}
