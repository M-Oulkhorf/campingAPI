package bar.sio.camping.Model;

import jakarta.persistence.*;

@Entity
public class Participer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EmbeddedId
    private ParticiperId participerId;

    @ManyToOne
    @JoinColumn(name = "campeurId", insertable = false, updatable = false)
    private Utilisateur campeur;

    @ManyToOne
    @JoinColumn(name = "creneauId", insertable = false, updatable = false)
    private Creneau creneau;

    // Getters et setters
    public ParticiperId getId() {
        return participerId;
    }

    public void setId(ParticiperId id) {
        this.participerId = id;
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
