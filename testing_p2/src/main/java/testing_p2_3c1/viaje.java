package testing_p2_3c1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;

public class Viaje {

    private List<Billete> billetes;
    private tipoBillete tipo;
    private String destino;
    private String paisDestino;
    private String origen;
    private boolean conNinos;
    private motivoViaje motivo;
    private LocalDate fecha;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Viaje() {

    }

    public Viaje(String tipo, String destino, String paisDestino, String origen, int billetes, boolean conNinos,
            String motivo) {

        this.destino = destino;
        this.origen = origen;
        this.conNinos = conNinos;
        this.paisDestino = paisDestino;
        crear_lista(billetes); //REVISAR ESTO: Se crea dentro de viajes la lista de billetes

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

    public motivoViaje getMotivo() {
        return motivo;
    }

    public void setMotivo(motivoViaje motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getPaisDestino() {
    return paisDestino;
}

public void setPaisDestino(String paisDestino) {
    this.paisDestino = paisDestino;
}

 static DateTimeFormatter getFormatoFecha() {
        return FORMATO_FECHA;
    }

    
    private void crear_lista(int billetes) {
        this.billetes = new ArrayList<>();
        for (int i = 0; i < billetes; i++) {
            this.billetes.add(new Billete());
        }   
    }

    public LocalDate parse_fecha(String fecha){
        try {
            return LocalDate.parse(fecha, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida: " + fecha);
                return null; // o lanzar tu propia excepción, según te convenga
        }
    }


}
