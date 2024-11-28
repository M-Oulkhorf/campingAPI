package bar.sio.camping.controllers;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.Model.Participer;
import bar.sio.camping.repository.CreneauRepository;
import bar.sio.camping.repository.UtilisateurRepository;
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

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CreneauRepository creneauRepository;

    @GetMapping("/{creneauId}/campeurs")
    public ResponseEntity<List<Utilisateur>> getCampeursByCreneau(@PathVariable int creneauId) {
        List<Utilisateur> campeurs = participerService.getCampeursByCreneauId(creneauId);
        return ResponseEntity.ok(campeurs);
    }
    @DeleteMapping("/annuler/{campeurId}/{creneauId}")
    public ResponseEntity<String> annulerParticipation(@PathVariable Integer campeurId, @PathVariable Integer creneauId) {
        try {
            participerService.annulerParticipation(campeurId, creneauId);
            return ResponseEntity.ok("Participation annulée avec succès !");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/participer")
    public ResponseEntity<Participer> participerAuCreneau(@RequestBody Participer participer) {
        Utilisateur campeur = utilisateurRepository.findById(participer.getId().getCampeurId()).orElse(null);
        Creneau creneau = creneauRepository.findById(participer.getId().getCreneauId()).orElse(null);
        if (campeur == null || creneau == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        participer.setCampeur(campeur);
        participer.setCreneau(creneau);
        Participer participeCreneau = participerService.participeCreneau(participer);
        return ResponseEntity.status(HttpStatus.CREATED).body(participeCreneau);
    }
}
