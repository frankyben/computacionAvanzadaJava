package com.example.ToDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Item {

    //Define que este atributo es la llave primaria (Primary key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // atributo llamado "nombre" en la tabla
    private String nombre;

    //Getters y Setters manuales
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    
}
