package co.edu.uniquindio.edu.poo.model;

import java.util.ArrayList;

public class Huesped {

    private String documento;
    private String nombre;
    private byte edad;
    private String numero;
    private String ciudad;


    private ArrayList<Reserva> listaReservas;

    public Huesped(String documento, String nombre, byte edad,
                   String numero, String ciudad) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.numero = numero;
        this.ciudad = ciudad;
        this.listaReservas = new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", numero='" + numero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listaReservas=" + listaReservas +
                '}';
    }
}
