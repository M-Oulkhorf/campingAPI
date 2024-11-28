package bar.sio.camping.repository;

import bar.sio.camping.Model.Animer;
import bar.sio.camping.Model.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimerRepository extends JpaRepository<Animer, Integer> {

    @Query("SELECT a.creneau FROM Animer a WHERE a.animateur.id = :animateurId")
    List<Creneau> findCreneauxByAnimateurId(@Param("animateurId") int animateurId);
}
