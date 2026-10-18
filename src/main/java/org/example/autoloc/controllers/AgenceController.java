package org.example.autoloc.controllers;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.service.AgenceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    private final AgenceService service;

    public AgenceController(AgenceService service) {
        this.service = service;
    }

    @PostMapping
    public Agence ajouter(@RequestBody Agence agence) {
        return service.ajouter(agence);
    }

    @GetMapping
    public List<Agence> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Agence afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Agence modifier(@PathVariable Long id,
                           @RequestBody Agence agence) {
        return service.modifier(id, agence);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}