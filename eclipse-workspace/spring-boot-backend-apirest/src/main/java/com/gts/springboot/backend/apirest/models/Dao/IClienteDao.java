package com.gts.springboot.backend.apirest.models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gts.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
