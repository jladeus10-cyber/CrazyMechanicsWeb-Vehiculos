package com.crazymechanics.dao;

import com.crazymechanics.conexion.ConexionBD;
import com.crazymechanics.modelo.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Lista todos los vehículos registrados.
     *
     * @return Lista de vehículos
     */
    public List<Vehiculo> listarVehiculos() {

        List<Vehiculo> listaVehiculos = new ArrayList<>();

        String sql = "SELECT * FROM vehiculos";

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setIdVehiculo(rs.getInt("id_vehiculo"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnio(rs.getInt("anio"));
                vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
                vehiculo.setIdCliente(rs.getInt("id_cliente"));
                vehiculo.setEstado(rs.getString("estado"));

                listaVehiculos.add(vehiculo);
            }

        } catch (SQLException e) {

            System.err.println("Error al listar vehículos: "
                    + e.getMessage());
        }

        return listaVehiculos;
    }

    /**
     * Busca un vehículo por su ID.
     *
     * @param idVehiculo ID del vehículo
     * @return Vehículo encontrado o null
     */
    public Vehiculo buscarVehiculoPorId(int idVehiculo) {

        String sql = "SELECT * FROM vehiculos WHERE id_vehiculo = ?";

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ) {

            ps.setInt(1, idVehiculo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Vehiculo vehiculo = new Vehiculo();

                    vehiculo.setIdVehiculo(rs.getInt("id_vehiculo"));
                    vehiculo.setPlaca(rs.getString("placa"));
                    vehiculo.setMarca(rs.getString("marca"));
                    vehiculo.setModelo(rs.getString("modelo"));
                    vehiculo.setAnio(rs.getInt("anio"));
                    vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
                    vehiculo.setIdCliente(rs.getInt("id_cliente"));
                    vehiculo.setEstado(rs.getString("estado"));

                    return vehiculo;
                }
            }

        } catch (SQLException e) {

            System.err.println("Error al buscar vehículo: "
                    + e.getMessage());
        }

        return null;
    }

    /**
     * Actualiza un vehículo existente.
     *
     * @param vehiculo vehículo con los nuevos datos
     * @return true si se actualizó correctamente
     */
    public boolean actualizarVehiculo(Vehiculo vehiculo) {

        String sql = """
                UPDATE vehiculos
                SET placa = ?,
                    marca = ?,
                    modelo = ?,
                    anio = ?,
                    tipo_vehiculo = ?,
                    id_cliente = ?,
                    estado = ?
                WHERE id_vehiculo = ?
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
            ps.setInt(8, vehiculo.getIdVehiculo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.err.println("Error al actualizar vehículo: "
                    + e.getMessage());

            return false;
        }
    }
/**
 * Elimina un vehículo por su ID.
 *
 * @param idVehiculo ID del vehículo
 * @return true si se eliminó correctamente
 */
public boolean eliminarVehiculo(int idVehiculo) {

    String sql = "DELETE FROM vehiculos WHERE id_vehiculo = ?";

    try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
    ) {

        ps.setInt(1, idVehiculo);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.err.println("Error al eliminar vehículo: "
                + e.getMessage());

        return false;
    }
}
}