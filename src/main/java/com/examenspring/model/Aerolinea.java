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
@Table(name = "aerolinea")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aerolinea_id")
    private Integer id;

    private boolean estado;

    private String nombre;

    @OneToMany(mappedBy = "aerolinea")
    //@JoinColumn(name = "aerolinea_id_fk")
    @JsonIgnoreProperties("aerolinea")
    private List<Avion> avion;




}
