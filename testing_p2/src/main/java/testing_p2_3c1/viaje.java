import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Viaje {

    private List<Billete> billetes;
    private tipoBillete tipo;
    private String destino;
    private String paisDestino;
    private String origen;
    private boolean conNinos;
    private String motivo;
    private LocalDate fecha;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public viaje(String tipo, String destino, String paisDestino, String origen, int billetes, boolean conNinos,
            String motivo) {

        this.destino = destino;
        this.origen = origen;
        this.conNinos = conNinos;
        this.paisDestino = paisDestino;
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

    public List<Billete> getBilletes() {
        return billetes;
    }

    public void setBilletes(List<Billete> billetes) {
        this.billetes = billetes;
    }

    public tipoBillete getTipo() {
        return tipo;
    }

    public void setTipo(tipoBillete tipo) {
        this.tipo = tipo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public boolean isConNinos() {
        return conNinos;
    }

    public void setConNinos(boolean conNinos) {
        this.conNinos = conNinos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    publicpublic String getPaisDestino() {
    return paisDestino;
}

public void setPaisDestino(String paisDestino) {
    this.paisDestino = paisDestino;
}

 static DateTimeFormatter getFormatoFecha() {
        return FORMATO_FECHA;
    }

    
    private void crear_lista(int billetes) {
        for (int i = 0; i < billetes; i++) {
            this.billetes.add(new Billete());
        }   
    }

    public LocalDate parse_fecha(String fecha){
        try {
            return LocalDate.parse(fecha, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida: " + textoFecha);
                return null; // o lanzar tu propia excepción, según te convenga
        }
    }

    public boolean viajaUnaVezAlMesDuranteCurso() {
        List<Viaje> viajes = this.viajes;
        if (viajes == null || viajes.isEmpty()) return false;
    
        Set<YearMonth> mesesConViaje = new HashSet<>();
    
        for (Viaje v : viajes) {
            if (v.getTipo() != tipoBillete.TURISTA) continue;
            if (!esTrayectoDomicilioUniversidad(v)) continue;
    
            LocalDate fecha = v.getFecha();
            int mes = fecha.getMonthValue();
    
            if (esMesCurso(mes)) {
                mesesConViaje.add(YearMonth.from(fecha));
            }
        }
        return mesesConViaje.size() >= 9;
    }

    private boolean esTrayectoDomicilioUniversidad(Viaje v) {
    String dom = this.getDomicilio();
    String uni = this.getUniversidad();

    return (v.getOrigen().equals(dom) && v.getDestino().equals(uni))
        || (v.getOrigen().equals(uni) && v.getDestino().equals(dom));
    }

    private static boolean esMesCurso(int mes) {
        // Ejemplo: septiembre–junio
        return mes >= 9 || mes <= 6;
    }

}
