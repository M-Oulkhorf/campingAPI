package bar.sio.camping.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Participer {

    @EmbeddedId
    private ParticiperId id;

    @ManyToOne
    @JoinColumn(name = "campeurId", insertable = false, updatable = false)
    private Utilisateur campeur;

    @ManyToOne
    @JoinColumn(name = "creneauId", insertable = false, updatable = false)
    private Creneau creneau;

    // Getters et setters
    public ParticiperId getId() {
        return id;
    }

    public void setId(ParticiperId id) {
        this.id = id;
    }

    public Utilisateur getCampeur() {
        return campeur;
    }

    public void setCampeur(Utilisateur campeur) {
        this.campeur = campeur;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }
}
