package com.example.proyectofinaloribe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinaloribe.R;
import com.example.proyectofinaloribe.adapters.CustomAdapter;
import com.example.proyectofinaloribe.models.Hamburguesa;

import java.util.ArrayList;

public class ListaHamburguesasFragment extends Fragment {

    private ArrayList<Hamburguesa> listaHambur = new ArrayList<>();
    private RecyclerView rv_hamburguesa;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarLista();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lista_hamburguesas, container, false);
        rv_hamburguesa = v.findViewById(R.id.rv_listaHamburguesas);
        setAdapter();
        return v;
    }

    public ArrayList<Hamburguesa> retornarLista(){
        return listaHambur;
    }

    public void llenarLista(){
        listaHambur.add(new Hamburguesa("Royal","Una hamburguesa que tiene un poco de todo",12.4f,R.drawable.royal,200,17.80f, 13.5f));
        listaHambur.add(new Hamburguesa("Doble","Hamburguesa que tiene de todo doble, doble carne, doble huevo, todo doble",24.52f,R.drawable.doble,210,18.55f,8.8f));
        listaHambur.add(new Hamburguesa("Clasica","Una hamburguesa con los ingredientes escenciales al mejor precio, una hamburguesa sencilla",10.99f,R.drawable.clasica,200,15.99f,9.7f));
        listaHambur.add(new Hamburguesa("Doble Carne","Hamburguesa con doble carne y su porcion de ensalada al mejor precio",12.99f,R.drawable.doblecarne,199,13.6f,7.4f));
        listaHambur.add(new Hamburguesa("Doble Queso","Hamburguesa con doble queso y su porcion de ensalada al mejor precio",14.56f,R.drawable.doblequeso,197,14.12f,5.7f));
        listaHambur.add(new Hamburguesa("Pollo","Hamburguesa de pollo con su porcion de ensalada al mismo costo que la clasica",6.12f,R.drawable.pollo,210,18.5f,9.7f));
        listaHambur.add(new Hamburguesa("Vegana","Hamburguesa a base de plantas, todo a base de vegetales para las personas especiales",30.99f,R.drawable.vegana,159,20.55f,6.7f));
        listaHambur.add(new Hamburguesa("Taco Carnitas","Pueden ser de nana, trompa, oreja, bucha y cuerito",12.4f,R.drawable.tacoscarnitas,200,17.80f, 13.5f));
        listaHambur.add(new Hamburguesa("Taco Chicharrón","Piel frita porcino al que se le agrega salsa, aguacate y algunas hiervas",24.52f,R.drawable.tacochicharron,210,18.55f,8.8f));
        listaHambur.add(new Hamburguesa("Taca Cabeza","El mas sano, la carne de res se hierve o se coce al vapor. Hay cachete, trompa, oreja y lengua.",10.99f,R.drawable.tacocabeza,200,15.99f,9.7f));
        listaHambur.add(new Hamburguesa("Taco Barbacoa","Hamburguesa con doble carne y su porcion de ensalada al mejor precio",12.99f,R.drawable.tacobarbacoa,199,13.6f,7.4f));
        listaHambur.add(new Hamburguesa("Taco Flautas","Tortilla grande grita, rellenas de res o pollo. Se comen con lechuga, queso, crema, jitomate y aguacate.",14.56f,R.drawable.tacoflautas,197,14.12f,5.7f));
        listaHambur.add(new Hamburguesa("Taco Fritanga","De suadero de res, longaniza, machitos o intestino. Se acompaña de salsa roja o verde, cebolla y cilantro",6.12f,R.drawable.tacofritanga,210,18.5f,9.7f));
        listaHambur.add(new Hamburguesa("Taco de Canasta","Dobados engrasados y envueltos en tela, plastico y papel de estraza y colocados en cestas de mimbre.",30.99f,R.drawable.tacocanasta,159,20.55f,6.7f));
        listaHambur.add(new Hamburguesa("Taco de Guisadp","Los mas comunes son: papa con chorizo, tinga de res, mole con pollo, chicharron en salsa verde.",12.4f,R.drawable.tacoguisado,200,17.80f, 13.5f));
        listaHambur.add(new Hamburguesa("Taco al Pastor","Provienen de los paises árabes y Grecia. Preparado con adobo, que gira para cocinarse.",24.52f,R.drawable.tacoalpastor,210,18.55f,8.8f));
        listaHambur.add(new Hamburguesa("Taco al Carbon","Vienen del norte, son propios de la carne asada, chorizo, bistec, costilla, chuleta y arrachera.",10.99f,R.drawable.tacoalcarbon,200,15.99f,9.7f));
        listaHambur.add(new Hamburguesa("Taco Indigenas","De charales, gusanos de maguey, acociles, escamoles, chapulines, jumiles, hormigas y otros insectos.",12.99f,R.drawable.tacoindigenas,199,13.6f,7.4f));
        listaHambur.add(new Hamburguesa("Taco Burritos","Los tradicionales son de machaca con huevo y tortilla de harina. Tambien se preparan otras carnes.",14.56f,R.drawable.tacoburritos,197,14.12f,5.7f));
        listaHambur.add(new Hamburguesa("Taco Cochinita Pibil","Carne de cerdo preparada con jugo de naranja, sal, pimienta, cominos y achiote. Son de origen yucateco y se acompañan de cebolla morada.",6.12f,R.drawable.tacocichinita,210,18.5f,9.7f));
    }

    public void setAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        CustomAdapter customAdapter = new CustomAdapter(listaHambur, this.getActivity());
        rv_hamburguesa.setLayoutManager(llm);
        rv_hamburguesa.setAdapter(customAdapter);
    }
}