package bar.sio.camping.repository;

import bar.sio.camping.Model.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CreneauRepository extends JpaRepository<Creneau, Integer> {
    List<Creneau> findByDateCreneauAfter(LocalDate date);
}