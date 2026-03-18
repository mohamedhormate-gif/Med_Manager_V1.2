package Hopitale;

import java.time.LocalDate;

public class Medecin extends Personne implements Consultable,Assignable {

    private String specialite;
    private String matricule;

    public Medecin(String id, String nom, String prenom,
                   LocalDate dateNaissance,
                   String specialite, String matricule) {
        super(id, nom, prenom, dateNaissance);
        this.specialite = specialite;
        this.matricule  = matricule;
    }

    @Override
    public String getRole() { return "Dr."; }
    
    @Override
    public boolean peutConsulter(Patient patient) {
        return true; // un médecin peut toujours consulter
    }
    public String getSpecialite() { return specialite; }
    public String getMatricule()  { return matricule; }

    @Override
    public String toString() {
        return super.toString() + " - " + specialite + " | Mat: " + matricule;
    }

	@Override
	public String getAffichageComplets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affecter(ServiceHospitalier service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServiceHospitalier getServiceActuel() {
		// TODO Auto-generated method stub
		return null;
	}
}	