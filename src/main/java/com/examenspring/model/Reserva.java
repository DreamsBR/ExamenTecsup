package com.examenspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservaId;

    private Integer asientoNumero;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "vuelo_id_fk")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "pasajero_id_fk")
    private Pasajero pasajero;


}
