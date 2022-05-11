package com.gts.springboot.backend.apirest.models.Dao;

import java.util.List;

import com.gts.springboot.backend.apirest.models.entity.Parqueadero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParqueaderoDao extends JpaRepository<Parqueadero, Long>{
    
    @Query("SELECT p FROM Parqueadero p")
    public  List<Parqueadero> getParqueadero();
}
