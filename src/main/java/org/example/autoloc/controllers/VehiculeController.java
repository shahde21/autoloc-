package org.example.autoloc.controllers;

import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.service.VehiculeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    private final VehiculeService service;

    public VehiculeController(VehiculeService service) {
        this.service = service;
    }

    @PostMapping
    public Vehicule ajouter(@RequestBody Vehicule vehicule) {
        return service.ajouter(vehicule);
    }

    @GetMapping
    public List<Vehicule> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Vehicule afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Vehicule modifier(@PathVariable Long id,
                             @RequestBody Vehicule vehicule) {
        return service.modifier(id, vehicule);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}