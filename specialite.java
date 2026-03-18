package Hopitale.enums;

public enum specialite {

    CARDIOLOGIE("Cardiologie", "Maladies du cœur et des vaisseaux"),
    NEUROLOGIE("Neurologie", "Maladies du système nerveux"),
    PEDIATRIE("Pédiatrie", "Soins aux enfants et adolescents"),
    CHIRURGIE("Chirurgie", "Interventions chirurgicales"),
    DERMATOLOGIE("Dermatologie", "Maladies de la peau"),
    RADIOLOGIE("Radiologie", "Imagerie médicale et diagnostics"),
    ONCOLOGIE("Oncologie", "Traitement des cancers"),
    GYNECOLOGIE("Gynécologie", "Santé féminine et obstétrique");

    private final String nom;
    private final String description;

    specialite(String nom, String description) {
        this.nom         = nom;
        this.description = description;
    }

    public String getNom()         { return nom; }
    public String getDescription() { return description; }

    @Override
    public String toString() { return nom; }
}