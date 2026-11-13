package com.dam.pc128;

import jakarta.persistence.*;

@Entity 
@Table (name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column (nullable = false)
    private String nombre;

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}