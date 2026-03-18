package Hopitale.enums;

public enum TypeService {

    CARDIOLOGIE("Cardiologie", "CARD"),
    URGENCES("Urgences",       "URG"),
    PEDIATRIE("Pédiatrie",     "PEDI"),
    NEUROLOGIE("Neurologie",   "NEUR"),
    CHIRURGIE("Chirurgie",     "CHIR");

    private final String nom;
    private final String code;

    TypeService(String nom, String code) {
        this.nom  = nom;
        this.code = code;
    }

    public String getNom()  { return nom; }
    public String getCode() { return code; }
}