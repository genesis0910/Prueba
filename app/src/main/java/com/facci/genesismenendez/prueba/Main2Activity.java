package com.facci.genesismenendez.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView ruta,origen, destino, compañia, tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ruta = findViewById(R.id.nameTextView);
        origen = findViewById(R.id.origen_);
        destino = findViewById(R.id.destino_);
        compañia = findViewById(R.id.comp);
        tiempo = findViewById(R.id.tiempo);

        Bundle bundle = this.getIntent().getExtras();


        ruta.setText(bundle.getString("ruta"));
        origen.setText(bundle.getString("origen"));
        destino.setText(bundle.getString("destino"));
        compañia.setText(bundle.getString("company"));
        tiempo.setText(bundle.getString("tiempo"));




    }
}
