package bar.sio.camping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Participer {
    @Id
    @ManyToOne
    private Utilisateur campeur;

    @ManyToOne
    private Creneau creneau;

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