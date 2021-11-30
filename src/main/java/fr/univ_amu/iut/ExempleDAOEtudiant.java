package fr.univ_amu.iut;

// Importer les classes jdbc
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;

public class ExempleDAOEtudiant {
    public static void main(String[] args){
    DAOEtudiant dao = new DAOEtudiantJDBC();
    Etudiant e = new Etudiant();//e est un Etudiant temporaire
    e.setNomEt("Vernet");
    e.setPrenomEt("William");
    e.setCpEt("13170");
    e.setVilleEt("Pennes-Mirabeau");
    e.setAnnee(1);//Modification des attributs de e 
    e.setGroupe(5);
    e = dao.insert(e);//e referencie maintenant un Etudiant definitif
    //...
    e.setAnnee(2);// Modification des attributs de e 
    e.setGroupe(3);
    //...
    boolean updateOk = dao.update(e);//Sauvegarde des modifications
    //...
  }
}
