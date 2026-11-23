package com.crazymechanics.modelo;

/**
 * Representa la entidad de dominio Vehiculo dentro del sistema Crazy Mechanics.
 * Mapea los atributos principales de un vehiculo registrado en el taller.
 */
public class Vehiculo {

    private int idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String tipoVehiculo;
    private int idCliente;
    private String estado;

    /**
     * Constructor vacio requerido para instanciacion y mapeo de datos.
     */
    public Vehiculo() {
    }

    /**
     * Constructor con todos los atributos del vehiculo.
     *
     * @param idVehiculo   identificador unico del vehiculo
     * @param placa        placa alfanumerica del vehiculo
     * @param marca        marca del fabricante
     * @param modelo       linea o modelo del vehiculo
     * @param anio         anio de fabricacion
     * @param tipoVehiculo tipo de vehiculo (ej. Motocicleta, Automovil)
     * @param idCliente    identificador del cliente propietario
     * @param estado       estado actual en el sistema (ej. ACTIVO, INACTIVO)
     */
    public Vehiculo(int idVehiculo, String placa, String marca, String modelo,
                    int anio, String tipoVehiculo, int idCliente, String estado) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipoVehiculo = tipoVehiculo;
        this.idCliente = idCliente;
        this.estado = estado;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}