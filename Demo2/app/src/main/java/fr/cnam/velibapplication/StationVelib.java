package fr.cnam.velibapplication;

/**
 * Created by fabrice on 09/11/2016.
 */

public class StationVelib {
    private String nom;
    private String numero;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "StationVelib{" +
                "nom='" + nom + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
