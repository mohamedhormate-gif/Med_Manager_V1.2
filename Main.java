package Hopitale;

import Hopitale.enums.GroupeSanguin;
//import Hopitale.enums.TypeService;
import Hopitale.enums.specialite;

//import Hopitale.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Personne> personnel = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Données initiales
        Medecin dr = new Medecin("M001", "Benjelloun", "Sara",
                LocalDate.of(1980, 3, 15), "Cardiologie", "MAT-442");

        Patient pat = new Patient("P001", "Amrani", "Youssef",
                LocalDate.of(1995, 7, 22));
        pat.setGroupeSanguin(GroupeSanguin.A_POSITIF);

        Infirmier inf = new Infirmier("I001", "Chakir", "Fatima", LocalDate.of(1992, 1, 10), "DIP-789",specialite.CARDIOLOGIE);

        Administrateur admin = new Administrateur("A001", "Idrissi", "Karim",
                LocalDate.of(1978, 5, 20), "RH", "Directeur");

        personnel.add(dr);
        personnel.add(pat);
        personnel.add(inf);
        personnel.add(admin);

        boolean running = true;
        while (running) {
            afficherMenu();
            System.out.print("Votre choix : ");
            String choix = sc.nextLine().trim();
            String terme2;
            switch (choix) {
                case "1" -> ajouterMedecin();
                case "2" -> ajouterPatient();
                case "3" -> ajouterInfirmier();
                case "4" -> ajouterAdministrateur();
                case "5" -> afficherToutLePersonnel();
                case "6" -> rechercherPersonne();
                case "7" -> afficherStatistiques();
                case "0" -> { System.out.println("Au revoir !"); running = false; }
                default  -> System.out.println("Choix invalide.\n");
            }
        }
        sc.close();
    }

    static void afficherMenu() {
        System.out.println();
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║       🏥  MEDMANAGER v1.2         ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║  [1]  Ajouter un Médecin          ║");
        System.out.println("║  [2]  Ajouter un Patient          ║");
        System.out.println("║  [3]  Ajouter un Infirmier        ║");
        System.out.println("║  [4]  Ajouter un Administrateur   ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║  [5]  Voir tout le personnel      ║");
        System.out.println("║  [6]  Rechercher une personne     ║");
        System.out.println("║  [7]  Statistiques                ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║  [0]  Quitter                     ║");
        System.out.println("╚═══════════════════════════════════╝");
    }

    static void ajouterMedecin() {
        System.out.println("\n── Ajouter un Médecin ──");
        System.out.print("ID         : "); String id     = sc.nextLine();
        System.out.print("Nom        : "); String nom    = sc.nextLine();
        System.out.print("Prénom     : "); String prenom = sc.nextLine();
        System.out.print("Naissance (AAAA-MM-JJ) : ");
        LocalDate dn = LocalDate.parse(sc.nextLine());
        System.out.print("Spécialité : "); String spe = sc.nextLine();
        System.out.print("Matricule  : "); String mat = sc.nextLine();
        personnel.add(new Medecin(id, nom, prenom, dn, spe, mat));
        System.out.println("✅ Médecin ajouté !");
    }

    static void ajouterPatient() {
        System.out.println("\n── Ajouter un Patient ──");
        System.out.print("ID        : "); String id     = sc.nextLine();
        System.out.print("Nom       : "); String nom    = sc.nextLine();
        System.out.print("Prénom    : "); String prenom = sc.nextLine();
        System.out.print("Naissance (AAAA-MM-JJ) : ");
        LocalDate dn = LocalDate.parse(sc.nextLine());
        Patient p = new Patient(id, nom, prenom, dn);
        System.out.print("Groupe sanguin (A+, B-, AB+...) : ");
        try { p.setGroupeSanguin(GroupeSanguin.fromLabel(sc.nextLine())); }
        catch (Exception e) { System.out.println("⚠️  Groupe ignoré."); }
        personnel.add(p);
        System.out.println("✅ Patient ajouté !");
    }

    static void ajouterInfirmier() {
        System.out.println("\n── Ajouter un Infirmier ──");
        System.out.print("ID        : "); String id     = sc.nextLine();
        System.out.print("Nom       : "); String nom    = sc.nextLine();
        System.out.print("Prénom    : "); String prenom = sc.nextLine();
        System.out.print("Naissance (AAAA-MM-JJ) : ");
        LocalDate dn = LocalDate.parse(sc.nextLine());
        System.out.print("N° Diplôme : "); String dip = sc.nextLine();
        System.out.println("Services : URGENCES, CARDIOLOGIE, PEDIATRIE, NEUROLOGIE,");
        System.out.println("           SOINS_INTENSIFS, CHIRURGIE, RADIOLOGIE, ONCOLOGIE");
        System.out.print("Service : ");
        specialite ts = specialite.valueOf(sc.nextLine().toUpperCase());
        personnel.add(new Infirmier(id, nom, prenom, dn, dip, ts));
        System.out.println("✅ Infirmier ajouté !");
    }

    static void ajouterAdministrateur() {
        System.out.println("\n── Ajouter un Administrateur ──");
        System.out.print("ID          : "); String id     = sc.nextLine();
        System.out.print("Nom         : "); String nom    = sc.nextLine();
        System.out.print("Prénom      : "); String prenom = sc.nextLine();
        System.out.print("Naissance (AAAA-MM-JJ) : ");
        LocalDate dn = LocalDate.parse(sc.nextLine());
        System.out.print("Département : "); String dep   = sc.nextLine();
        System.out.print("Poste       : "); String poste = sc.nextLine();
        personnel.add(new Administrateur(id, nom, prenom, dn, dep, poste));
        System.out.println("✅ Administrateur ajouté !");
    }

    static void afficherToutLePersonnel() {
        if (personnel.isEmpty()) { System.out.println("\n⚠️  Aucun personnel."); return; }
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              Personnel de l'hôpital                     ║");
        System.out.println("╠════════╦════════╦═══════════════╦═══════════════╦═══════╣");
        System.out.printf( "║ %-6s ║ %-6s ║ %-13s ║ %-13s ║ %-5s ║%n",
                "ID","Rôle","Nom","Prénom","Âge");
        System.out.println("╠════════╬════════╬═══════════════╬═══════════════╬═══════╣");
        for (Personne p : personnel) {
            System.out.printf("║ %-6s ║ %-6s ║ %-13s ║ %-13s ║ %-3d   ║%n",
                    p.getId(), p.getRole(), p.getNom(), p.getPrenom(), p.getAge());
            if (p instanceof Medecin m)
                System.out.println("║  └ Spé: " + m.getSpecialite() + " | Mat: " + m.getMatricule());
            else if (p instanceof Infirmier i)
                System.out.println("║  └ Spé: " + i.getSpecialite() + " | Dip: " + i.getNumeroDiplome());
            else if (p instanceof Patient pt && pt.getGroupeSanguin() != null)
                System.out.println("║  └ Sang: " + pt.getGroupeSanguin().getLabel());
            else if (p instanceof Administrateur a)
                System.out.println("║  └ Poste: " + a.getPoste() + " | Dép: " + a.getDepartement());
        }
        System.out.println("╠════════╩════════╩═══════════════╩═══════════════╩═══════╣");
        System.out.printf( "║  Total : %-47s ║%n", personnel.size() + " personne(s)");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    /*  version 1  static void rechercherPersonne() {
        System.out.print("\nTerme (nom / prénom / ID) : ");
        String terme = sc.nextLine().trim().toLowerCase();
        List<Personne> res = new ArrayList<>();
        for (Personne p : personnel)
            if (p.getNom().toLowerCase().contains(terme)
             || p.getPrenom().toLowerCase().contains(terme)
             || p.getId().toLowerCase().contains(terme))
                res.add(p);
        if (res.isEmpty()) { System.out.println("❌ Aucun résultat."); return; }
        System.out.println("\nRésultats (" + res.size() + ") :");
        System.out.println("-".repeat(58));
        for (Personne p : res) System.out.println("  " + p.getAffichageComplets());
        System.out.println("-".repeat(58));
    }*/
    //version 2
    static List<Personne> rechercherPersonne() {
        System.out.print("\nTerme (nom / prénom / ID) : ");
        String terme = sc.nextLine().trim().toLowerCase();

        List<Personne> res = new ArrayList<>();

        for (Personne p : personnel) {
            String nom = p.getNom() != null ? p.getNom().toLowerCase() : "";
            String prenom = p.getPrenom() != null ? p.getPrenom().toLowerCase() : "";
            String id = p.getId() != null ? p.getId().toLowerCase() : "";

            if (nom.contains(terme) || prenom.contains(terme) || id.contains(terme)) {
                res.add(p);
            }
        }

        return res;
    }

    static void afficherStatistiques() {
        long med  = personnel.stream().filter(p -> p instanceof Medecin).count();
        long pat  = personnel.stream().filter(p -> p instanceof Patient).count();
        long inf  = personnel.stream().filter(p -> p instanceof Infirmier).count();
        long adm  = personnel.stream().filter(p -> p instanceof Administrateur).count();
        System.out.println();
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║         Statistiques              ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.printf( "║  Médecins        : %-14d ║%n", med);
        System.out.printf( "║  Patients        : %-14d ║%n", pat);
        System.out.printf( "║  Infirmiers      : %-14d ║%n", inf);
        System.out.printf( "║  Administrateurs : %-14d ║%n", adm);
        System.out.println("╠═══════════════════════════════════╣");
        System.out.printf( "║  Total           : %-14d ║%n", personnel.size());
        System.out.println("╚═══════════════════════════════════╝");
    }
}
