package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.JDBC.ResultSetStreamer;
import fr.univ_amu.iut.JDBC.RowMappers.EtudiantMapper;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public final class DAOEtudiantJDBC implements DAOEtudiant {
    private Connection connection;

    public DAOEtudiantJDBC() {
    }

    @Override
    public int computeNbEtudiant() {
        return (int) ResultSetStreamer.stream(connection, "SELECT * FROM ETUDIANT", new EtudiantMapper()).count();
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        return ResultSetStreamer.stream(connection, "SELECT * FROM ETUDIANT WHERE ANNEE = " + String.valueOf(annee), new EtudiantMapper()).collect(Collectors.toList());
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        return ResultSetStreamer.stream(connection, "SELECT * FROM ETUDIANT WHERE GROUPE = " + String.valueOf(groupe), new EtudiantMapper()).collect(Collectors.toList());
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        return ResultSetStreamer.stream(connection, "SELECT * FROM ETUDIANT WHERE NOM_ET = " + String.valueOf(nomEt), new EtudiantMapper()).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Etudiant obj) {
        return false;
    }

    @Override
    public List<Etudiant> findAll() {
        return ResultSetStreamer.stream(connection, "SELECT * FROM ETUDIANT", new EtudiantMapper()).collect(Collectors.toList());
    }

    @Override
    public Etudiant getById(int id) {
        return null;
    }

    @Override
    public Etudiant insert(Etudiant obj) {
        return null;
    }

    @Override
    public boolean update(Etudiant obj) {
        return false;
    }
}
