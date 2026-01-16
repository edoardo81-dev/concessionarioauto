package com.example.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class FurgoneDTO {
    private Long id;
    private String modello;
    private String marca;
    private String codiceImmatricolazione;
    private LocalDate dataImmatricolazione;
    private Integer prezzo;

    // campi specifici Furgone
    private double capacitaCarico;
    private boolean refrigerato;
}
