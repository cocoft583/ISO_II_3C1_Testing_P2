import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Viaje {

    private List<Billete> billetes;
    private tipoBillete tipo;
    private String destino;
    private String origen;
    private boolean conNinos;
    private String motivo;
    private LocalDate fecha;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public viaje(String tipo, String destino, String origen, int billetes, boolean conNinos,
            String motivo) {

        this.destino = destino;
        this.origen = origen;
        this.conNinos = conNinos;
        this.billetes = crear_lista(billetes); //REVISAR ESTO: Se crea dentro de viajes la lista de billetes

        switch (tipo.toLowerCase()) {
            case "turista":
                this.tipo = tipoBillete.TURISTA;
                break;
            case "business":
                this.tipo = tipoBillete.BUSINESS;
                break;
            case "primera":
                this.tipo = tipoBillete.PRIMERA;
                break;
            default:
                throw new IllegalArgumentException("Tipo de billete desconocido");
        }
        
        switch (motivo.toLowerCase()) {
            case "placer":
                this.motivo = motivoViaje.PLACER;
                break;
            case "estudios":
                this.motivo = motivoViaje.ESTUDIOS;
                break;
            case "otro":
                this.motivo = motivoViaje.OTRO;
                break;

            default:
                throw new IllegalArgumentException("Motivo de viaje desconocido");
        }
    }

    private List<Billete> crear_lista(int billetes) {
        for (int i = 0; i < billetes; i++) {
            this.billetes.add(new Billete());
        }   
        return null;
    }

    public LocalDate parse_fecha(String fecha){
        try {
            return LocalDate.parse(fecha, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida: " + textoFecha);
                return null; // o lanzar tu propia excepción, según te convenga
        }
    }
}
