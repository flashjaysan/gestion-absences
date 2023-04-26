package di21.bloc4.app;

import java.util.Scanner;
import di21.bloc4.dao.Learner;

public class Main {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		// initialisation du scanner pour les entrées utilisateur
		scanner = new Scanner(System.in);
		
		// boucle d'exécution
		boolean loop = true;
		
		while(loop) {
			String action = "ajouter";
			
			switch(action) {
			case "ajouter":
				addLearner();
				loop = false; // quitter la boucle après ajout
				break;
			}	
		}
	}
	
	private static void addLearner() {
		System.out.println("AJOUT D'APPRENANT");
		System.out.println("Veuillez saisir les informations du nouvel apprenant :");

		// récupération des saisies utilisateur
		System.out.println("Promotion : ");
		String group = scanner.nextLine();
		
		System.out.println("Prénom : ");
		String firstName = scanner.nextLine();
		
		System.out.println("Nom : ");
		String lastName = scanner.nextLine();
		
		System.out.println("Adresse email : ");
		String emailAddress = scanner.nextLine();
		
		System.out.println("Numéro de téléphone : ");
		String phoneNumber = scanner.nextLine();
		
		System.out.println("Délégué (O/N) : ");
		boolean isDelegate = scanner.nextLine().charAt(0) == 'O';
		
		// instanciation d'un apprenant
		Learner learner = new Learner(
			0,
			group,
			firstName,
			lastName,
			emailAddress,
			phoneNumber,
			0,
			isDelegate
		);
		
		System.out.println("Ajout de l'apprenant :");
		System.out.println(learner);
	}

}
