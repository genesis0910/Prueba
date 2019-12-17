package com.facci.genesismenendez.prueba.VerLista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.facci.genesismenendez.prueba.Database.DatabaseQueryClass;
import com.facci.genesismenendez.prueba.Datos.Ruta;
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

        holder.nameTextView.setText(ruta.getOrigen());
        holder.registrationNumTextView.setText(String.valueOf(ruta.getDestino()));
        holder.emailTextView.setText(ruta.getEmail());
        holder.phoneTextView.setText(ruta.getCompania());
        holder.cli_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "clic"+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return rutaList.size();
    }

}
