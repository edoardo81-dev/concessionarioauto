package com.example.controller;

import com.example.model.Furgone;
import com.example.repository.FurgoneRepository;
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
@RequestMapping("/furgoni")
@RequiredArgsConstructor
public class FurgoneController {

    private final FurgoneRepository furgoneRepository;
    private final VeicoloService veicoloService;  // NEW

    /** Mostra la lista di tutti i furgoni */
    @GetMapping
    public String listaFurgoni(Model model) {
        List<Furgone> furgoni = furgoneRepository.findAll();
        model.addAttribute("furgoni", furgoni);
        model.addAttribute("furgoneEconomico", veicoloService.furgonePiuEconomicoDTO()); // NEW
        return "furgoni";  // --> furgoni.html
    }

    /** Mostra i dettagli di un singolo furgone */
    @GetMapping("/{id}")
    public String dettagliFurgone(@PathVariable Long id, Model model) {
        Furgone furgone = furgoneRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Furgone non trovato con id: " + id));
        model.addAttribute("furgone", furgone);
        return "dettagli";  // --> dettagli.html
    }
}
