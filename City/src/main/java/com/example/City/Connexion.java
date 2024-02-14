package com.example.City;

import java.sql.*;

public class Connexion {
    private final String DBPath = "src/main/resources/data/city.db";
    private Connection connection = null;
    private Statement statement = null;

    public Connexion() {}

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connecxion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connecxion");
        }
    }

    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet queryAll(String requete) {
        PreparedStatement st = null;
        ResultSet resultat = null;
        try {
            st = connection.prepareStatement(requete);
            resultat = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requet : " + requete);
        }
        return resultat;
    }

    public ResultSet queryOneCity(String requete, String name) {
        PreparedStatement st = null;
        ResultSet resultat = null;
        try {
            st = connection.prepareStatement(requete);
            st.setString(1, name);
            resultat = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}
