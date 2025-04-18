package bar.sio.camping.service;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.Model.Participer;
import bar.sio.camping.Model.ParticiperId;
import bar.sio.camping.repository.ParticiperRepository;
import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticiperService {

    @Autowired
    private ParticiperRepository participerRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    public List<Utilisateur> getCampeursByCreneauId(int creneauId) {
        return participerRepository.findCampeursByCreneauId(creneauId);
    }

    public void annulerParticipation(Integer campeurId, Integer creneauId) {
        ParticiperId participerId = new ParticiperId(campeurId, creneauId);
        if (participerRepository.existsById(participerId)) {
            participerRepository.deleteById(participerId);
        } else {
            throw new IllegalArgumentException("La participation spécifiée n'existe pas.");
        }
    }
    public Participer participeCreneau(Participer participer) {
        Participer participeCreneau = participerRepository.save(participer);
        Utilisateur campeur = participer.getCampeur();
        if (campeur.getNombreAbsences() < 3) {
            utilisateurRepository.save(campeur);
        }

        return participeCreneau;
    }

    public List<Creneau> getCreneauxByCampeurId(int campeurId) {
        return participerRepository.findCreneauxByCampeurId(campeurId);
    }

}
