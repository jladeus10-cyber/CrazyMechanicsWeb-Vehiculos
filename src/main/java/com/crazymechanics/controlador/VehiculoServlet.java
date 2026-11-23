package com.crazymechanics.controlador;

import java.io.IOException;
import java.util.List;

import com.crazymechanics.dao.VehiculoDAO;
import com.crazymechanics.modelo.Vehiculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        VehiculoDAO vehiculoDAO = new VehiculoDAO();

        if ("editar".equals(accion)) {

    int idVehiculo =
            Integer.parseInt(request.getParameter("id"));

    Vehiculo vehiculo =
            vehiculoDAO.buscarVehiculoPorId(idVehiculo);

    request.setAttribute("vehiculo", vehiculo);

    request.getRequestDispatcher(
            "/vehiculo/editarVehiculo.jsp")
            .forward(request, response);

} else if ("eliminar".equals(accion)) {

    int idVehiculo =
            Integer.parseInt(request.getParameter("id"));

    boolean eliminado =
            vehiculoDAO.eliminarVehiculo(idVehiculo);

    if (eliminado) {

        response.sendRedirect("VehiculoServlet");

    } else {

        response.getWriter().println(
                "No fue posible eliminar el vehiculo.");
    }

} else {

    List<Vehiculo> listaVehiculos =
            vehiculoDAO.listarVehiculos();

    request.setAttribute("vehiculos", listaVehiculos);

    request.getRequestDispatcher(
            "/vehiculo/listarVehiculos.jsp")
            .forward(request, response);
   }
}

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String accion = request.getParameter("accion");

            VehiculoDAO vehiculoDAO = new VehiculoDAO();

            if ("actualizar".equals(accion)) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setIdVehiculo(
                        Integer.parseInt(
                                request.getParameter("idVehiculo")));

                vehiculo.setPlaca(
                        request.getParameter("placa"));

                vehiculo.setMarca(
                        request.getParameter("marca"));

                vehiculo.setModelo(
                        request.getParameter("modelo"));

                vehiculo.setAnio(
                        Integer.parseInt(
                                request.getParameter("anio")));

                vehiculo.setTipoVehiculo(
                        request.getParameter("tipoVehiculo"));

                vehiculo.setIdCliente(
                        Integer.parseInt(
                                request.getParameter("idCliente")));

                vehiculo.setEstado(
                        request.getParameter("estado"));

                boolean actualizado =
                        vehiculoDAO.actualizarVehiculo(vehiculo);

                if (actualizado) {

                    response.sendRedirect(
                            "VehiculoServlet");

                } else {

                    response.getWriter().println(
                            "No fue posible actualizar el vehiculo.");
                }

            } else {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setPlaca(
                        request.getParameter("placa"));

                vehiculo.setMarca(
                        request.getParameter("marca"));

                vehiculo.setModelo(
                        request.getParameter("modelo"));

                vehiculo.setAnio(
                        Integer.parseInt(
                                request.getParameter("anio")));

                vehiculo.setTipoVehiculo(
                        request.getParameter("tipoVehiculo"));

                vehiculo.setIdCliente(
                        Integer.parseInt(
                                request.getParameter("idCliente")));

                vehiculo.setEstado(
                        request.getParameter("estado"));

                boolean registrado =
                        vehiculoDAO.registrarVehiculo(vehiculo);

                if (registrado) {

                    response.getWriter().println(
                            "Vehiculo registrado correctamente.");

                } else {

                    response.getWriter().println(
                            "No fue posible registrar el vehiculo.");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error al procesar la solicitud: "
                            + e.getMessage());
        }
    }
}