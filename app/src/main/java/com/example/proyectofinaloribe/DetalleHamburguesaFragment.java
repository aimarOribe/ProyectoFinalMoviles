package com.example.proyectofinaloribe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleHamburguesaFragment extends Fragment {

    private View v;
    private TextView tv_nombre, tv_precio, tv_calorias, tv_proteinas, tv_grasas;
    private ImageView iv_imagen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detalle_hamburguesa, container, false);
        iv_imagen = v.findViewById(R.id.tituloImagen);
        tv_nombre = v.findViewById(R.id.detalleNombre);
        tv_precio = v.findViewById(R.id.detallePrecio);
        tv_calorias = v.findViewById(R.id.detalleCalorias);
        tv_proteinas = v.findViewById(R.id.detalleProteinas);
        tv_grasas = v.findViewById(R.id.detalleGrasas);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        int imagen = arguments.getInt("imagen");
        String nombre = arguments.get("nombre").toString();
        String precio = arguments.get("precio").toString();
        String calorias = arguments.get("calorias").toString();
        String proteinas = arguments.get("proteinas").toString();
        String grasas = arguments.get("grasas").toString();
        iv_imagen.setImageResource(imagen);
        tv_nombre.setText(nombre);
        tv_precio.setText("S/"+precio);
        tv_calorias.setText(calorias+" cal");
        tv_proteinas.setText(proteinas+" grs");
        tv_grasas.setText(grasas+" grs");
    }
}