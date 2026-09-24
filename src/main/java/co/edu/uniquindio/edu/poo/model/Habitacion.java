package co.edu.uniquindio.edu.poo.model;

public class Habitacion {

    private String numeroHabitacion;
    private String tipoHabitacion;
    private byte piso;
    private byte capacidadPersonas;
    private int precio;
    private String estado;

    public Habitacion(String numeroHabitacion, String tipoHabitacion, byte piso,
                      byte capacidadPersonas, int precio, String estado) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
        this.capacidadPersonas = capacidadPersonas;
        this.precio = precio;
        this.estado = estado;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public byte getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(byte capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroHabitacion='" + numeroHabitacion + '\'' +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                ", piso=" + piso +
                ", capacidadPersonas=" + capacidadPersonas +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}';
    }
}