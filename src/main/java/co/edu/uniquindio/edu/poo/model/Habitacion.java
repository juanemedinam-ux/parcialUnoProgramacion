package co.edu.uniquindio.edu.poo.model;

public class Habitacion { // singular, el nombre de la clase debe ser la primer letra en mayuscula


    private String numeroHabitacion;
    private String tipoHabitacion; // Individual, Doble o Suite
    private byte piso;
    private byte capacidadPersonas;
    private double precio; // precio por noche
    private String estado; // Disponible, Reservada, Ocupada o Mantenimiento


    public Habitacion(String numeroHabitacion, String tipoHabitacion, byte piso,
                      byte capacidadPersonas, double precio){ //parametros informacion que entra
        //inicializar las variables
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
        return "Habitacion{" +
                "numeroHabitacion='" + numeroHabitacion + '\'' +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
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
        return "Estado de la habitacion actualizado con exito";
    }

    public boolean estaDisponible(){
        return estado.equalsIgnoreCase("Disponible");
    }
}