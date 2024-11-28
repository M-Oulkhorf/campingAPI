package bar.sio.camping.Model;

import jakarta.persistence.*;

@Entity
public class Animer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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