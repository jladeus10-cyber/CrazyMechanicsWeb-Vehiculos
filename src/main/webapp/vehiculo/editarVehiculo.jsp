<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.crazymechanics.modelo.Vehiculo" %>

<%
Vehiculo vehiculo =
        (Vehiculo) request.getAttribute("vehiculo");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Vehículo</title>
</head>
<body>

<h2>Editar Vehículo</h2>

<form action="/CrazyMechanicsWeb/VehiculoServlet"
      method="post">

    <input type="hidden"
           name="accion"
           value="actualizar">

    <input type="hidden"
           name="idVehiculo"
           value="<%= vehiculo.getIdVehiculo() %>">

    <label>Placa:</label>
    <input type="text"
           name="placa"
           value="<%= vehiculo.getPlaca() %>"
           required>
    <br><br>

    <label>Marca:</label>
    <input type="text"
           name="marca"
           value="<%= vehiculo.getMarca() %>"
           required>
    <br><br>

    <label>Modelo:</label>
    <input type="text"
           name="modelo"
           value="<%= vehiculo.getModelo() %>"
           required>
    <br><br>

    <label>Año:</label>
    <input type="number"
           name="anio"
           value="<%= vehiculo.getAnio() %>"
           required>
    <br><br>

    <label>Tipo:</label>
    <input type="text"
           name="tipoVehiculo"
           value="<%= vehiculo.getTipoVehiculo() %>"
           required>
    <br><br>

    <label>ID Cliente:</label>
    <input type="number"
           name="idCliente"
           value="<%= vehiculo.getIdCliente() %>"
           required>
    <br><br>

    <label>Estado:</label>
    <input type="text"
           name="estado"
           value="<%= vehiculo.getEstado() %>"
           required>
    <br><br>

    <button type="submit">
        Actualizar Vehículo
    </button>

</form>

</body>
</html>