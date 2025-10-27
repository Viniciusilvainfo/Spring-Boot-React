package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Clube;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
}