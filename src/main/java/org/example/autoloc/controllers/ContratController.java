package org.example.autoloc.controllers;

import org.example.autoloc.entities.Contrat;
import org.example.autoloc.service.ContratService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final ContratService service;

    public ContratController(ContratService service) {
        this.service = service;
    }

    @PostMapping
    public Contrat ajouter(@RequestBody Contrat contrat) {
        return service.ajouter(contrat);
    }

    @GetMapping
    public List<Contrat> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Contrat afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Contrat modifier(@PathVariable Long id,
                            @RequestBody Contrat contrat) {
        return service.modifier(id, contrat);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}