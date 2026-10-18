package org.example.autoloc.controllers;

import org.example.autoloc.entities.Paiement;
import org.example.autoloc.service.PaiementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }

    @PostMapping
    public Paiement ajouter(@RequestBody Paiement paiement) {
        return service.ajouter(paiement);
    }

    @GetMapping
    public List<Paiement> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Paiement afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Paiement modifier(@PathVariable Long id,
                             @RequestBody Paiement paiement) {
        return service.modifier(id, paiement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}