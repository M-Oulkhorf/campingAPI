package bar.sio.camping.repository;

import bar.sio.camping.Model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    @Query("SELECT a FROM Absence a WHERE a.creneau.idCreneau = :creneauId")
    List<Absence> findByCreneauId(@Param("creneauId") int creneauId);

}
