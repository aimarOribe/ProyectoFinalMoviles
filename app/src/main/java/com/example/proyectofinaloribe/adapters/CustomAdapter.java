package com.example.proyectofinaloribe.adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinaloribe.fragments.DetalleHamburguesaFragment;
import com.example.proyectofinaloribe.models.Hamburguesa;
import com.example.proyectofinaloribe.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Hamburguesa> listaHamburguesas = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftd;
    private DetalleHamburguesaFragment detalleHamburguesaFragment;

    public CustomAdapter(ArrayList<Hamburguesa> listaHamburguesas, FragmentActivity context) {
        this.listaHamburguesas = listaHamburguesas;
        this.myContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Hamburguesa hamburguesa = listaHamburguesas.get(position);
        holder.iv_imagen.setImageResource(hamburguesa.getImagen());
        holder.tv_nombre.setText(hamburguesa.getNombre());
        holder.tv_descripcion.setText(hamburguesa.getDescripcion());
        String precio = String.valueOf(hamburguesa.getPrecio());
        holder.tv_precio.setText("S/"+precio);
        holder.getAdapterPosition();
        holder.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detalleHamburguesaFragment = new DetalleHamburguesaFragment();
                Hamburguesa hamburguesa1 = listaHamburguesas.get(position);
                Bundle bundle = new Bundle();
                bundle.putInt("imagen",hamburguesa1.getImagen());
                bundle.putString("nombre",hamburguesa1.getNombre());
                bundle.putString("descripcion", hamburguesa1.getDescripcion());
                bundle.putFloat("precio",hamburguesa1.getPrecio());
                bundle.putFloat("calorias",hamburguesa1.getCalorias());
                bundle.putFloat("proteinas",hamburguesa1.getProteinas());
                bundle.putFloat("grasas",hamburguesa1.getGrasas());
                detalleHamburguesaFragment.setArguments(bundle);
                ftd = myContext.getSupportFragmentManager().beginTransaction();
                ftd.replace(R.id.flayout, detalleHamburguesaFragment);
                ftd.addToBackStack(null);
                ftd.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaHamburguesas.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombre, tv_descripcion, tv_precio;
        private ImageView iv_imagen;
        private Button boton;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tvNombre);
            tv_descripcion = itemView.findViewById(R.id.tvDescripcion);
            tv_precio = itemView.findViewById(R.id.tvPrecio);
            iv_imagen = itemView.findViewById(R.id.imagen);
            boton = itemView.findViewById(R.id.botonDetalle);
        }
    }

}
