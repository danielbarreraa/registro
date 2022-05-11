package com.gts.springboot.backend.apirest.models.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "parqueadero")
@Entity
@ToString @EqualsAndHashCode
public class Parqueadero {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    
    // @Column(name = "NomVehi")
    // @Getter @Setter
    // private String NomVehi;

    @Column(name = "Nomvehi")
    @Getter @Setter
    private String Nomvehi;

    
    @Column(name = "Plac")
    @Getter @Setter
    private String Plac;

    
    @Column(name = "Fech")
    @Getter @Setter
    private Date Fech;

    
    @Column(name = "estado")
    @Getter @Setter
    private boolean estado;
}
