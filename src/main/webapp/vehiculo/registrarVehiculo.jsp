<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Vehículos</title>
</head>
<body>

    <h2>Registrar Vehículo</h2>

    <form action="${pageContext.request.contextPath}/VehiculoServlet"
          method="post">

        <label>Placa:</label>
        <input type="text" name="placa" required>
        <br><br>

        <label>Marca:</label>
        <input type="text" name="marca" required>
        <br><br>

        <label>Modelo:</label>
        <input type="text" name="modelo" required>
        <br><br>

        <label>Año:</label>
        <input type="number" name="anio" required>
        <br><br>

        <label>Tipo de Vehículo:</label>
        <input type="text" name="tipoVehiculo" required>
        <br><br>

        <label>ID Cliente:</label>
        <input type="number" name="idCliente" required>
        <br><br>

        <label>Estado:</label>
        <input type="text" name="estado" required>
        <br><br>

        <button type="submit">Registrar</button>

    </form>

</body>
</html>