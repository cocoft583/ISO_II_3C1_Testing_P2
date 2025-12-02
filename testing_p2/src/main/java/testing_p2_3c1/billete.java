import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class billete {

    private tipoBillete tipo;
    private float precio;
    private String ciudad_origen;
    private String pais_origen;
    private String ciudad_destino;
    private String pais_destino;

    private LocalDate fecha;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public billete(String tipo, float precio, String c_origen, String p_origen, String c_destino, String p_destino, String fecha){
        this.tipo = tipo;

        switch (tipo.toLowerCase()) {
            case "turista":
                this.tipo = tipoBillete.TURISTA;
                break;
        
            case "business":
                this.tipo = tipoBillete.BUSINESS;

            case "primera": 
                this.tipo = tipoBillete.PRIMERA;

            default:
                throw new IllegalArgumentException("Tipo de billete desconocido");
        }

        this.fecha = parse_fecha(fecha)

        this.precio = precio;
        this.ciudad_origen = c_origen;
        this.ciudad_destino = c_destino;
        this.pais_origen = p_origen;
        this.pais_destino = p_destino;
    }

    public LocalDate parse_fecha(String fecha){
        try {
            return LocalDate.parse(fecha, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida: " + textoFecha);
                return null; // o lanzar tu propia excepción, según te convenga
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = parse_fecha(fecha);
    }

    public tipoBillete getTipo() {
        return tipo;
    }

    public void setTipo(tipoBillete tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

    public String getCiudad_destino() {
        return ciudad_destino;
    }

    public void setCiudad_destino(String ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }

    public String getPais_destino() {
        return pais_destino;
    }

    public void setPais_destino(String pais_destino) {
        this.pais_destino = pais_destino;
    }

    public String toString() {
        return "Billete [tipo=" + tipo + ", precio=" + precio + ", ciudad_origen=" + ciudad_origen + ", pais_origen="
                + pais_origen + ", ciudad_destino=" + ciudad_destino + ", pais_destino=" + pais_destino + "]";
    };
    
}
