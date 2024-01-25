package com.example.sqlite_ferreteria.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite_ferreteria.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class CtrlFerreteria {

    private List<Producto> lstProducto = new ArrayList<>();

    public static List<Producto> getProducto(Context context) {
        List<Producto> list = new ArrayList<>();
        SQLiteDatabase db = new DB_SQLite(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Producto", null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                int stock = cursor.getInt(cursor.getColumnIndexOrThrow("stock"));
                double precio = cursor.getDouble(cursor.getColumnIndexOrThrow("precio"));

                Producto producto = new Producto(id, nombre, stock, precio);
                list.add(producto);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }

}
