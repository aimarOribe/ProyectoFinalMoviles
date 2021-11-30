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

public class CustomAdapterPepsi extends RecyclerView.Adapter<CustomAdapterPepsi.CustomViewHolder> {

    private ArrayList<Pepsi> listapepsi = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftpepsi;

    public CustomAdapterPepsi(ArrayList<Pepsi> listapepsi, FragmentActivity myContext) {
        this.listapepsi = listapepsi;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillapepsi,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Pepsi pepsi = listapepsi.get(position);
        holder.iv_imagenpepsi.setImageResource(pepsi.getImagen());
        holder.tv_marcapepsi.setText(pepsi.getMarca());
        holder.tv_nombrepepsi.setText(pepsi.getNombre());
        String precio = String.valueOf(pepsi.getPrecio());
        holder.tv_preciopepsi.setText("S/"+precio+"0");
    }

    @Override
    public int getItemCount() {
        return listapepsi.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombrepepsi, tv_marcapepsi, tv_preciopepsi;
        private ImageView iv_imagenpepsi;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagenpepsi = itemView.findViewById(R.id.imagenPepsi);
            tv_marcapepsi = itemView.findViewById(R.id.tvMarcaPepsi);
            tv_nombrepepsi = itemView.findViewById(R.id.tvNombrePepsi);
            tv_preciopepsi = itemView.findViewById(R.id.tvPrecioPepsi);
        }
    }
}
