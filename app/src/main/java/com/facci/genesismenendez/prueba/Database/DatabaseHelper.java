package com.facci.genesismenendez.prueba.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.facci.genesismenendez.prueba.Datos.DatosBD;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper databaseHelper;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = DatosBD.NOMBRE_DB;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized DatabaseHelper getInstance(Context context){
        if(databaseHelper==null){
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + DatosBD.TABLA_RUTA + "("
                + DatosBD.COLUMNA_RUTA + " TEXT NOT NULL, "+ DatosBD.COLUMNA_ORIGEN + " TEXT NOT NULL, "
                + DatosBD.COLUMNA_DESTINO + " TEXT NOT NULL, " + DatosBD.COLUMNA_COMPANIA + " TEXT, "
                + DatosBD.COLUMNA_TIEMPO + " TEXT " + ")";

        db.execSQL(CREATE_TABLE);
        Log.i("CrearTable", "Tabla 1 creada");

        String CREATE_TABLE2 = "CREATE TABLE " + DatosBD.TABLA_BUS+ "("
                + DatosBD.COLUMNA_MARCA + " TEXT NOT NULL, "+ DatosBD.COLUMNA_MODELO+ " TEXT NOT NULL, "
                + DatosBD.COLUMNA_YEAR + " TEXT NOT NULL " + ")";

        db.execSQL(CREATE_TABLE2);
        Log.i("CrearTable", "Tabla 2 creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatosBD.TABLA_RUTA);
        onCreate(db);
    }

}
