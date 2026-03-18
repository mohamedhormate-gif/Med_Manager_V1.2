package Hopitale;
import Hopitale.enums.*;
import java.time.LocalDate;

public class Patient extends Personne implements Assignable{

    private GroupeSanguin groupeSanguin;
    private ServiceHospitalier serviceActuel;

    public Patient(String id, String nom, String prenom, LocalDate dateNaissance) {
        super(id, nom, prenom, dateNaissance);
    }

    @Override
    public String getRole() { return "Patient"; }

    public GroupeSanguin getGroupeSanguin()              { return groupeSanguin; }
    public void setGroupeSanguin(GroupeSanguin gs)       { this.groupeSanguin = gs; }
    public ServiceHospitalier getServiceActuel()         { return serviceActuel; }
    public void setServiceActuel(ServiceHospitalier s)   { this.serviceActuel = s; }

    @Override
    public String toString() {
        String gs = (groupeSanguin != null) ? " | Sang: " + groupeSanguin.getLabel() : "";
        return super.toString() + gs;
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
}
