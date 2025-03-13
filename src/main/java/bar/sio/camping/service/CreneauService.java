package bar.sio.camping.service;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.repository.CreneauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreneauService {
    @Autowired
    private CreneauRepository creneauRepository;

    public List<Creneau> getUpcomingCreneaux() {
        return creneauRepository.findUpcomingCreneaux(LocalDate.now());
    }
    public Creneau createCreneau(Creneau creneau) {
        return creneauRepository.save(creneau);  // Enregistre et retourne le créneau créé
    }
}
