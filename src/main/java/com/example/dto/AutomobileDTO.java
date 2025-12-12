package com.example.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class AutomobileDTO {
    private Long id;
    private String modello;
    private String marca;
    private String codiceImmatricolazione;
    private LocalDate dataImmatricolazione;
    private Double prezzo;

    // campi specifici Automobile
    private int porte;
    private boolean elettrica;
}