package com.gts.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gts.springboot.backend.apirest.models.Dao.ParqueaderoDao;
import com.gts.springboot.backend.apirest.models.entity.Parqueadero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ParqueaderoController {
    @Autowired
    private ParqueaderoDao dao;

    @RequestMapping(value = "/parqueadero")
    public List<Parqueadero> getParqueadero() {
        return dao.getParqueadero();
    }

    @PostMapping("/parqueadero/new")
    public ResponseEntity<?> create(@RequestBody Parqueadero par) {
        Parqueadero parqueaderoNew;
        Map<String, Object> response = new HashMap<>();
        try {
			parqueaderoNew = dao.save(par);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el parqueadero con el ID: " + parqueaderoNew.getId() + " ha sido creado con éxito!");
        response.put("Fondo", parqueaderoNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/parqueadero/delete/{id}")
    public ResponseEntity<?> deletePar(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            dao.deleteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar el parqueadero");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La parqueadero con el ID: " + id + " ha sido eliminada con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
