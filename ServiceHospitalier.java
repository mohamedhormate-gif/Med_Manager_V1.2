package Hopitale;

import Hopitale.enums.TypeService;

public class ServiceHospitalier {

    private String nom;
    private TypeService type;

    public ServiceHospitalier(String nom, TypeService type) {
        this.nom  = nom;
        this.type = type;
    }

    public String getNom()       { return nom; }
    public TypeService getType() { return type; }

    @Override
    public String toString() {
        return type.getNom() + " (" + type.getCode() + ")";
    }
}