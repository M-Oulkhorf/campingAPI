package bar.sio.camping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLieu;
    private String libelleLieu;
    private String coordoneesLieu;

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getLibelleLieu() {
        return libelleLieu;
    }

    public void setLibelleLieu(String libelleLieu) {
        this.libelleLieu = libelleLieu;
    }

    public String getCoordoneesLieu() {
        return coordoneesLieu;
    }

    public void setCoordoneesLieu(String coordoneesLieu) {
        this.coordoneesLieu = coordoneesLieu;
    }
}