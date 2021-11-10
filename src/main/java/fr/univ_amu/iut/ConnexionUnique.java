package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
    private static ConnexionUnique instance;
    private Connection connection;

	private static final String CONNECT_URL = "jdbc:mysql://localhost:3306/GestionPedaBD";
	private static final String LOGIN = "monUser";
	private static final String PASSWORD = "monPassword";

    public Connection getConnection(){
        return connection;
    }

    public static ConnexionUnique getInstance() throws SQLException{
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;
    }

    private ConnexionUnique() throws SQLException{
        connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
    }
}
