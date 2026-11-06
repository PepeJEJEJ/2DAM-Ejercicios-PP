package com.davante.pmdp.ejercicio8_sqlite;

// Clase entidad: representa una fila de la tabla Profesores
public class Profesor {

    private final int id;
    private final String nombre;
    private final String apellido;

    public Profesor(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    // El ArrayAdapter usa toString() para saber qué texto pintar en cada fila
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
