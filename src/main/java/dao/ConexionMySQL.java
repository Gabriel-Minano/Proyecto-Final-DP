package dao;

import java.sql.*;

public class ConexionMySQL {

    public static final String URL = "jdbc:mysql://localhost:3306/colegio";
    public static final String USER = "root";
    public static final String PASS = "";

    //instancia única
    private static ConexionMySQL instancia;

    //única conexión activa
    private Connection conexion;

    public ConexionMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al momento de conectar: " + ex.getMessage());
        }
    }

    //para obtener la instancia única
        public static synchronized ConexionMySQL getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMySQL();
        }
        return instancia;
    }

    // Devuelve siempre la misma conexión
    public Connection getConexion() {
        return conexion;
    }

}
