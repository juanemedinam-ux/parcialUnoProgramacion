package co.edu.uniquindio.edu.poo.model;
import java.util.ArrayList;

public class Hotel {

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    private ArrayList<Huesped> listaHuespedes;
    private Habitacion[] habitaciones;
    private Reserva[] reservas;
    private int cantidadHabitaciones;
    private int cantidadReservas;
    private char[][] matrizOcupacion;

    private static final String[] DIAS = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};


    public Hotel(String nombre, String nit, String direccion, String telefono,
                 int capacidadHabitaciones, int capacidadReservas){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        listaHuespedes = new ArrayList<>();
        habitaciones = new Habitacion[capacidadHabitaciones];
        reservas = new Reserva[capacidadReservas];
        cantidadHabitaciones = 0;
        cantidadReservas = 0;
        matrizOcupacion = new char[capacidadHabitaciones][7];
    }



    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNit(String nit){
        this.nit = nit;
    }
    public String getNit(){
        return nit;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setListaHuespedes(ArrayList<Huesped> listaHuespedes){
        this.listaHuespedes = listaHuespedes;
    }
    public ArrayList<Huesped> getListaHuespedes(){
        return listaHuespedes;
    }
    public void setHabitaciones(Habitacion[] habitaciones){
        this.habitaciones = habitaciones;
    }
    public Habitacion[] getHabitaciones(){
        return habitaciones;
    }
    public void setReservas(Reserva[] reservas){
        this.reservas = reservas;
    }
    public Reserva[] getReservas(){
        return reservas;
    }
    public int getCantidadHabitaciones(){
        return cantidadHabitaciones;
    }
    public int getCantidadReservas(){
        return cantidadReservas;
    }
    public void setMatrizOcupacion(char[][] matrizOcupacion){
        this.matrizOcupacion = matrizOcupacion;
    }
    public char[][] getMatrizOcupacion(){
        return matrizOcupacion;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cantidadHuespedes=" + listaHuespedes.size() +
                ", cantidadHabitaciones=" + cantidadHabitaciones +
                ", cantidadReservas=" + cantidadReservas +
                '}';
    }


    public String registrarHuesped(String documento, String nombre, byte edad, String telefono, String ciudad){
        String mensaje = "";
        Huesped buscado = buscarHuespedPorDocumento(documento);
        if (buscado != null) {
            return "Error, el huesped que usted desea registrar ya se encuentra registrado";
        } else {
            Huesped huespedNuevo = new Huesped(documento, nombre, edad, telefono, ciudad);
            listaHuespedes.add(huespedNuevo);
            mensaje = "Huesped registrado con exito";
        }
        return mensaje;
    }

    public Huesped buscarHuespedPorDocumento(String documento){
        for (Huesped aux : listaHuespedes) {
            if (aux.getDocumento().equals(documento)) {
                return aux;
            }
        }
        return null;
    }


    public Huesped consultarHuesped(String telefono){
        for (Huesped aux : listaHuespedes) {
            if (aux.getTelefono().equals(telefono)) {
                return aux;
            }
        }
        return null;
    }


    public String registrarHabitacion(String numero, String tipo, byte piso, byte capacidad, double precio){
        if (buscarHabitacion(numero) != null) {
            return "Error, la habitacion que usted desea registrar ya se encuentra registrada";
        }
        if (cantidadHabitaciones >= habitaciones.length) {
            return "Error, el hotel ya alcanzo su capacidad maxima de habitaciones";
        }
        habitaciones[cantidadHabitaciones] = new Habitacion(numero, tipo, piso, capacidad, precio);
        cantidadHabitaciones++;
        return "Habitacion registrada con exito";
    }

    public Habitacion buscarHabitacion(String numero){
        for (int i = 0; i < cantidadHabitaciones; i++) {
            if (habitaciones[i].getNumeroHabitacion().equals(numero)) {
                return habitaciones[i];
            }
        }
        return null;
    }


    public String consultarDisponibilidad(){
        int disponibles = 0;
        int ocupadas = 0;
        int mantenimiento = 0;
        Habitacion masCara = null;
        Habitacion masBarata = null;

        for (int i = 0; i < cantidadHabitaciones; i++) {
            Habitacion actual = habitaciones[i];
            if (actual.getEstado().equalsIgnoreCase("Disponible")) {
                disponibles++;
            } else if (actual.getEstado().equalsIgnoreCase("Ocupada")) {
                ocupadas++;
            } else if (actual.getEstado().equalsIgnoreCase("Mantenimiento")) {
                mantenimiento++;
            }

            if (masCara == null || actual.getPrecio() > masCara.getPrecio()) {
                masCara = actual;
            }
            if (masBarata == null || actual.getPrecio() < masBarata.getPrecio()) {
                masBarata = actual;
            }
        }

        return "Habitaciones disponibles: " + disponibles +
                "\nHabitaciones ocupadas: " + ocupadas +
                "\nHabitaciones en mantenimiento: " + mantenimiento +
                "\nHabitacion con mayor precio: " + (masCara != null ? masCara.getNumeroHabitacion() + " ($" + masCara.getPrecio() + ")" : "N/A") +
                "\nHabitacion con menor precio: " + (masBarata != null ? masBarata.getNumeroHabitacion() + " ($" + masBarata.getPrecio() + ")" : "N/A");
    }


    public String registrarReserva(Reserva reserva){
        if (cantidadReservas >= reservas.length) {
            return "Error, el hotel ya alcanzo su capacidad maxima de reservas";
        }
        reservas[cantidadReservas] = reserva;
        cantidadReservas++;
        return "Reserva registrada con exito";
    }

    public Reserva buscarReserva(String codigoReserva){
        for (int i = 0; i < cantidadReservas; i++) {
            if (reservas[i].getCodigoReserva().equals(codigoReserva)) {
                return reservas[i];
            }
        }
        return null;
    }


    public ArrayList<Reserva> identificarReservasEspeciales(){
        ArrayList<Reserva> especiales = new ArrayList<>();
        for (int i = 0; i < cantidadReservas; i++) {
            if (reservas[i].esCapicua()) {
                especiales.add(reservas[i]);
            }
        }
        return especiales;
    }


    public double calcularIngresos(String fecha){
        double ingresoTotal = 0;
        for (int i = 0; i < cantidadReservas; i++) {
            if (reservas[i].getFechaReserva().equals(fecha)) {
                ingresoTotal += reservas[i].getValorTotal();
            }
        }
        return ingresoTotal;
    }



    public String marcarOcupacion(int posicionHabitacion, int dia, char estado){
        if (posicionHabitacion < 0 || posicionHabitacion >= cantidadHabitaciones || dia < 0 || dia > 6) {
            return "Error, la posicion ingresada esta fuera de rango";
        }
        matrizOcupacion[posicionHabitacion][dia] = estado;
        return "Ocupacion actualizada con exito";
    }


    public String calcularMatrizOcupacion(){
        int[] ocupadasPorDia = new int[7];
        int totalOcupadas = 0;

        for (int dia = 0; dia < 7; dia++) {
            int contador = 0;
            for (int fila = 0; fila < cantidadHabitaciones; fila++) {
                if (matrizOcupacion[fila][dia] == 'O') {
                    contador++;
                }
            }
            ocupadasPorDia[dia] = contador;
            totalOcupadas += contador;
        }

        int diaMayor = 0;
        int diaMenor = 0;
        for (int dia = 1; dia < 7; dia++) {
            if (ocupadasPorDia[dia] > ocupadasPorDia[diaMayor]) {
                diaMayor = dia;
            }
            if (ocupadasPorDia[dia] < ocupadasPorDia[diaMenor]) {
                diaMenor = dia;
            }
        }

        return "Dia con mayor ocupacion: " + DIAS[diaMayor] + " (" + ocupadasPorDia[diaMayor] + " habitaciones)" +
                "\nDia con menor ocupacion: " + DIAS[diaMenor] + " (" + ocupadasPorDia[diaMenor] + " habitaciones)" +
                "\nTotal de habitaciones ocupadas durante la semana: " + totalOcupadas;
    }
}