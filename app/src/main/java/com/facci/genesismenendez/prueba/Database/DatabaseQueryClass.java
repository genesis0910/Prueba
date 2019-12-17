package com.facci.genesismenendez.prueba.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.facci.genesismenendez.prueba.Datos.DatosBD;
import com.facci.genesismenendez.prueba.Datos.Ruta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseQueryClass {

    private Context context;

    public DatabaseQueryClass(Context context){
        this.context = context;
    }
    //______________________________________________________________________________________________

    public void insertarRuta(String ruta, String origen, String destino, String com, String tiempo){

        long id = -1;
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatosBD.COLUMNA_RUTA, ruta);
        contentValues.put(DatosBD.COLUMNA_ORIGEN, origen);
        contentValues.put(DatosBD.COLUMNA_DESTINO, destino);
        contentValues.put(DatosBD.COLUMNA_COMPANIA, com);
        contentValues.put(DatosBD.COLUMNA_TIEMPO, tiempo);

        try {
            id = sqLiteDatabase.insertOrThrow(DatosBD.TABLA_RUTA, null, contentValues);
        } catch (SQLiteException e){
            Toast.makeText(context, "Operation failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            sqLiteDatabase.close();
        }
    }
    //______________________________________________________________________________________________

    public void insertarBUS(String marca, String modelo, int year){

        long id = -1;
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatosBD.COLUMNA_MARCA, marca);
        contentValues.put(DatosBD.COLUMNA_MODELO, modelo);
        contentValues.put(DatosBD.COLUMNA_YEAR, year);

        try {
            id = sqLiteDatabase.insertOrThrow(DatosBD.TABLA_BUS, null, contentValues);
        } catch (SQLiteException e){
            Toast.makeText(context, "Operation failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            sqLiteDatabase.close();
        }
    }
    //______________________________________________________________________________________________

    public List<Ruta> getAllRUTAS(){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.query(DatosBD.TABLA_RUTA, null, null,
                    null, null, null, null, null);
            if(cursor!=null)
                if(cursor.moveToFirst()){
                    List<Ruta> rutaList = new ArrayList<>();
                    do {
                        String id = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_RUTA));
                        String name = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_ORIGEN));
                        String cedula = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_DESTINO));
                        String email = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_TIEMPO));
                        String phone = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_COMPANIA));
                        rutaList.add(new Ruta(id, name, cedula, email, phone));
                    }   while (cursor.moveToNext());

                    return rutaList;
                }
        } catch (Exception e){
            Toast.makeText(context, "Operation failed", Toast.LENGTH_SHORT).show();
        } finally {
            if(cursor!=null)
                cursor.close();
            sqLiteDatabase.close();
        }
        return Collections.emptyList();
    }

    public Ruta getClienteByRegNum(String registrationNum){

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        Ruta ruta = null;
        try {
            cursor = sqLiteDatabase.query(DatosBD.TABLA_RUTA, null,
                    DatosBD.COLUMNA_DESTINO + " = ? ", new String[]{String.valueOf(registrationNum)},
                    null, null, null);
            if(cursor.moveToFirst()){
                String id = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_RUTA));
                String name = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_ORIGEN));
                String cedula = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_DESTINO));
                String phone = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_COMPANIA));
                String email = cursor.getString(cursor.getColumnIndex(DatosBD.COLUMNA_TIEMPO));

                ruta = new Ruta(id, name, cedula, phone, email);
            }
        } catch (Exception e){
            Toast.makeText(context, "Operation failed", Toast.LENGTH_SHORT).show();
        } finally {
            if(cursor!=null)
                cursor.close();
            sqLiteDatabase.close();
        }

        return ruta;
    }
}








