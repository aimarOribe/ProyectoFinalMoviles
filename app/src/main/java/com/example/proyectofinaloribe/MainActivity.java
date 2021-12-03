package com.example.proyectofinaloribe;

import com.example.proyectofinaloribe.activities.PokemonActivity;
import com.example.proyectofinaloribe.activities.PruebaContactoActivity;
import com.example.proyectofinaloribe.activities.PruebaGaseosasActivity;
import com.example.proyectofinaloribe.activities.PruebaHomeActivity;
import com.example.proyectofinaloribe.activities.ValorarActivity;
import com.example.proyectofinaloribe.databinding.ActivityMainBinding;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Entrar a nuestra pagina web", Snackbar.LENGTH_LONG)
                        .setAction("Aqui", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intentLocal = new Intent(Intent.ACTION_VIEW);
                                intentLocal.setData(Uri.parse("https://www.rappi.com.pe/"));
                                startActivity(intentLocal);
                            }
                        }).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(), PruebaHomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_gallery:
                        Intent intent2 = new Intent(getApplicationContext(), PruebaGaseosasActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_slideshow:
                        Intent intent3 = new Intent(getApplicationContext(), PruebaContactoActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_apipokemon:
                        Intent intent10 = new Intent(getApplicationContext(), PokemonActivity.class);
                        startActivity(intent10);
                        break;

                }

                drawer.closeDrawers();

                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent4 = new Intent(getApplicationContext(), ValorarActivity.class);
                startActivity(intent4);
                break;
            case R.id.action_salir:
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("¿Desea salir de la aplicación?")
                        .setCancelable(true)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertaTitulo = alerta.create();
                alertaTitulo.setTitle("Salida");
                alertaTitulo.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}