package bar.sio.camping.controllers;

import bar.sio.camping.Model.Creneau;
import org.springframework.web.bind.annotation.CrossOrigin;
import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.service.CreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/creneaux")
public class CreneauController {
    @Autowired
    private CreneauService creneauService;

    @GetMapping
    public ResponseEntity<List<Creneau>> getUpcomingCreneaux() {
        return ResponseEntity.ok(creneauService.getUpcomingCreneaux());
    }

    @PostMapping
    public ResponseEntity<Creneau> createCreneau(@RequestBody Creneau creneau) {
        Creneau newCreneau = creneauService.createCreneau(creneau);
        return ResponseEntity.ok(newCreneau);  // Retourne le créneau créé
    }

}