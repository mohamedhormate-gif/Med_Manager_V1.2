package Hopitale;

import java.time.LocalDate;

public class Infirmier extends Personne implements Consultable {

    private String numeroDiplome;
    private Hopitale.enums.specialite specialite;
    private ServiceHospitalier serviceActuel;

    public Infirmier(String id, String nom, String prenom,
                     LocalDate dateNaissance,
                     String numeroDiplome, Hopitale.enums.specialite ts) {
        super(id, nom, prenom, dateNaissance);
        this.numeroDiplome = numeroDiplome;
        this.specialite    = ts;
    }

    @Override
    public String getRole() { return "Inf."; }
    
    @Override
    public boolean peutConsulter(Patient patient) {
        // vrai seulement si le patient est dans le même service
        if (serviceActuel == null || patient.getServiceActuel() == null)
            return false;
        return serviceActuel.equals(patient.getServiceActuel());
    }

    public String getNumeroDiplome()                      { return numeroDiplome; }
    public Hopitale.enums.specialite getSpecialite()                         { return specialite; }
    public ServiceHospitalier getServiceActuel()          { return serviceActuel; }
    public void setServiceActuel(ServiceHospitalier s)    { this.serviceActuel = s; }

    public void administrerMedicament(String nom) {
        administrerMedicament(nom, 500.0);
    }

    public void administrerMedicament(String nom, double doseMg) {
        System.out.println("Médicament : " + nom + " — Dose : " + doseMg + " mg");
    }

    @Override
    public String toString() {
        return super.toString() + " - " + specialite + " | Dip: " + numeroDiplome;
    }

	@Override
	public String getAffichageComplets() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void affecter(ServiceHospitalier service) {
		// TODO Auto-generated method stub
		
	}*/
}