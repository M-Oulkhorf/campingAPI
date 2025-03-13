package bar.sio.camping.repository;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.Model.Participer;
import bar.sio.camping.Model.ParticiperId;
import bar.sio.camping.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticiperRepository extends JpaRepository<Participer, ParticiperId> {
    List<Participer> findByCreneau(Creneau creneau);
    int countByCreneau_IdCreneau(Integer idCreneau);
    @Query("SELECT p.campeur FROM Participer p WHERE p.creneau.idCreneau = :creneauId")
    List<Utilisateur> findCampeursByCreneauId(@Param("creneauId") int creneauId);

    @Query("SELECT p.creneau FROM Participer p WHERE p.campeur.id = :campeurId")
    List<Creneau> findCreneauxByCampeurId(@Param("campeurId") int campeurId);

}