package testing_p2_3c1;

import java.time.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Tarifa {

    private String nombre;
    private double descuento; // 0.10 = 10 %
    Set<Integer> mesesCurso = Set.of(1,2,3,4,5,6,9,10,11,12);

    public Tarifa(String nombre, double descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public boolean viajaDuranteElCurso(Cliente c){ //Quizás lo podemos quitar
        return c.viajaUnaVezAlMesDuranteCurso();
     }



        if((c.viajes.origen.equals(c.getDomicilio) && c.viajes.destino.equals(c.getUniversidad())) || (c.viajes.origen.equals(c.getUniversidad) && c.viajes.destino.equals(c.getDomicilio()))){
            viajeDuranteCurso.add(c.viaje); //Esta lista contendrá los viajes realizados durante el curso unicamente.
            //Verificamos que se realice durante los viajes del curso
            Iterator<Viaje> viaje = viajeDuranteCurso.iterator();
            while (viaje.hasNext()) {
                Viaje v = viaje.next();
                while (!mescurso) {
                    for(int i=0; i < mesesCurso.length; i++){
                        if (mesescurso[i] == v.getFecha().getMonthValue()) {
                            mescurso = true;
                        }
                    }
                }
            }
        }

        return mescurso;
    }


    public static Tarifa calcularTarifa(Cliente c, Viaje v) {

        int edad = c.getEdad();
        int frecuencia = c.getFrecuenciaViajes();
        tipoBillete clase = c.getPreferenciaClase();
        String destino = c.getDestinoPreferido();
        int ingresos = c.getIngresos();        
        boolean trabaja = c.getTrabaja();
        boolean independizado = c.getIndependizado();

        // 1) Menor de edad → Pajarillo
        if (edad < 18) {
            if (frecuencia >= 6) {
                return new Tarifa("Pajarillo", 0.10);
            } 
        }

        // 2) 18–25 años, estudiante en otra ciudad, viajando en turista
        if (edad >= 18 && edad <= 25 && !trabaja) {
            if (viajaDuranteElCurso(c)) {
                return new Tarifa("Gorrión", 0.15);
            }
        }

        // 3) 18–25, trabaja
        if (edad >= 18 && edad <= 25 && trabaja) {
            
            if (clase == tipoBillete.TURISTA && frecuencia >= 3) {
                if (!independizado) {
                    return new Tarifa("Viaja ahora que puedes", 0.05);
                } else {
                    return new Tarifa("Atreviéndose a saltar del Nido", 0.25);
                }
            }
        }

        // 4) >25 años, ingresos entre 20k y 35k, 6 viajes/año en turista dentro de Europa
        if (edad > 25 && ingresos > 20000 && ingresos < 35000) {
            if (clase == tipoBillete.TURISTA && frecuencia >= 6 && paisDestino.equalsIgnoreCase("europa")) {
                if (v.isConNinos()) {
                    return new Tarifa("Conoce Europa con tus peques", 0.10);
                } else {
                    return new Tarifa("Conoce Europa", 0.15);
                }
            }
        }

        // 5) >25 años, ingresos >35k, 6 viajes/año en business a Asia o América
        if (edad > 25 && ingresos > 35000) {
            if (clase == tipoBillete.BUSINESS && frecuencia >= 6 &&
                (paisDestino.equalsIgnoreCase("asia") || paisDestino.equalsIgnoreCase("america"))) {

                if (v.isConNinos()) {
                    return new Tarifa("Conoce el Mundo con tus peques", 0.10);
                } else {
                    return new Tarifa("Conoce el Mundo", 0.20);
                }
            }
        }

        // Si no cae en ninguno de los casos:
        return null;
    }
}

//La tarifa se aplica a cada billete.

