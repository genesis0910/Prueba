package com.facci.genesismenendez.prueba.VerLista;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.facci.genesismenendez.prueba.R;


public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    TextView origennn;
    TextView destinnooo;
    TextView company;
    TextView tiempo;
    ImageView crossButtonImageView;
    ImageView editButtonImageView;
    ConstraintLayout cli_;

    public CustomViewHolder(View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.nameTextView);
        origennn = itemView.findViewById(R.id.origen_);
        destinnooo = itemView.findViewById(R.id.destino_);
        company = itemView.findViewById(R.id.comp);
        tiempo = itemView.findViewById(R.id.tiempo);
        cli_ = itemView.findViewById(R.id.clic);
    }
}
