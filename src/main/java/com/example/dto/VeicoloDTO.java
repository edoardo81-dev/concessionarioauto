package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VeicoloDTO {
    private String marca;
    private String modello;
    private Integer prezzo;
}
