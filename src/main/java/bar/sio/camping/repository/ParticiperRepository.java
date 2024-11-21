package bar.sio.camping.repository;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.Model.Participer;
import bar.sio.camping.Model.ParticiperId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticiperRepository extends JpaRepository<Participer, ParticiperId> {
    List<Participer> findByCreneau(Creneau creneau);
}