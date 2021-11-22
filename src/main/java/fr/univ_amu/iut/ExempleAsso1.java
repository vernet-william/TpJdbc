package fr.univ_amu.iut;

// Importer les classes jdbc
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExempleAsso1 {    
    // La requete de test
    private static final String reqEtudiantsAixois =
            "SELECT NUM_ET, NOM_ET, PRENOM_ET, CP_ET, VILLE_ET, ANNEE, GROUPE  " +
                    "FROM ETUDIANT " +
                    "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base de données
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            System.out.println("Connecte\n");
            
            // Creation d'une instruction SQL
            Statement statement = conn.createStatement();
            
            // Execution de la requete
            System.out.println("Execution de la requete : " + reqEtudiantsAixois);
            ResultSet resultSet = statement.executeQuery(reqEtudiantsAixois);
            ArrayList<Prof> listProf = new ArrayList<>();
            // Affichage du resultat
            while (resultSet.next()) {
                Prof prof = new Prof();

                prof.setNumProf(resultSet.getInt("NUM_PROF"));
                prof.setNomProf(resultSet.getString("NOM_PROF"));
                prof.setPrenomProf(resultSet.getString("PRENOM_PROF"));
                prof.setAdrProf(resultSet.getString("ADR_PROF"));
                prof.setCpProf(resultSet.getString("CP_PROF"));
                prof.setVilleProf(resultSet.getString("VILLE_PROF"));
                Module module = new Module();
                prof.setMatSpec(module);//PAS SUR DU TOUT

                System.out.println(prof);
                listProf.add(prof);
            }

            // Fermeture de l'instruction (liberation des ressources)
            statement.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
