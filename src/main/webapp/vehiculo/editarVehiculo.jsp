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

<form>

    <input type="hidden"
           name="idVehiculo"
           value="<%= vehiculo.getIdVehiculo() %>">

    <label>Placa:</label>
    <input type="text"
           name="placa"
           value="<%= vehiculo.getPlaca() %>">
    <br><br>

    <label>Marca:</label>
    <input type="text"
           name="marca"
           value="<%= vehiculo.getMarca() %>">
    <br><br>

    <label>Modelo:</label>
    <input type="text"
           name="modelo"
           value="<%= vehiculo.getModelo() %>">
    <br><br>

    <label>Año:</label>
    <input type="number"
           name="anio"
           value="<%= vehiculo.getAnio() %>">
    <br><br>

    <label>Tipo:</label>
    <input type="text"
           name="tipoVehiculo"
           value="<%= vehiculo.getTipoVehiculo() %>">
    <br><br>

    <label>ID Cliente:</label>
    <input type="number"
           name="idCliente"
           value="<%= vehiculo.getIdCliente() %>">
    <br><br>

    <label>Estado:</label>
    <input type="text"
           name="estado"
           value="<%= vehiculo.getEstado() %>">
    <br><br>

    <button type="submit">
        Actualizar
    </button>

</form>

</body>
</html>