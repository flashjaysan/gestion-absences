package di21.bloc4.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import di21.bloc4.dao.Learner;

public class Main {

	private static final String POSTGRESQL_DRIVER_NAME = "org.postgresql.Driver";
	private static final String POSTGRESQL_DB_CONNECTION = "jdbc:postgresql://localhost:5432/bloc4java";
	private static final String POSTGRESQL_DB_LOGIN = "postgres";
	private static final String POSTGRESQL_DB_PASSWORD = "root";
	
	private static Scanner scanner;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// initialisation du scanner pour les entrées utilisateur
		scanner = new Scanner(System.in);
		
		// boucle d'exécution
		boolean loop = true;
		
		while(loop) {
			String action = "visualiser";
			
			switch(action) {
			case "ajouter":
				addLearner();
				loop = false; // quitter la boucle après ajout
				break;
			case "visualiser":
				displayAllLearners();
				loop = false; // quitter la boucle après affichage
				break;
			}	
		}
	}
	
	private static void addLearner() throws ClassNotFoundException, SQLException {
		System.out.println("AJOUT D'APPRENANT");

		Learner learner = getLearnerFromUser();
		
		insertToDatabase(learner);
        
		System.out.println("L'apprenant :");
		System.out.println(learner);
		System.out.println(" a été ajouté.");
	}
	
	private static Learner getLearnerFromUser() {
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
		return new Learner(
			0,
			group,
			firstName,
			lastName,
			emailAddress,
			phoneNumber,
			0,
			isDelegate
		);
	}
        
    private static void insertToDatabase(Learner learner) throws SQLException, ClassNotFoundException {
		Class.forName(POSTGRESQL_DRIVER_NAME);
        
        try (Connection connection = DriverManager.getConnection(POSTGRESQL_DB_CONNECTION, POSTGRESQL_DB_LOGIN, POSTGRESQL_DB_PASSWORD)) {
        	try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO learner(group_name, first_name, last_name, email_address, phone_number, absence_quantity, is_delegate) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
	            preparedStatement.setString(1, learner.getGroup()); // group_name
	            preparedStatement.setString(2, learner.getFirstName()); // first_name
	            preparedStatement.setString(3, learner.getLastName()); // last_name
	            preparedStatement.setString(4, learner.getEmailAddress()); // email_address
	            preparedStatement.setString(5, learner.getPhoneNumber()); // phone_number
	            preparedStatement.setInt(6, learner.getAbscenceQuantity()); // abscence_quantity
	            preparedStatement.setBoolean(7, learner.isDelegate()); // is_delegate
	            
	            preparedStatement.executeUpdate();

	            // récupération de l'id générée en base de données
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    learner.setId(generatedKeys.getLong(1));
	                }
	            }
            }
        }
    }
    
    private static void displayAllLearners() throws ClassNotFoundException, SQLException {
    	List<Learner> learners = getAllFromDatabase();
    	
    	for (Learner learner : learners) {
    		System.out.println(learner);
    	}
    }
    
    private static List<Learner> getAllFromDatabase() throws ClassNotFoundException, SQLException {
    	List<Learner> learners = new ArrayList<Learner>();
    	
		Class.forName(POSTGRESQL_DRIVER_NAME);
        
        try (Connection connection = DriverManager.getConnection(POSTGRESQL_DB_CONNECTION, POSTGRESQL_DB_LOGIN, POSTGRESQL_DB_PASSWORD)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM learner")) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String group = resultSet.getString("group_name");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String emailAddress = resultSet.getString("email_address");
                        String phoneNumber = resultSet.getString("phone_number");
                        int absenceQuantity = resultSet.getInt("absence_quantity");
                        boolean isDelegate = resultSet.getBoolean("is_delegate");
                        
                        Learner learner = new Learner(
                    		id,
                    		group,
                    		firstName,
                    		lastName,
                    		emailAddress,
                    		phoneNumber,
                    		absenceQuantity,
                    		isDelegate
                        );
                        
                        learners.add(learner);
                    }
                }
            }
        }
    	
        return learners;
    }

}
