package com.example.proyectofinaloribe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinaloribe.R;

import java.util.Date;


public class ContactoFragment extends Fragment {

    private View v;
    private TextView tv_hora;
    private ImageButton botonLlamada, botonUbicacion, botonEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_contacto, container, false);
        tv_hora = v.findViewById(R.id.tvHora);
        botonLlamada = v.findViewById(R.id.botonLlamada);
        botonUbicacion = v.findViewById(R.id.botonUbicacion);
        botonEmail = v.findViewById(R.id.botonEmail);
        botonLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:943-626-943"));
                startActivity(intent);
            }
        });
        botonUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("geo:0.0?=teofilo castillo"));
                startActivity(intent2);
            }
        });
        botonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_SEND);
                intent3.setType("message/rfc822");
                intent3.putExtra(Intent.EXTRA_EMAIL, new String[]{"aimaroribevigo@gmail.com","rafael.arriaga@tecsup.edu.pe"});
                intent3.putExtra(Intent.EXTRA_SUBJECT, "Ingrese su titulo");
                intent3.putExtra(Intent.EXTRA_TEXT, "Ingrese su comentario");
                startActivity(Intent.createChooser(intent3,"Enviar mail..."));
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int hora = (int) new Date().getHours();
        int minuto = (int) new Date().getMinutes();
        int segundo = (int) new Date().getSeconds();
        String horaString = String.valueOf(hora);
        String minutoString = String.valueOf(minuto);
        String segundoString = String.valueOf(segundo);
        tv_hora.setText(horaString+":"+minutoString+":"+segundoString);
    }
}