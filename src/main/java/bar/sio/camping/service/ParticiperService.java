package bar.sio.camping.service;

import bar.sio.camping.Model.Participer;
import bar.sio.camping.repository.ParticiperRepository;
import bar.sio.camping.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticiperService {

    @Autowired
    private ParticiperRepository participerRepository;

    public List<Utilisateur> getCampeursByCreneauId(int creneauId) {
        return participerRepository.findCampeursByCreneauId(creneauId);
    }

    public Participer participeCreneau(Participer participer) {
        return participerRepository.save(participer);
    }
}
