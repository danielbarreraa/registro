package com.gts.springboot.backend.apirest.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.gts.springboot.backend.apirest.models.Dao.ParqueaderoDao;
import com.gts.springboot.backend.apirest.models.entity.Parqueadero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ParqueaderoImpl {

    @Autowired
    public ParqueaderoDao dao;

    public List<Parqueadero> getParqueadero() {
        return dao.getParqueadero();
    
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public Parqueadero save(Parqueadero par) {
        return dao.save(par);
    }
}
