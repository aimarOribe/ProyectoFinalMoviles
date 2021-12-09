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

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.models.Sprite;

import java.util.ArrayList;

public class CustomAdapterSprite extends RecyclerView.Adapter<CustomAdapterSprite.CustomViewHolder> {

    private ArrayList<Sprite> listasprite = new ArrayList<>();
    private FragmentActivity myContext;
    private FragmentTransaction ftsprite;

    public CustomAdapterSprite(ArrayList<Sprite> listasprite, FragmentActivity myContext) {
        this.listasprite = listasprite;
        this.myContext = myContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantillasprite,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Sprite sprite = listasprite.get(position);
        holder.iv_imagensprite.setImageResource(sprite.getImagen());
        holder.tv_marcasprite.setText(sprite.getNombre());
        holder.tv_nombresprite.setText(sprite.getNombre());
        String precio = String.valueOf(sprite.getPrecio());
        holder.tv_preciosprite.setText("S/"+precio+"0");
    }

    @Override
    public int getItemCount() {
        return listasprite.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombresprite, tv_marcasprite, tv_preciosprite;
        private ImageView iv_imagensprite;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagensprite = itemView.findViewById(R.id.imagenSprite);
            tv_marcasprite = itemView.findViewById(R.id.tvMarcaSprite);
            tv_nombresprite = itemView.findViewById(R.id.tvNombreSprite);
            tv_preciosprite = itemView.findViewById(R.id.tvPrecioSprite);
        }
    }
}
