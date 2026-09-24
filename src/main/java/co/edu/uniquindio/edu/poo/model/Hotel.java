package co.edu.uniquindio.edu.poo.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel {
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    private ArrayList<Huesped> listaHuespedes;
    private Habitacion[] listaHabitaciones;
    private ArrayList<Reserva> listaReservas;

    public Hotel(String nombre, String nit, String direccion,
                 String telefono) {

        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        listaHuespedes = new ArrayList<>();
        listaHabitaciones = new Habitacion[100];
        listaReservas = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(ArrayList<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public Habitacion[] getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(Habitacion[] listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaHuespedes=" + listaHuespedes +
                ", listaHabitaciones=" + Arrays.toString(listaHabitaciones) +
                ", listaReservas=" + listaReservas +
                '}';
    }
}
