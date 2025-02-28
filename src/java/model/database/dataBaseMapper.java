package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.beans.Client;
import java.util.ArrayList;
import java.util.List;

public class dataBaseMapper {
    private static Connection con;

    // Initialisation de la connexion dans un bloc statique
    static {
        con = dataBaseConfig.getCon();
        if (con == null) {
            System.err.println("Échec de l'initialisation de la connexion à la base de données.");
        }
    }
   
    public List<Client> getAllClients() {
    List<Client> clients = new ArrayList<>();
    String query = "SELECT * FROM client";

    try {
        if (con == null) {
            System.err.println("La connexion est null. Impossible d'exécuter la requête.");
            return clients; // Return empty list
        }

        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String age = rs.getString("age");

            Client client = new Client(id, nom, age);
            clients.add(client);
        }

        rs.close();
        stmt.close();

    } catch (SQLException ex) {
        System.err.println("Erreur lors de la récupération des clients : " + ex.getMessage());
    }

    return clients;
}
}