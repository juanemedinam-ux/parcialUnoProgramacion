        package co.edu.uniquindio.edu.poo.model;

import java.util.Arrays;

public class Reserva {

    private int codigo;
    private String fechaReserva;
    private byte numeroNoches;
    private byte cantidadHuespedes;
    private String estadoReserva;
    private String metodoPago;
    private int valorTotal;

    private Huesped ownedByHuesped;
    private Habitacion[] listaHabitaciones;




    public Reserva(int codigo,
                   String fechaReserva,
                   byte numeroNoches,
                   byte cantidadHuespedes,
                   String estadoReserva,
                   String metodoPago,
                   int valorTotal) {

        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.numeroNoches = numeroNoches;
        this.cantidadHuespedes = cantidadHuespedes;
        this.estadoReserva = estadoReserva;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;

        this.listaHabitaciones = new Habitacion[100];
    }



    public String agregarHabitacion(Habitacion habitacion) {

        if (habitacion == null) {
            return "No se puede agregar una habitación nula.";
        }



        for (Habitacion hab : listaHabitaciones) {

            if (hab != null
                    && hab.getNumeroHabitacion()
                    .equals(habitacion.getNumeroHabitacion())) {

                return "La habitación ya está agregada a esta reserva.";
            }
        }



        for (int i = 0; i < listaHabitaciones.length; i++) {

            if (listaHabitaciones[i] == null) {

                listaHabitaciones[i] = habitacion;



                if (estadoReserva.equalsIgnoreCase("Confirmada")) {

                    habitacion.setEstado("Reservada");
                }


                return "Habitación "
                        + habitacion.getNumeroHabitacion()
                        + " agregada con éxito a la reserva.";
            }
        }


        return "No se pueden agregar más habitaciones a esta reserva.";
    }



    public void calcularValorTotal() {

        int acumulado = 0;

        for (Habitacion habitacion : listaHabitaciones) {

            if (habitacion != null) {

                acumulado += habitacion.getPrecio();
            }
        }

        this.valorTotal = acumulado * this.numeroNoches;
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


    public byte getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(byte cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }


    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {

        this.estadoReserva = estadoReserva;


        if (estadoReserva.equalsIgnoreCase("Confirmada")) {

            for (Habitacion habitacion : listaHabitaciones) {

                if (habitacion != null) {

                    habitacion.setEstado("Reservada");
                }
            }
        }
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

        return "Reserva{"
                + "codigo=" + codigo
                + ", fechaReserva='" + fechaReserva + '\''
                + ", numeroNoches=" + numeroNoches
                + ", cantidadHuespedes=" + cantidadHuespedes
                + ", estadoReserva='" + estadoReserva + '\''
                + ", metodoPago='" + metodoPago + '\''
                + ", valorTotal=" + valorTotal
                + ", ownedByHuesped=" + ownedByHuesped
                + ", listaHabitaciones="
                + Arrays.toString(listaHabitaciones)
                + '}';
    }
}
