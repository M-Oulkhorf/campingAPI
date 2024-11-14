package bar.sio.camping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Animer {
    @Id
    @ManyToOne
    private Creneau creneau;

    @ManyToOne
    private Utilisateur animateur;

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public Utilisateur getAnimateur() {
        return animateur;
    }

    public void setAnimateur(Utilisateur animateur) {
        this.animateur = animateur;
    }
}