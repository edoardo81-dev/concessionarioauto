package com.example.controller;

import com.example.model.Automobile;
import com.example.repository.AutomobileRepository;
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
@RequestMapping("/automobili")
@RequiredArgsConstructor
public class AutomobileController {

    private final AutomobileRepository automobileRepository;
    private final VeicoloService veicoloService;  // NEW

    /** Mostra la lista di tutte le automobili */
    @GetMapping
    public String listaAutomobili(Model model) {
        List<Automobile> automobili = automobileRepository.findAll();
        model.addAttribute("automobili", automobili);
        model.addAttribute("autoEconomica", veicoloService.autoPiuEconomicaDTO()); // NEW
        return "automobili";  // --> automobili.html
    }

    /** Mostra i dettagli di una singola automobile */
    @GetMapping("/{id}")
    public String dettagliAutomobile(@PathVariable Long id, Model model) {
        Automobile auto = automobileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Automobile non trovata con id: " + id));
        model.addAttribute("auto", auto);
        return "dettagli";  // --> dettagli.html
    }
}
