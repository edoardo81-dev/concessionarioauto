package com.example.controller;


import com.example.service.VeicoloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class VeicoloController {

    private final VeicoloService veicoloService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("veicoloEconomico", veicoloService.veicoloPiuEconomicoDTO());
        model.addAttribute("prezzoMedio", veicoloService.prezzoMedio());
        return "index";  // --> index.html
    }
}