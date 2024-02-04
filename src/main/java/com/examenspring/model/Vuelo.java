package com.examenspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuelo_id")
    private Integer vueloId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaLlegada;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "avion_id_fk")
    @JsonIgnoreProperties("vuelos")
    private Avion avion;


    @JsonIgnore
    @ManyToMany(mappedBy = "vuelos")
    private List<Piloto> pilotos;


    @JsonIgnore
    @OneToMany(mappedBy = "vuelo")
    private List<Reserva> reservas ;


}
