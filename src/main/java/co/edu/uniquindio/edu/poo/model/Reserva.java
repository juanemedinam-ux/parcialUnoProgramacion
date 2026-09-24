package co.edu.uniquindio.edu.poo.model;

import java.util.Arrays;

public class Reserva {
    private int codigo;
    private String fechaReserva;
    private byte numeroNoches;
    private String estadoReserva;
    private String metodoPago;
    private int valorTotal;

    private Huesped ownedByHuesped;
    private Habitacion[] listaHabitaciones;

    public Reserva(int codigo,String fechaReserva,byte numeroNoches,String estadoReserva,String metodoPago,int valorTotal) {
        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.numeroNoches = numeroNoches;
        this.estadoReserva = estadoReserva;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;

        listaHabitaciones= new Habitacion[100];
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public byte getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(byte numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Huesped getOwnedByHuesped() {
        return ownedByHuesped;
    }

    public void setOwnedByHuesped(Huesped ownedByHuesped) {
        this.ownedByHuesped = ownedByHuesped;
    }

    public Habitacion[] getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(Habitacion[] listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", numeroNoches=" + numeroNoches +
                ", estadoReserva='" + estadoReserva + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                ", ownedByHuesped=" + ownedByHuesped +
                ", listaHabitaciones=" + Arrays.toString(listaHabitaciones) +
                '}';
    }
}
