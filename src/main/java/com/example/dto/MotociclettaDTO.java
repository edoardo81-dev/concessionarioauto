package com.example.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MotociclettaDTO {
    private Long id;
    private String modello;
    private String marca;
    private String codiceImmatricolazione;
    private LocalDate dataImmatricolazione;
    private Integer prezzo;

    // campi specifici Motocicletta
    private int cilindrata;
    private boolean sidecar;
}
