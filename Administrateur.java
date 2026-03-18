package Hopitale;

import java.time.LocalDate;

public class Administrateur extends Personne {

    private String departement;
    private String poste;

    public Administrateur(String id, String nom, String prenom,
                          LocalDate dateNaissance,
                          String departement, String poste) {
        super(id, nom, prenom, dateNaissance);
        this.departement = departement;
        this.poste       = poste;
    }

    @Override
    public String getRole() { return "Admin."; }

    public String getDepartement() { return departement; }
    public String getPoste()       { return poste; }

    @Override
    public String toString() {
        return super.toString() + " - " + poste + " | Dept: " + departement;
    }

	@Override
	public String getAffichageComplets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentieComplete() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
public void affecter(ServiceHospitalier service) {
		// TODO Auto-generated method stub
		
	}*/

	/*@Override
	public ServiceHospitalier getServiceActuel() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	/*@Override
	public String getIdentieComplete() {
		// TODO Auto-generated method stub
		return null;
	}*/
}