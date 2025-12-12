package com.example.model;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automobile extends Veicolo {

    private int porte;   // es. 3 o 5
    private boolean elettrica;
}
