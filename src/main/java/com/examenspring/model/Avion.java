package com.examenspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avion_id")
    private Integer avionId;
    private String serie;
    private String modelo;
    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id_fk")
    @JsonIgnoreProperties("avion")
    private Aerolinea aerolinea;

    @OneToMany(mappedBy = "avion")
    //@JsonIgnoreProperties("avion")
    private List<Vuelo> vuelos;

}
