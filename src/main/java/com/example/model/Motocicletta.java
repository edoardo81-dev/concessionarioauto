package com.example.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motocicletta extends Veicolo {

    private int cilindrata;
    private boolean sidecar;
}
