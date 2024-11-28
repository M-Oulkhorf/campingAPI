package bar.sio.camping.service;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.repository.AnimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimerService {

    @Autowired
    private AnimerRepository animerRepository;

    public List<Creneau> getPlanningByAnimateurId(int animateurId) {
        return animerRepository.findCreneauxByAnimateurId(animateurId);
    }
}
