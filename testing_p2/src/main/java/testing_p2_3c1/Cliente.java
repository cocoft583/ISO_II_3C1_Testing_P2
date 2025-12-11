package testing_p2_3c1;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private int edad;
    private int frecuenciaViajes;
    private tipoBillete preferenciaClase; // Será clase turista o clase business;
    private String destinoPreferido;
    private int disponibilidadFinanciera; // Lo consideramos como un atributo en el que se define lo máximo que puede
                                          // gastar el cliente.
    private boolean trabaja; // True --> Sí. False --> No.
    private boolean independizado; // True --> Sí. False --> No.
    private int ingresos;
    private String domicilio; // El formato será algo como Calle, número, Ciudad , País. --> Separado por
                              // comas. Y así podremos aplicar lo de split usando las "," (comas) como
                              // separadores.
    private String universidad; // El formato será como el de domicilio, indicando el nombre de la universidad,
                                // la ciudad y el país.
    
    // Contiene la lista de viajes realizados por el cliente.
    List<Viaje> viajes = new ArrayList<>();
 

    //Podremos tener una lista de billetes, y según queramos filtrar realizaremos una búsqueda. Habrá que pedir el número de hijos y en función de eso iremos por un caminmo u otro.

    public Cliente(int edad, String preferenciaClase, String destinoPreferido,
            int disponibilidadFinanciera, boolean ninos, boolean trabaja, boolean independizado, int ingresos,
            String domicilio, String universidad) {
        this.edad = edad;
        
        switch (preferenciaClase.toLowerCase()) {
            case "turista":
                this.preferenciaClase = tipoBillete.TURISTA;
                break;
            case "business":
                this.preferenciaClase = tipoBillete.BUSINESS;
                break;
            case "primera":
                this.preferenciaClase = tipoBillete.PRIMERA;
                break;
            default:
                throw new IllegalArgumentException("Tipo de billete desconocido");
        }
        this.destinoPreferido = destinoPreferido;
        this.disponibilidadFinanciera = disponibilidadFinanciera;
        this.trabaja = trabaja;
        this.independizado = independizado;
        this.ingresos = ingresos;
        this.domicilio = domicilio;
        this.universidad = universidad;
        this.frecuenciaViajes = viajes.size();
    }

    public boolean viajaUnaVezAlMesDuranteCurso() {
            List<Viaje> viajes = this.viajes;

            if (viajes == null || viajes.isEmpty()) 
                 return false;
        
            Set<YearMonth> mesesConViaje = new HashSet<>();
        
            for (Viaje v : viajes) {
                if (v.getTipo() != tipoBillete.TURISTA)
                     continue;

                if (!esTrayectoDomicilioUniversidad(v))
                     continue;
        
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
        

    //Métodos getter, setter y sobreescritura del toString().

    public int getEdad(){
        return edad;
    }

    public int getFrecuenciaViajes(){
        
        return frecuenciaViajes;
    }

    public tipoBillete getPreferenciaClase(){
        return preferenciaClase;
    }

    public String getDestinoPreferido(){
        return destinoPreferido;
    }

    public int getDisponibilidadFinanciera(){
        return disponibilidadFinanciera;
    }

    public boolean getTrabaja(){
        return trabaja;
    }

    public boolean getIndependizado(){
        return independizado;
    }

    public int getIngresos(){
        return ingresos;
    }

    public String getDomicilio(){
        return domicilio;
    }

    public String getUniversidad(){
        return universidad;
    }

    public List<Viaje> getViajes(){
        return viajes;
    }

    public void setEdad(int nuevaEdad){
        edad = nuevaEdad;
    }

    public void setFrecuenciaViajes(int nuevaFrecuenciaViajes){
        frecuenciaViajes = nuevaFrecuenciaViajes;
    }

    public void setPreferenciaClase(tipoBillete nuevaPreferenciaClase){
        preferenciaClase = nuevaPreferenciaClase;
    }

    public void setDestinoPreferido(String nuevoDestinoPreferido){
        destinoPreferido = nuevoDestinoPreferido;
    }

    public void setDisponibilidadFinanciera(int nuevaDisponibilidadFinanciera){
        disponibilidadFinanciera = nuevaDisponibilidadFinanciera;
    }

    public void setTrabaja(boolean actualizarTrabaja){
        trabaja = actualizarTrabaja;
    }

    public void setIndependizado(boolean actualizarIndependizado){
        independizado = actualizarIndependizado;
    }

    public void setIngresos(int nuevoIngreso){
        ingresos = nuevoIngreso;
    }

    public void setDomicilio(String nuevoDomicilio){
        domicilio = nuevoDomicilio;
    }

    public void setUniversidad(String nuevaUniversidad){
        universidad = nuevaUniversidad;
    }

    @Override
    public String toString(){
        return "Cliente [edad=" + edad
            + " ,frecuenciaViajes= " + frecuenciaViajes
            + " ,preferenciaClase= " + preferenciaClase
            + " ,destinoPreferido= " + destinoPreferido
            + " ,disponibilidadFinanciera= " + disponibilidadFinanciera
            + " ,trabaja= " + trabaja
            + " ,independizado= " + independizado
            + " ,ingresos= " + ingresos
            + " ,domicilio= " + domicilio
            + " ,universidad= " + universidad
            + "]";
    }
}
