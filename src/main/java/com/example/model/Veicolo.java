package com.example.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modello;
    private String marca;

    @Column(unique = true, nullable = false)
    private String codiceImmatricolazione;

    private LocalDate dataImmatricolazione;
    private Double prezzo;
}
