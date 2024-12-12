package bar.sio.camping.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Utilisateur campeur;

    @ManyToOne
    private Creneau creneau;

    private LocalDate dateAbsence;

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(LocalDate dateAbsence) {
        this.dateAbsence = dateAbsence;
    }
}
