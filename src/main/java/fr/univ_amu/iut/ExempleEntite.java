package fr.univ_amu.iut;

// Importer les classes jdbc
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExempleEntite {    
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
            ArrayList<Etudiant> listEtu = new ArrayList<>();
            // Affichage du resultat
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();

                etudiant.setNumEt(resultSet.getInt("NUM_ET"));
                etudiant.setNomEt(resultSet.getString("NOM_ET"));
                etudiant.setPrenomEt(resultSet.getString("PRENOM_ET"));
                etudiant.setCpEt(resultSet.getString("CP_ET"));
                etudiant.setVilleEt(resultSet.getString("VILLE_ET"));
                etudiant.setAnnee(resultSet.getInt("ANNEE"));
                etudiant.setGroupe(resultSet.getInt("GROUPE"));

                System.out.println(etudiant);
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
