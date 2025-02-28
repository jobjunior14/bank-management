package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseConfig {
    private static Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/try"; 
    private static final String user = "root";
    private static final String password = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connexion réussie à la base de données !");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("❌ Erreur connexion BD : " + ex.getMessage());
        }
    }

    public static Connection getCon() {  
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Connexion rétablie avec succès !");
            } catch (SQLException e) {
                System.err.println("❌ Impossible d'établir une connexion à la BD : " + e.getMessage());
            }
        }
        return con;
    }
}