package bar.sio.camping.controllers;

import bar.sio.camping.service.ParticiperService;
import bar.sio.camping.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creneaux")
public class ParticiperController {

    @Autowired
    private ParticiperService participerService;

    @GetMapping("/{creneauId}/campeurs")
    public ResponseEntity<List<Utilisateur>> getCampeursByCreneau(@PathVariable int creneauId) {
        List<Utilisateur> campeurs = participerService.getCampeursByCreneauId(creneauId);
        return ResponseEntity.ok(campeurs);
    }
    @DeleteMapping("annuler/{campeurId}/{creneauId}")
    public ResponseEntity<String> annulerParticipation(@PathVariable Long campeurId, @PathVariable Long creneauId) {
        try {
            participerService.annulerParticipation(campeurId, creneauId);
            return ResponseEntity.ok("Participation annulée avec succès !");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
