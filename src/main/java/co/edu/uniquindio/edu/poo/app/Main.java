package co.edu.uniquindio.edu.poo.app;

import co.edu.uniquindio.edu.poo.model.Habitacion;
import co.edu.uniquindio.edu.poo.model.Hotel;
import co.edu.uniquindio.edu.poo.model.Huesped;
import co.edu.uniquindio.edu.poo.model.Reserva;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    private static final double RESERVAESPECIAL = 400000;

    private static final String[] DIAS_VALIDOS = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

    public static void main(String[] args) {


        Hotel hotel = new Hotel("StayPlus", "900123456-1", "Calle 10 # 5-20 Armenia", "6067400000", 6, 20);

        cargarDatosPrueba(hotel);

        String menu = "Bienvenido al sistema del hotel StayPlus\n\n" +
                "1. Registrar huésped\n" +
                "2. Realizar reserva\n" +
                "3. Agregar habitación a una reserva\n" +
                "4. Consultar huésped por teléfono\n" +
                "5. Identificar reservas especiales (capicúa)\n" +
                "6. Calcular ingresos por fecha\n" +
                "0. Salir\n\n" +
                "Ingrese el numero de la opción:";

        int opcion;
        do {
            String opcionTexto = JOptionPane.showInputDialog(null, menu, "Menu StayPlus", JOptionPane.QUESTION_MESSAGE);

            if (opcionTexto == null) {
                opcion = 0;
                break;
            }

            try {
                opcion = Integer.parseInt(opcionTexto.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, debe ingresar un numero de opción valido");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarHuesped(hotel);
                    break;
                case 2:
                    realizarReserva(hotel);
                    break;
                case 3:
                    agregarHabitacionAReserva(hotel);
                    break;
                case 4:
                    consultarHuesped(hotel);
                    break;
                case 5:
                    identificarReservasEspeciales(hotel);
                    break;
                case 6:
                    calcularIngresos(hotel);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema del hotel StayPlus");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error, la opción ingresada no existe");
            }

        } while (opcion != 0);
    }


    private static void registrarHuesped(Hotel hotel) {
        String documento = JOptionPane.showInputDialog("Documento de identidad:");
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        String telefono = JOptionPane.showInputDialog("Numero de teléfono:");
        String ciudad = JOptionPane.showInputDialog("Ciudad de procedencia:");
        byte edad;
        try {
            edad = Byte.parseByte(JOptionPane.showInputDialog("Edad:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, la edad debe ser un numero");
            return;
        }
        String mensaje = hotel.registrarHuesped(documento, nombre, edad, telefono, ciudad);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void realizarReserva(Hotel hotel) {
        String documento = JOptionPane.showInputDialog("Documento del huésped que realiza la reserva:");
        Huesped huesped = hotel.buscarHuespedPorDocumento(documento);
        if (huesped == null) {
            JOptionPane.showMessageDialog(null, "Error, no existe un huésped con ese documento");
            return;
        }

        String fechaReserva = seleccionarDia("Seleccione el dia de la reserva (el hotel opera de lunes a viernes):");
        if (fechaReserva == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada, no se selecciono un dia");
            return;
        }

        JOptionPane.showMessageDialog(null, "Disponibilidad de habitaciones para el " + fechaReserva + ":\n\n"
                + listarDisponibilidadPorDia(hotel, fechaReserva));

        String codigoReserva = JOptionPane.showInputDialog("Código de la reserva:");
        String metodoPago = JOptionPane.showInputDialog("Método de pago (Efectivo, Tarjeta o Transferencia):");
        byte numeroNoches;
        byte cantidadHuespedes;
        try {
            numeroNoches = Byte.parseByte(JOptionPane.showInputDialog("Numero de noches:"));
            cantidadHuespedes = Byte.parseByte(JOptionPane.showInputDialog("Cantidad de huéspedes:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, los datos numéricos ingresados no son validos");
            return;
        }

        Reserva reservaNueva = huesped.realizarReserva(codigoReserva, fechaReserva, numeroNoches, cantidadHuespedes, metodoPago);
        String mensaje = hotel.registrarReserva(reservaNueva);
        JOptionPane.showMessageDialog(null, mensaje + "\nRecuerde agregarle habitaciones con la opción 3.");
    }


    private static void agregarHabitacionAReserva(Hotel hotel) {
        String codigoReserva = JOptionPane.showInputDialog("Código de la reserva:");
        Reserva reserva = hotel.buscarReserva(codigoReserva);
        if (reserva == null) {
            JOptionPane.showMessageDialog(null, "Error, no existe una reserva con ese código");
            return;
        }

        String numeroHabitacion = JOptionPane.showInputDialog("Numero de la habitación a agregar:");
        Habitacion habitacion = hotel.buscarHabitacion(numeroHabitacion);
        if (habitacion == null) {
            JOptionPane.showMessageDialog(null, "Error, no existe una habitación con ese numero");
            return;
        }

        String mensaje = reserva.agregarHabitacion(habitacion);


        if (reserva.getValorTotal() > RESERVAESPECIAL) {
            String nuevoCodigo = generarCodigoCapicua();
            reserva.setCodigoReserva(nuevoCodigo);
            mensaje += "\nLa reserva supera los $" + (long) RESERVAESPECIAL +
                    ", se le asigno el código especial (capicúa): " + nuevoCodigo;
        } else {
            String nuevoCodigo = generarCodigoNormal();
            reserva.setCodigoReserva(nuevoCodigo);
            mensaje += "\nSe le asigno el código de reserva: " + nuevoCodigo;
        }

        JOptionPane.showMessageDialog(null, mensaje + "\nValor total actual de la reserva: $" + reserva.getValorTotal());
    }


    private static void consultarHuesped(Hotel hotel) {
        String telefono = JOptionPane.showInputDialog("Teléfono del huésped a consultar:");
        Huesped huesped = hotel.consultarHuesped(telefono);

        if (huesped == null) {
            JOptionPane.showMessageDialog(null, "Error, no existe un huésped con ese numero de teléfono");
            return;
        }

        StringBuilder reservasTexto = new StringBuilder();
        ArrayList<Reserva> misReservas = huesped.getMisReservas();
        if (misReservas.isEmpty()) {
            reservasTexto.append("(sin reservas realizadas)");
        } else {
            for (Reserva r : misReservas) {
                reservasTexto.append("- ").append(r.getCodigoReserva())
                        .append(" (").append(r.getEstadoReserva()).append(")\n");
            }
        }

        String resultado = "Nombre: " + huesped.getNombre() +
                "\nDocumento: " + huesped.getDocumento() +
                "\nCiudad: " + huesped.getCiudad() +
                "\nReservas realizadas:\n" + reservasTexto;
        JOptionPane.showMessageDialog(null, resultado);
    }


    private static void identificarReservasEspeciales(Hotel hotel) {
        ArrayList<Reserva> especiales = hotel.identificarReservasEspeciales();

        if (especiales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron reservas especiales (capicúa)");
            return;
        }

        StringBuilder resultado = new StringBuilder("Reservas especiales encontradas:\n");
        for (Reserva r : especiales) {
            resultado.append("- ").append(r.getCodigoReserva()).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }


    private static void calcularIngresos(Hotel hotel) {
        String fecha = seleccionarDia("Seleccione el dia a consultar:");
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada, no se selecciono un dia");
            return;
        }
        double ingresos = hotel.calcularIngresos(fecha);
        JOptionPane.showMessageDialog(null, "Ingresos generados el " + fecha + ": $" + ingresos);
    }


    private static String seleccionarDia(String mensaje) {
        return (String) JOptionPane.showInputDialog(null, mensaje, "Dia de la semana",
                JOptionPane.QUESTION_MESSAGE, null, DIAS_VALIDOS, DIAS_VALIDOS[0]);
    }


    private static boolean estaOcupadaEseDia(Hotel hotel, Habitacion habitacion, String dia) {
        Reserva[] reservas = hotel.getReservas();
        int cantidad = hotel.getCantidadReservas();
        for (int i = 0; i < cantidad; i++) {
            Reserva r = reservas[i];
            if (r.getFechaReserva().equalsIgnoreCase(dia) && r.getHabitacionesReservadas().contains(habitacion)) {
                return true;
            }
        }
        return false;
    }


    private static String listarDisponibilidadPorDia(Hotel hotel, String dia) {
        String resultado = "";
        Habitacion[] habitaciones = hotel.getHabitaciones();
        int cantidad = hotel.getCantidadHabitaciones();

        for (int i = 0; i < cantidad; i++) {
            Habitacion h = habitaciones[i];
            String estadoEseDia;
            if (h.getEstado().equalsIgnoreCase("Mantenimiento")) {
                estadoEseDia = "Mantenimiento";
            } else if (estaOcupadaEseDia(hotel, h, dia)) {
                estadoEseDia = "Ocupada";
            } else {
                estadoEseDia = "Disponible";
            }

            resultado = resultado
                    + "- " + h.getNumeroHabitacion()
                    + " (piso " + h.getPiso()
                    + ", " + h.getTipoHabitacion()
                    + ", $" + (long) h.getPrecio()
                    + "): " + estadoEseDia
                    + "\n";
        }

        return resultado;
    }


    private static String generarCodigoCapicua() {
        int mitad = (int) (Math.random() * 90) + 10;
        String mitadTexto = String.valueOf(mitad);
        String mitadInvertida = new StringBuilder(mitadTexto).reverse().toString();
        return mitadTexto + mitadInvertida;
    }


    private static String generarCodigoNormal() {
        String codigo;
        do {
            int numero = (int) (Math.random() * 9000) + 1000;
            codigo = String.valueOf(numero);
        } while (codigo.equals(new StringBuilder(codigo).reverse().toString()));
        return codigo;
    }


    private static void cargarDatosPrueba(Hotel hotel) {
        hotel.registrarHuesped("1001", "Laura Gomez", (byte) 28, "3001111111", "Armenia");
        hotel.registrarHuesped("1002", "Carlos Perez", (byte) 35, "3002222222", "Bogota");


        hotel.registrarHabitacion("101", "Individual", (byte) 1, (byte) 1, 100000);
        hotel.registrarHabitacion("102", "Doble", (byte) 1, (byte) 2, 200000);
        hotel.registrarHabitacion("103", "Suite", (byte) 1, (byte) 4, 400000);


        hotel.registrarHabitacion("201", "Individual", (byte) 2, (byte) 1, 100000);
        hotel.registrarHabitacion("202", "Doble", (byte) 2, (byte) 2, 200000);
        hotel.registrarHabitacion("203", "Suite", (byte) 2, (byte) 4, 400000);


        Huesped laura = hotel.buscarHuespedPorDocumento("1001");
        Reserva reservaLaura = laura.realizarReserva("9001", "Martes", (byte) 1, (byte) 2, "Tarjeta");
        reservaLaura.agregarHabitacion(hotel.buscarHabitacion("102"));
        reservaLaura.confirmarReserva();
        hotel.registrarReserva(reservaLaura);
        hotel.buscarHabitacion("102").actualizarEstado("Ocupada");


        Huesped carlos = hotel.buscarHuespedPorDocumento("1002");
        Reserva reservaCarlos = carlos.realizarReserva("9002", "Jueves", (byte) 1, (byte) 4, "Transferencia");
        reservaCarlos.agregarHabitacion(hotel.buscarHabitacion("203"));
        reservaCarlos.confirmarReserva();
        hotel.registrarReserva(reservaCarlos);
        hotel.buscarHabitacion("203").actualizarEstado("Ocupada");


        hotel.buscarHabitacion("201").actualizarEstado("Mantenimiento");


    }
}
