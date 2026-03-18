package Hopitale;

import java.util.Scanner;

public class StatistiquesAction implements Action {

    @Override
    public void executer(Scanner sc) {
        Main.afficherStatistiques();
    }

    @Override
    public String getLibelle() {
        return "Afficher les statistiques";
    }
}