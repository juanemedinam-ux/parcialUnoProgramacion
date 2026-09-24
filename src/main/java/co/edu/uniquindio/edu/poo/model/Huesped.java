package co.edu.uniquindio.edu.poo.model;

import java.util.ArrayList;



public class Huesped {
    private String documento;
    private String nombre;
    private byte edad;
    private String telefono;
    private String ciudad;
    // declarar las relaciones
    private ArrayList<Reserva> misReservas; // OwnedByHuesped


    public Huesped(String documento, String nombre, byte edad, String telefono, String ciudad){ //parametros informacion que entra
        //inicializar las variables
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.ciudad = ciudad;
        misReservas = new ArrayList<>();
    }



    public void setDocumento(String documento){
        this.documento = documento;
    }
    public String getDocumento(){
        return documento;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setEdad(byte edad){
        this.edad = edad;
    }
    public byte getEdad(){
        return edad;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public String getCiudad(){
        return ciudad;
    }
    public void setMisReservas(ArrayList<Reserva> misReservas){
        this.misReservas = misReservas;
    }
    public ArrayList<Reserva> getMisReservas(){
        return misReservas;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }


    public Reserva realizarReserva(String codigoReserva, String fechaReserva, byte numeroNoches,
                                   byte cantidadHuespedes, String metodoPago){
        Reserva reservaNueva = new Reserva(codigoReserva, fechaReserva, numeroNoches,
                cantidadHuespedes, metodoPago, this);
        misReservas.add(reservaNueva);
        return reservaNueva;
    }
}