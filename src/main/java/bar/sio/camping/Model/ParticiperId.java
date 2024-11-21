package bar.sio.camping.Model;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticiperId implements Serializable {
    private Long campeurId;
    private Long creneauId;

    // Constructeurs
    public ParticiperId() {}

    public ParticiperId(Long campeurId, Long creneauId) {
        this.campeurId = campeurId;
        this.creneauId = creneauId;
    }

    // Getters et setters
    public Long getCampeurId() {
        return campeurId;
    }

    public void setCampeurId(Long campeurId) {
        this.campeurId = campeurId;
    }

    public Long getCreneauId() {
        return creneauId;
    }

    public void setCreneauId(Long creneauId) {
        this.creneauId = creneauId;
    }

    // hashCode et equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticiperId that = (ParticiperId) o;
        return Objects.equals(campeurId, that.campeurId) &&
                Objects.equals(creneauId, that.creneauId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campeurId, creneauId);
    }
}
