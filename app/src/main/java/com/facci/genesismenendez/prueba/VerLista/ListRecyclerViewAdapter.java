package com.facci.genesismenendez.prueba.VerLista;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.facci.genesismenendez.prueba.Database.DatabaseQueryClass;
import com.facci.genesismenendez.prueba.Datos.Ruta;
import com.facci.genesismenendez.prueba.Main2Activity;
import com.facci.genesismenendez.prueba.R;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder>{

    private Context context;
    private List<Ruta> rutaList;
    private DatabaseQueryClass databaseQueryClass;


    public ListRecyclerViewAdapter(Context context, List<Ruta> rutaList) {
        this.context = context;
        this.rutaList = rutaList;
        databaseQueryClass = new DatabaseQueryClass(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.clientes_item, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        final int itemPosition = position;
        final Ruta ruta = rutaList.get(position);

        holder.nameTextView.setText(ruta.getRuta());
        holder.origennn.setText(ruta.getOrigen());
        holder.destinnooo.setText(ruta.getDestino());
        holder.company.setText(ruta.getCompania());
        holder.tiempo.setText(ruta.getTiempo());

        holder.cli_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declaramos un evento intent que sirve para enlazar con otra actividad
                Intent intent = new Intent(context, Main2Activity.class);
                //Se crea un objeto del tipo bundle, el cual se encargara de almacenar el dato a enviar
                Bundle bundle = new Bundle();
                // el metodo put fija los parametros a enviar mediante un id
                bundle.putString("ruta",ruta.getRuta());
                bundle.putString("origen",ruta.getOrigen());
                bundle.putString("destino",ruta.getDestino());
                bundle.putString("company",ruta.getCompania());
                bundle.putString("tiempo",ruta.getTiempo());
                //enviamos el dato mediante el putExtra, el cual permite enviar un solo parametro entre actividades
                intent.putExtras(bundle);
                //Llamamos al dicho evento con el metodo startActivity
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return rutaList.size();
    }

}
