package com.example.Ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecomerce.model.Prenda;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long>{}

