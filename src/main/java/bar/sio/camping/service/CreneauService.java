package bar.sio.camping.service;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.repository.CreneauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreneauService {
    @Autowired
    private CreneauRepository creneauRepository;

    public List<Creneau> getAllCreneaux() {
        return creneauRepository.findAll();
    }
}
