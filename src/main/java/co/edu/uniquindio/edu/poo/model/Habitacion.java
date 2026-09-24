package co.edu.uniquindio.edu.poo.model;

public class Habitacion {

    private String numeroHabitacion;
    private String tipoHabitacion;
    private byte piso;
    private byte capacidadPersonas;
    private double precio;
    private String estado;


    public Habitacion(String numeroHabitacion, String tipoHabitacion, byte piso,
                      byte capacidadPersonas, double precio){
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
        this.capacidadPersonas = capacidadPersonas;
        this.precio = precio;
        this.estado = "Disponible";
    }


    public void setNumeroHabitacion(String numeroHabitacion){
        this.numeroHabitacion = numeroHabitacion;
    }
    public String getNumeroHabitacion(){
        return numeroHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion){
        this.tipoHabitacion = tipoHabitacion;
    }
    public String getTipoHabitacion(){
        return tipoHabitacion;
    }
    public void setPiso(byte piso){
        this.piso = piso;
    }
    public byte getPiso(){
        return piso;
    }
    public void setCapacidadPersonas(byte capacidadPersonas){
        this.capacidadPersonas = capacidadPersonas;
    }
    public byte getCapacidadPersonas(){
        return capacidadPersonas;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public double getPrecio(){
        return precio;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getEstado(){
        return estado;
    }

    @Override
    public String toString() {
        return "Habitación{" +
                "numeroHabitación='" + numeroHabitacion + '\'' +
                ", tipoHabitación='" + tipoHabitacion + '\'' +
                ", piso=" + piso +
                ", capacidadPersonas=" + capacidadPersonas +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}';
    }


    public String actualizarEstado(String nuevoEstado){
        if (!nuevoEstado.equalsIgnoreCase("Disponible") &&
                !nuevoEstado.equalsIgnoreCase("Reservada") &&
                !nuevoEstado.equalsIgnoreCase("Ocupada") &&
                !nuevoEstado.equalsIgnoreCase("Mantenimiento")) {
            return "Error, el estado ingresado no es valido";
        }
        this.estado = nuevoEstado;
        return "Estado de la habitación actualizado con éxito";
    }

    public boolean estaDisponible(){
        return estado.equalsIgnoreCase("Disponible");
    }
}