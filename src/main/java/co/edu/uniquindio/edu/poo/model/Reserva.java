        package co.edu.uniquindio.edu.poo.model;

        import java.util.ArrayList;


        public class Reserva {


            private String codigoReserva;
            private String fechaReserva;
            private byte numeroNoches;
            private byte cantidadHuespedes;
            private String estadoReserva;
            private String metodoPago;
            private double valorTotal;


            private Huesped huesped;
            private ArrayList<Habitacion> habitacionesReservadas;


            public Reserva(String codigoReserva, String fechaReserva, byte numeroNoches,
                           byte cantidadHuespedes, String metodoPago, Huesped huesped){
                this.codigoReserva = codigoReserva;
                this.fechaReserva = fechaReserva;
                this.numeroNoches = numeroNoches;
                this.cantidadHuespedes = cantidadHuespedes;
                this.metodoPago = metodoPago;
                this.huesped = huesped;
                this.estadoReserva = "Pendiente";
                this.valorTotal = 0;
                habitacionesReservadas = new ArrayList<>();
            }



            public void setCodigoReserva(String codigoReserva){
                this.codigoReserva = codigoReserva;
            }
            public String getCodigoReserva(){
                return codigoReserva;
            }
            public void setFechaReserva(String fechaReserva){
                this.fechaReserva = fechaReserva;
            }
            public String getFechaReserva(){
                return fechaReserva;
            }
            public void setNumeroNoches(byte numeroNoches){
                this.numeroNoches = numeroNoches;
            }
            public byte getNumeroNoches(){
                return numeroNoches;
            }
            public void setCantidadHuespedes(byte cantidadHuespedes){
                this.cantidadHuespedes = cantidadHuespedes;
            }
            public byte getCantidadHuespedes(){
                return cantidadHuespedes;
            }
            public void setEstadoReserva(String estadoReserva){
                this.estadoReserva = estadoReserva;
            }
            public String getEstadoReserva(){
                return estadoReserva;
            }
            public void setMetodoPago(String metodoPago){
                this.metodoPago = metodoPago;
            }
            public String getMetodoPago(){
                return metodoPago;
            }
            public void setValorTotal(double valorTotal){
                this.valorTotal = valorTotal;
            }
            public double getValorTotal(){
                return valorTotal;
            }
            public void setHuesped(Huesped huesped){
                this.huesped = huesped;
            }
            public Huesped getHuesped(){
                return huesped;
            }
            public void setHabitacionesReservadas(ArrayList<Habitacion> habitacionesReservadas){
                this.habitacionesReservadas = habitacionesReservadas;
            }
            public ArrayList<Habitacion> getHabitacionesReservadas(){
                return habitacionesReservadas;
            }

            @Override
            public String toString() {
                return "Reserva{" +
                        "codigoReserva='" + codigoReserva + '\'' +
                        ", fechaReserva='" + fechaReserva + '\'' +
                        ", numeroNoches=" + numeroNoches +
                        ", cantidadHuespedes=" + cantidadHuespedes +
                        ", estadoReserva='" + estadoReserva + '\'' +
                        ", metodoPago='" + metodoPago + '\'' +
                        ", valorTotal=" + valorTotal +
                        ", huesped=" + (huesped != null ? huesped.getNombre() : "null") +
                        '}';
            }


            public String agregarHabitacion(Habitacion habitacion){
                if (!habitacion.estaDisponible()) {
                    return "Error, la habitacion " + habitacion.getNumeroHabitacion() + " no esta disponible";
                }
                habitacionesReservadas.add(habitacion);
                calcularValorTotal();
                return "Habitacion agregada a la reserva con exito";
            }


            public double calcularValorTotal(){
                double total = 0;
                for (Habitacion h : habitacionesReservadas) {
                    total += h.getPrecio();
                }
                total = total * numeroNoches;
                this.valorTotal = total;
                return valorTotal;
            }


            public String confirmarReserva(){
                if (habitacionesReservadas.isEmpty()) {
                    return "Error, la reserva no tiene habitaciones asociadas";
                }
                estadoReserva = "Confirmada";
                for (Habitacion h : habitacionesReservadas) {
                    h.actualizarEstado("Reservada");
                }
                return "Reserva confirmada con exito";
            }


            public boolean esCapicua(){
                String invertido = new StringBuilder(codigoReserva).reverse().toString();
                return codigoReserva.equals(invertido);
            }
        }