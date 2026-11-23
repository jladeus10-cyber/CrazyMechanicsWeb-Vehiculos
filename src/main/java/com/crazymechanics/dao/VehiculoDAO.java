package com.crazymechanics.dao;

import com.crazymechanics.conexion.ConexionBD;
import com.crazymechanics.modelo.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DAO encargado de las operaciones de acceso a datos
 * para la entidad Vehiculo.
 */
public class VehiculoDAO {

    /**
     * Registra un nuevo vehículo en la base de datos.
     *
     * @param vehiculo Objeto con la información del vehículo
     * @return true si se registra correctamente, false en caso contrario
     */
    public boolean registrarVehiculo(Vehiculo vehiculo) {

        String sql = """
                INSERT INTO vehiculos
                (placa, marca, modelo, anio, tipo_vehiculo, id_cliente, estado)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ) {

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAnio());
            ps.setString(5, vehiculo.getTipoVehiculo());
            ps.setInt(6, vehiculo.getIdCliente());
            ps.setString(7, vehiculo.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.err.println("Error al registrar vehículo: "
                    + e.getMessage());

            return false;
        }
    }
}