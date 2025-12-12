package com.example.controller;

import com.example.model.Motocicletta;
import com.example.repository.MotociclettaRepository;
import com.example.service.VeicoloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/motociclette")
@RequiredArgsConstructor
public class MotociclettaController {

    private final MotociclettaRepository motociclettaRepository;
    private final VeicoloService veicoloService;  // NEW

    /** Mostra la lista di tutte le motociclette */
    @GetMapping
    public String listaMotociclette(Model model) {
        List<Motocicletta> motociclette = motociclettaRepository.findAll();
        model.addAttribute("motociclette", motociclette);
        model.addAttribute("motoEconomica", veicoloService.motoPiuEconomicaDTO()); // NEW
        return "motociclette";  // --> motociclette.html
    }

    /** Mostra i dettagli di una singola motocicletta */
    @GetMapping("/{id}")
    public String dettagliMotocicletta(@PathVariable Long id, Model model) {
        Motocicletta moto = motociclettaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motocicletta non trovata con id: " + id));
        model.addAttribute("moto", moto);
        return "dettagli";  // --> dettagli.html
    }
}
