package bar.sio.camping.controllers;

import bar.sio.camping.Model.Creneau;
import org.springframework.web.bind.annotation.CrossOrigin;
import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.service.AnimerService;
import bar.sio.camping.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private AnimerService animerService;

    @PostMapping("/register")
    public ResponseEntity<Utilisateur> register(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUser = utilisateurService.register(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        Optional<Utilisateur> utilisateur = utilisateurService.login(credentials.get("identifiant"), credentials.get("mdp"));
        if (utilisateur.isPresent()) {
            return ResponseEntity.ok("Connexion réussie !");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiant ou mot de passe incorrect");
        }
    }

    @GetMapping("/{animateurId}/planning")
    public ResponseEntity<?> getPlanning(@PathVariable int animateurId) {
        List<Creneau> creneaux = animerService.getPlanningByAnimateurId(animateurId);
        if (creneaux.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun créneau trouvé pour cet animateur.");
        }
        return ResponseEntity.ok(creneaux);
    }
}