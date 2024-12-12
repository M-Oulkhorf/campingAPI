package bar.sio.camping.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 50)
    private String identifiant;

    @NotBlank
    @Size(max = 50)
    private String nom;

    @NotBlank
    @Size(max = 50)
    private String prenom;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String mdp;

    @Enumerated(EnumType.STRING)
    private Role role;


    private int nombreAbsences;

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getNombreAbsences() {
        return nombreAbsences;
    }

    public void setNombreAbsences(int nombreAbsences) {
        this.nombreAbsences = nombreAbsences;
    }
}
