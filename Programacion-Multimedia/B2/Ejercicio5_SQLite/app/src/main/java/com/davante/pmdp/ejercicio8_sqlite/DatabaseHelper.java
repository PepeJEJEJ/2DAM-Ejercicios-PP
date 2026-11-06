package com.davante.pmdp.ejercicio8_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // ==== Configuración básica ====
    private static final String DATABASE_NAME = "DBProfesores.db";
    private static final int DATABASE_VERSION = 2;


    // ==== Esquema de la tabla ====
    private static final String TBL_PROFESORES = "Profesores";
    private static final String COL_ID = "id";
    private static final String COL_NOMBRE = "nombre";
    private static final String COL_APELLIDO = "apellido";


    // Sentencia SQL para crear la tabla
    private static final String SQL_CREATE =
            "CREATE TABLE " + TBL_PROFESORES + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOMBRE + " TEXT, " +
                    COL_APELLIDO + " TEXT" +
                    ")";


    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Metodo obligatorio: se ejecuta la primera vez que se crea la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos la tabla
        db.execSQL(SQL_CREATE);

        // Inserta profesores de ejemplo
        insertarProfesor(db, "Daniel", "Perez");
        insertarProfesor(db, "Jose", "Lopez");
        insertarProfesor(db, "Ana", "Garcia");
    }


    // Metodo obligatorio: se ejecuta al subir DATABASE_VERSION.
    // Aquí se borra todo y se vuelve a crear: vale para clase, no para una app con datos reales
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_PROFESORES);
        onCreate(db);
    }


    // ==== Datos de ejemplo ====

    // Dentro de onCreate() no se puede llamar a getWritableDatabase(): ya nos dan la BD abierta
    private void insertarProfesor(SQLiteDatabase db, String nombre, String apellido) {
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APELLIDO, apellido);
        db.insert(TBL_PROFESORES, null, valores);
    }


    // ==== CRUD ====

    // CREATE: este está hecho y sirve de modelo para los demás.
    // Devuelve el id nuevo, o -1 si ha fallado
    public long insertar(String nombre, String apellido) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APELLIDO, apellido);
        return db.insert(TBL_PROFESORES, null, valores);
    }


    // TODO Paso 1: devolver true si existe un profesor con ese nombre y apellido.
    //  - Abre la BD en modo lectura: getReadableDatabase()
    //  - Haz un db.query(...) con WHERE "nombre = ? AND apellido = ?" y los valores en un String[]
    //  - El Cursor se cierra solo si lo abres en un try (...) { }
    //  - c.moveToFirst() devuelve true si hay al menos una fila
    public boolean existeProfesor(String nombre, String apellido) {
        return false;
    }


    // TODO Paso 2: devolver todos los profesores, ordenados por apellido.
    //  - db.query(TBL_PROFESORES, columnas, null, null, null, null, orden)
    //  - Recorre el Cursor con while (c.moveToNext()) { ... }
    //  - Cada columna se lee con c.getInt(...) o c.getString(...) y c.getColumnIndexOrThrow(COL_...)
    //  - Por cada fila, añade un new Profesor(id, nombre, apellido) a la lista
    public List<Profesor> obtenerTodos() {
        List<Profesor> lista = new ArrayList<>();
        return lista;
    }


    // TODO Paso 4: borrar el profesor con ese id. Devuelve cuántas filas ha borrado.
    //  - db.delete(tabla, "id = ?", new String[]{ String.valueOf(id) })
    public int borrar(int id) {
        return 0;
    }


    // TODO Paso 5: cambiar el nombre y el apellido del profesor con ese id.
    //  - Igual que insertar(), pero con db.update(tabla, valores, "id = ?", argumentos)
    //  - Devuelve cuántas filas ha cambiado (1 si ha ido bien)
    public int actualizar(int id, String nombre, String apellido) {
        return 0;
    }

}
