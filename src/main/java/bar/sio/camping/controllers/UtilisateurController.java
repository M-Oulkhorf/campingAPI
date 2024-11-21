package bar.sio.camping.controllers;

import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public ResponseEntity<Utilisateur> register(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUser = utilisateurService.register(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        Optional<Utilisateur> utilisateur = utilisateurService.login(credentials.get("identifiant"), credentials.get("mdp"));
        if (utilisateur.isPresent()) {
            return ResponseEntity.ok("Connexion réussie !!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiant ou mot de passe incorrect");
        }
    }
}

