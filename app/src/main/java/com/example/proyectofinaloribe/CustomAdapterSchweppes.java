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

public class CustomAdapterSchweppes extends RecyclerView.Adapter<CustomAdapterSchweppes.CustomViewHolder> {

    private ArrayList<Schweppes> listaSchweppes = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftschweppes;

    public CustomAdapterSchweppes(ArrayList<Schweppes> listaSchweppes, FragmentActivity myContext) {
        this.listaSchweppes = listaSchweppes;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillaschweppes,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Schweppes schweppes = listaSchweppes.get(position);
        holder.iv_imagenschweppes.setImageResource(schweppes.getImagen());
        holder.tv_marcaschweppes.setText(schweppes.getMarca());
        holder.tv_nombreschweppes.setText(schweppes.getNombre());
        String precio = String.valueOf(schweppes.getPrecio());
        holder.tv_precioschweppes.setText("S/"+precio+"0");
    }

    @Override
    public int getItemCount() {
        return listaSchweppes.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombreschweppes, tv_marcaschweppes, tv_precioschweppes;
        private ImageView iv_imagenschweppes;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagenschweppes = itemView.findViewById(R.id.imagenSchweppes);
            tv_marcaschweppes = itemView.findViewById(R.id.tvMarcaSchweppes);
            tv_nombreschweppes = itemView.findViewById(R.id.tvNombreSchweppes);
            tv_precioschweppes = itemView.findViewById(R.id.tvPrecioSchweppes);
        }
    }
}
