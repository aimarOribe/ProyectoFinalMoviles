package com.example.proyectofinaloribe.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinaloribe.R;

import java.util.HashMap;
import java.util.Map;

public class ValorarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private NotificationManagerCompat compat;
    private static final String CHANNEL_ID = "ID";
    NotificationManager manager;
    NotificationCompat.Builder builder;
    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorar);

        ratingBar = findViewById(R.id.ratingBar);
        compat = NotificationManagerCompat.from(this);

        createNotificacionChannel();
        buildNotification();

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                valor = String.valueOf(ratingBar.getRating());
                ejecutarServicio("http://192.168.1.6:80/laconsegna/insertar_valor.php");
            }
        });
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int notificationID = 1;
                compat.notify(notificationID, builder.build());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("valor", valor);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void createNotificacionChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.CHANNEL_NAME);
            String descripcion = getString(R.string.CHANNEL_DESCRIPTION);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            //Contruccion del canal
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    private void buildNotification(){
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_storefront_24)
                .setContentTitle("Consegna")
                .setContentText("Gracias por valorar la app")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
    }
}