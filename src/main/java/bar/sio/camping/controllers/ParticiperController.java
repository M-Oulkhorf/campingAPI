package bar.sio.camping.controllers;

import bar.sio.camping.Model.Creneau;
import org.springframework.web.bind.annotation.CrossOrigin;
import bar.sio.camping.Model.Participer;
import bar.sio.camping.repository.CreneauRepository;
import bar.sio.camping.repository.ParticiperRepository;
import bar.sio.camping.repository.UtilisateurRepository;
import bar.sio.camping.service.AbsenceService;
import bar.sio.camping.service.ParticiperService;
import bar.sio.camping.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/creneaux")
public class ParticiperController {

    @Autowired
    private ParticiperService participerService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CreneauRepository creneauRepository;

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private ParticiperRepository participerRepository;

    @GetMapping("/{creneauId}/campeurs")
    public ResponseEntity<List<Utilisateur>> getCampeursByCreneau(@PathVariable int creneauId) {
        List<Utilisateur> campeurs = participerService.getCampeursByCreneauId(creneauId);
        return ResponseEntity.ok(campeurs);
    }

    @GetMapping("/{creneauId}/absents")
    public ResponseEntity<List<Utilisateur>> getAbsentsByCreneau(@PathVariable int creneauId) {
        List<Utilisateur> absents = absenceService.getAbsentsByCreneauId(creneauId);
        return ResponseEntity.ok(absents);
    }

    @DeleteMapping("/annuler/{campeurId}/{creneauId}")
    public ResponseEntity<String> annulerParticipation(@PathVariable Integer campeurId, @PathVariable Integer creneauId) {
        try {
            // Annule la participation
            participerService.annulerParticipation(campeurId, creneauId);

            // Récupère l'utilisateur et le créneau
            Utilisateur campeur = utilisateurRepository.findById(campeurId).orElse(null);
            Creneau creneau = creneauRepository.findById(creneauId).orElse(null);

            if (campeur != null && creneau != null) {
                // Enregistre l'absence suite à l'annulation
                absenceService.enregistrerAbsence(campeur, creneau);

                // Ne réinitialise pas le nombre d'absences lors de l'annulation
                // Si tu veux quand même mettre à jour les absences, il suffit de les incrémenter ici si nécessaire.
                int nombreAbsences = campeur.getNombreAbsences() + 1;
                campeur.setNombreAbsences(nombreAbsences);
                utilisateurRepository.save(campeur);  // Sauvegarde les modifications dans la base de données
            }

            return ResponseEntity.ok("Participation annulée avec succès !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }




    @PostMapping("/participer")
    public ResponseEntity<String> participerAuCreneau(@RequestBody Participer participer) {
        // Récupère le campeur et le créneau
        Utilisateur campeur = utilisateurRepository.findById(participer.getId().getCampeurId()).orElse(null);
        Creneau creneau = creneauRepository.findById(participer.getId().getCreneauId()).orElse(null);

        // Vérifie si le campeur et le créneau existent
        if (campeur == null || creneau == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campeur ou créneau non trouvé.");
        }

        // Vérifie si le campeur a dépassé le seuil d'absences
        if (campeur.getNombreAbsences() >= 3) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Vous ne pouvez pas participer, car vous avez atteint le nombre maximum d'absences autorisées.");
        }

        // Compte le nombre actuel de participants pour ce créneau
        int nombreParticipants = participerRepository.countByCreneau_IdCreneau(participer.getId().getCreneauId());

        // Vérifie si des places sont encore disponibles
        if (nombreParticipants >= creneau.getNbPlacesCreneau()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Il n'y a plus de place disponible pour ce créneau.");
        }

        // Enregistre la participation
        participer.setCampeur(campeur);
        participer.setCreneau(creneau);
        participerService.participeCreneau(participer);

        return ResponseEntity.status(HttpStatus.CREATED).body("Inscription au créneau réussie !");
    }

    @PutMapping("/participation-effectuee/{campeurId}/{creneauId}")
    public ResponseEntity<String> participationEffectuee(@PathVariable Integer campeurId, @PathVariable Integer creneauId) {
        Utilisateur campeur = utilisateurRepository.findById(campeurId).orElse(null);
        Creneau creneau = creneauRepository.findById(creneauId).orElse(null);

        if (campeur == null || creneau == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur ou créneau non trouvé.");
        }

        // Réinitialise les absences uniquement si le campeur a effectivement participé
        campeur.setNombreAbsences(0);
        utilisateurRepository.save(campeur);

        return ResponseEntity.ok("Participation confirmée, absences réinitialisées.");
    }

}
