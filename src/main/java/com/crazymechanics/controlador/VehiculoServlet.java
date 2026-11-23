package com.crazymechanics.controlador;

import java.io.IOException;

import com.crazymechanics.dao.VehiculoDAO;
import com.crazymechanics.modelo.Vehiculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de gestionar las operaciones
 * relacionadas con los vehículos.
 */
@WebServlet("/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Vehiculo vehiculo = new Vehiculo();

            vehiculo.setPlaca(request.getParameter("placa"));
            vehiculo.setMarca(request.getParameter("marca"));
            vehiculo.setModelo(request.getParameter("modelo"));
            vehiculo.setAnio(
                    Integer.parseInt(request.getParameter("anio")));
            vehiculo.setTipoVehiculo(
                    request.getParameter("tipoVehiculo"));
            vehiculo.setIdCliente(
                    Integer.parseInt(request.getParameter("idCliente")));
            vehiculo.setEstado(request.getParameter("estado"));

            VehiculoDAO vehiculoDAO = new VehiculoDAO();

            boolean registrado = vehiculoDAO.registrarVehiculo(vehiculo);

            if (registrado) {
                response.getWriter().println(
                        "Vehiculo registrado correctamente.");
            } else {
                response.getWriter().println(
                        "No fue posible registrar el vehiculo.");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error al procesar la solicitud: "
                            + e.getMessage());
        }
    }
}