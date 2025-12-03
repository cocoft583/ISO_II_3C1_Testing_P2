package ISO_II_3C1_Testing_P2.testing_p2.src.main.java.testing_p2_3c1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int edad;
    private int frecuenciaViajes;
    private tipoViaje preferenciaClase; // Será clase turista o clase business;
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
    List<viaje> viajes = new ArrayList<>();
 

    //Podremos tener una lista de billetes, y según queramos filtrar realizaremos una búsqueda. Habrá que pedir el número de hijos y en función de eso iremos por un caminmo u otro.

    public Cliente(int edad, int frecuenciaViajes, String preferenciaClase, String destinoPreferido,
            int disponibilidadFinanciera, boolean ninos, boolean trabaja, boolean independizado, int ingresos,
            String domicilio, String universidad) {
        this.edad = edad;
        this.frecuenciaViajes = frecuenciaViajes;
        this.preferenciaClase = preferenciaClase;
        
        switch (preferenciaClase.toLowerCase()) {
            case "turista":
                this.preferenciaClase = tipoViaje.TURISTA;
                break;
            case "business":
                this.preferenciaClase = tipoViaje.BUSINESS;
            case "primera":
                this.preferenciaClase = tipoViaje.PRIMERA;
                break;
            default:
                throw new IllegalArgumentException("Tipo de billete desconocido");
        }
        this.destinoPreferido = destinoPreferido;
        this.disponibilidadFinanciera = disponibilidadFinanciera;
        this.ninos = ninos;
        this.trabaja = trabaja;
        this.independizado = independizado;
        this.ingresos = ingresos;
        this.domicilio = domicilio;
        this.universidad = universidad;
    }


    //Métodos getter, setter y sobreescritura del toString().

    public int getEdad(){
        return edad;
    }

    public int getFrecuenciaViajes(){
        return frecuenciaViajes;
    }

    public tipoViaje getPreferenciaClase(){
        return preferenciaClase;
    }

    public String getDestinoPreferido(){
        return destinoPreferido;
    }

    public int getDisponibilidadFinanciera(){
        return disponibilidadFinanciera;
    }

    public boolean getNinos(){
        return ninos;
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

    public void setPreferenciaClase(tipoViaje nuevaPreferenciaClase){
        preferenciaClase = nuevaPreferenciaClase;
    }

    public void setDestinoPreferido(String nuevoDestinoPreferido){
        destinoPreferido = nuevoDestinoPreferido;
    }

    public void setDisponibilidadFinanciera(int nuevaDisponibilidadFinanciera){
        disponibilidadFinanciera = nuevaDisponibilidadFinanciera;
    }

    public void setNinos(boolean actualizarNinos){
        ninos = actualizarNinos;
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
            + " ,ninos= " + ninos
            + " ,trabaja= " + trabaja
            + " ,independizado= " + independizado
            + " ,ingresos= " + ingresos
            + " ,domicilio= " + domicilio
            + " ,universidad= " + universidad
            + "]";
    }
}
