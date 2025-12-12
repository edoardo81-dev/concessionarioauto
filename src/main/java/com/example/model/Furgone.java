package com.example.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Furgone extends Veicolo {

    private double capacitaCarico;   // es. in Kg
    private boolean refrigerato;
}