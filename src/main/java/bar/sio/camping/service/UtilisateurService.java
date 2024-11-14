package bar.sio.camping.service;

import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur register(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> login(String identifiant, String mdp) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByIdentifiant(identifiant);
        if (utilisateur.isPresent() && BCrypt.checkpw(mdp, utilisateur.get().getMdp())) {
            return utilisateur;
        }
        return Optional.empty();
    }
}