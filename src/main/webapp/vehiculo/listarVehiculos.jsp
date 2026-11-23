<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.crazymechanics.modelo.Vehiculo" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Vehículos</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>

<h2>Listado de Vehículos</h2>

<%
    List<Vehiculo> vehiculos =
            (List<Vehiculo>) request.getAttribute("vehiculos");
%>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Placa</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Año</th>
            <th>Tipo</th>
            <th>ID Cliente</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
    </thead>

    <tbody>

    <%
        if (vehiculos != null && !vehiculos.isEmpty()) {

            for (Vehiculo vehiculo : vehiculos) {
    %>

        <tr>
            <td><%= vehiculo.getIdVehiculo() %></td>
            <td><%= vehiculo.getPlaca() %></td>
            <td><%= vehiculo.getMarca() %></td>
            <td><%= vehiculo.getModelo() %></td>
            <td><%= vehiculo.getAnio() %></td>
            <td><%= vehiculo.getTipoVehiculo() %></td>
            <td><%= vehiculo.getIdCliente() %></td>
            <td><%= vehiculo.getEstado() %></td>

             <td>
             <a href="VehiculoServlet?accion=editar&id=<%= vehiculo.getIdVehiculo() %>">
             Editar
             </a>
</td>
        </tr>

    <%
            }
        } else {
    %>

        <tr>
            <td colspan="8">No hay vehículos registrados.</td>
        </tr>

    <%
        }
    %>

    </tbody>
</table>

</body>
</html>