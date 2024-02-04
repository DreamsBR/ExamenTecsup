package com.examenspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "piloto")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pilotoId;
    private String nombre;
    private String apellidos;
    private boolean estado;

    @ManyToMany
    @JoinTable(
        name = "piloto_vuelo",
            joinColumns = @JoinColumn(name = "piloto_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "vuelo_id_fk")
    )
    private List<Vuelo> vuelos;


}
