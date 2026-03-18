package Hopitale;

import java.util.List;
import java.util.Scanner;

public class RechercherAction implements Action {

    @Override
    public void executer(Scanner sc) {
        
        List<Personne> resultats = Main.rechercherPersonne();
        if (resultats.isEmpty())
            System.out.println("Aucun résultat.");
        else
            resultats.forEach(System.out::println);
    }

    @Override
    public String getLibelle() {
        return "Rechercher une personne";
    }
}