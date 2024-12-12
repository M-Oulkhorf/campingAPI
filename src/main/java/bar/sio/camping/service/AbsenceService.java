package bar.sio.camping.service;

import bar.sio.camping.Model.Absence;
import bar.sio.camping.Model.Creneau;
import bar.sio.camping.Model.Utilisateur;
import bar.sio.camping.repository.AbsenceRepository;
import bar.sio.camping.repository.ParticiperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private ParticiperRepository participerRepository;

    public Absence enregistrerAbsence(Utilisateur campeur, Creneau creneau) {
        Absence absence = new Absence();
        absence.setCampeur(campeur);
        absence.setCreneau(creneau);
        absence.setDateAbsence(LocalDate.now());
        return absenceRepository.save(absence);
    }

    public void mettreAJourAbsences(Utilisateur campeur) {
        int nombreAbsences = campeur.getNombreAbsences() + 1;
        campeur.setNombreAbsences(nombreAbsences);
        // Si le nombre d'absences atteint 3, vous pouvez bloquer le compte
        if (nombreAbsences >= 3) {
            // Logique pour bloquer le compte
        }
    }

    public List<Utilisateur> getAbsentsByCreneauId(int creneauId) {
        // Récupérer toutes les absences pour le créneau spécifié
        List<Absence> absences = absenceRepository.findByCreneauId(creneauId);

        // Créer une liste pour les campeurs absents
        List<Utilisateur> absents = new ArrayList<>();

        // Vérifier qui a été absent
        for (Absence absence : absences) {
            absents.add(absence.getCampeur());
        }

        return absents;
    }

}
