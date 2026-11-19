package com.example.qizz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RankingDB extends SQLiteOpenHelper {
    private static final String NOMBRE_DB = "qizz.db";
    private static final int VERSION = 1;
    public static final String TABLA = "partidas";
    public static final String COL_ID = "id";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_PUNTUACION = "puntuacion";

    public RankingDB(Context context) {
        super(context, NOMBRE_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLA + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOMBRE + " TEXT NOT NULL, " +
                COL_PUNTUACION + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA);
        onCreate(db);
    }

    public void insertar(String nombre, int puntuacion) {
        SQLiteDatabase db = getWritableDatabase();
        // Consulta parametrizada con '?' y argumentos (datos del usuario no van concatenados)
        String sql = "INSERT INTO " + TABLA + " (" + COL_NOMBRE + ", " + COL_PUNTUACION + ") VALUES (?, ?)";
        SQLiteDatabase stmtDb = db;
        android.database.sqlite.SQLiteStatement stmt = stmtDb.compileStatement(sql);
        stmt.bindString(1, nombre);
        stmt.bindLong(2, puntuacion);
        stmt.executeInsert();
        stmt.close();
        db.close();
    }

    public List<String> obtenerTodas() {
        List<String> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        try {
            c = db.query(TABLA,
                    new String[]{COL_NOMBRE, COL_PUNTUACION},
                    null, null, null, null,
                    COL_PUNTUACION + " DESC");
            while (c.moveToNext()) {
                String nombre = c.getString(c.getColumnIndexOrThrow(COL_NOMBRE));
                int puntos = c.getInt(c.getColumnIndexOrThrow(COL_PUNTUACION));
                lista.add(nombre + " — " + puntos + " pts");
            }
        } finally {
            if (c != null) c.close();
            db.close();
        }
        return lista;
    }
}
