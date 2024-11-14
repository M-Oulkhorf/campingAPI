package bar.sio.camping.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Creneau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCreneau;
    private LocalTime heureCreneau;
    private LocalDate dateCreneau;
    private int dureeCreneau;
    private int nbPlacesCreneau;

    @ManyToOne
    private Animation animation;

    @ManyToOne
    private Lieu lieu;

    public int getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(int idCreneau) {
        this.idCreneau = idCreneau;
    }

    public LocalTime getHeureCreneau() {
        return heureCreneau;
    }

    public void setHeureCreneau(LocalTime heureCreneau) {
        this.heureCreneau = heureCreneau;
    }

    public LocalDate getDateCreneau() {
        return dateCreneau;
    }

    public void setDateCreneau(LocalDate dateCreneau) {
        this.dateCreneau = dateCreneau;
    }

    public int getDureeCreneau() {
        return dureeCreneau;
    }

    public void setDureeCreneau(int dureeCreneau) {
        this.dureeCreneau = dureeCreneau;
    }

    public int getNbPlacesCreneau() {
        return nbPlacesCreneau;
    }

    public void setNbPlacesCreneau(int nbPlacesCreneau) {
        this.nbPlacesCreneau = nbPlacesCreneau;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
}