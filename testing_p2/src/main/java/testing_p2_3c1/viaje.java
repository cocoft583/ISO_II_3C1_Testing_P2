import java.util.List;

public class viaje {

    private List<billete> billetes;
    private tipoBillete tipo;
    private String destino;
    private String origen;
    private boolean conNinos;
    private String motivo;

    public viaje(String tipo, String destino, String origen, int billetes, boolean conNinos,
            String motivo) {

        this.destino = destino;
        this.origen = origen;
        this.conNinos = conNinos;
        this.billetes = billetes; //REVISAR ESTO: Se crea dentro de viajes la lista de billetes

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
}
