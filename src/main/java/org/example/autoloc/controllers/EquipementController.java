package org.example.autoloc.controllers;

import org.example.autoloc.entities.Equipement;
import org.example.autoloc.service.EquipementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    private final EquipementService service;

    public EquipementController(EquipementService service) {
        this.service = service;
    }

    @PostMapping
    public Equipement ajouter(@RequestBody Equipement equipement) {
        return service.ajouter(equipement);
    }

    @GetMapping
    public List<Equipement> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Equipement afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Equipement modifier(@PathVariable Long id,
                               @RequestBody Equipement equipement) {
        return service.modifier(id, equipement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}