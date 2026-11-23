package com.crazymechanics.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase utilitaria encargada de gestionar la conexion JDBC
 * hacia la base de datos MySQL del sistema Crazy Mechanics.
 */
public class ConexionBD {

    // Parametros de conexion para la base de datos local en MySQL.
    private static final String URL =
            "jdbc:mysql://localhost:3306/crazy_mechanics?useSSL=false&serverTimezone=America/Bogota";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    private ConexionBD() {
        // Constructor privado para evitar instanciacion directa.
    }

    /**
     * Abre y retorna una nueva conexion a la base de datos.
     *
     * @return conexion activa {@link Connection} a MySQL
     * @throws SQLException si falla la carga del driver o la conexion
     */
    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver JDBC de MySQL.", e);
        }
    }
}
