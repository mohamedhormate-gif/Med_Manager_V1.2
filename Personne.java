package Hopitale;


import java.time.LocalDate;
import java.time.Period;

public abstract class Personne implements Identifiable, Affichable{

    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    public Personne(String id, String nom, String prenom, LocalDate dateNaissance) {
        this.id            = id;
        this.nom           = nom;
        this.prenom        = prenom;
        this.dateNaissance = dateNaissance;
    }

    public abstract String getRole();

    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    @Override public String getId()              { return id; }
    public String getNom()                       { return nom; }
    public String getPrenom()                    { return prenom; }
    public LocalDate getDateNaissance()          { return dateNaissance; }

    @Override
    public String getIdentieComplete() {
        return getRole() + " " + prenom + " " + nom;
    }

    @Override
    public String getAffichageComplets(){
        return String.format("%-8s %-8s %-15s %-15s %d ans",
                id, getRole(), nom, prenom, getAge());
    }

    @Override
    public String toString() {
        return getRole() + " " + prenom + " " + nom;
    }
}		