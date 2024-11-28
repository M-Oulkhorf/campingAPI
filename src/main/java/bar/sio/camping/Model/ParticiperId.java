package bar.sio.camping.Model;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticiperId implements Serializable {
    private Integer campeurId;
    private Integer creneauId;

    // Constructeurs
    public ParticiperId() {}

    public ParticiperId(Integer campeurId, Integer creneauId) {
        this.campeurId = campeurId;
        this.creneauId = creneauId;
    }

    // Getters et setters
    public Integer getCampeurId() {
        return campeurId;
    }

    public void setCampeurId(Integer campeurId) {
        this.campeurId = campeurId;
    }

    public Integer getCreneauId() {
        return creneauId;
    }

    public void setCreneauId(Integer creneauId) {
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
