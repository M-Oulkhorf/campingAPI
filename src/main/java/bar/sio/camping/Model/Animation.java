package bar.sio.camping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimation;
    private String libelleAnimation;

    public int getIdAnimation() {
        return idAnimation;
    }

    public void setIdAnimation(int idAnimation) {
        this.idAnimation = idAnimation;
    }

    public String getLibelleAnimation() {
        return libelleAnimation;
    }

    public void setLibelleAnimation(String libelleAnimation) {
        this.libelleAnimation = libelleAnimation;
    }
}