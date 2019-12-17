package com.facci.genesismenendez.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.facci.genesismenendez.prueba.Database.DatabaseQueryClass;
import com.facci.genesismenendez.prueba.Datos.Ruta;
import com.facci.genesismenendez.prueba.VerLista.ListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(this);

    private List<Ruta> rutaList = new ArrayList<>();

    private TextView ListEmptyTextView;
    private RecyclerView recyclerView;
    private ListRecyclerViewAdapter listRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseQueryClass a = new DatabaseQueryClass(this);
        a.insertarRuta("Manta-portoviejo","Manta","Portoviejo", "CTM", "1 hora");
        a.insertarRuta("Manta-montecristi","Manta","montecristi", "CTM", "30 minutos");
        a.insertarRuta("Manta-guayaquil","Manta","guayaquil", "CTM", "8 hora");
        a.insertarRuta("Manta-quito","Manta","quito", "CTM", "10 hora");

        a.insertarBUS("tesla","modelo 1", 2019);
        a.insertarBUS("tesla2","modelo 2", 2018);
        a.insertarBUS("tesla3","modelo 3", 2017);


        recyclerView = (RecyclerView) findViewById(R.id.clienteRecyclerView);
        ListEmptyTextView = (TextView) findViewById(R.id.emptyClienteListTextView);

        //Aegregar rutas
        rutaList.addAll(databaseQueryClass.getAllRUTAS());

        listRecyclerViewAdapter = new ListRecyclerViewAdapter(this, rutaList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(listRecyclerViewAdapter);

    }
}
