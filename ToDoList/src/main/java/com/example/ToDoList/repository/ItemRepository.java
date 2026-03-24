package com.example.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.model.Item;

// esta interfaz es un componente de acceso a datos.

public interface ItemRepository extends JpaRepository<Item, Long>{}

