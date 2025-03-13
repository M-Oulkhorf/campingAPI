package bar.sio.camping.service;

import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur register(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur login(String identifiant, String mdp) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByIdentifiant(identifiant);
        if (utilisateur.isPresent() && mdp.equals(utilisateur.get().getMdp())) {
            return utilisateur.get(); // Retourne l'objet Utilisateur directement
        }
        throw new RuntimeException("Identifiant ou mot de passe incorrect"); // Lance une exception si l'utilisateur n'est pas trouvé ou si le mot de passe est incorrect
    }
}