package testing_p2_3c1;

public class Tarifa {

    private String nombre;
    private double descuento; // 0.10 = 10 %

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


    public static Tarifa calcularTarifa(Cliente c) {

        int edad = c.getEdad();
        int frecuencia = c.getFrecuenciaViajes();
        tipoViaje clase = c.getPreferenciaClase();
        String destino = c.getDestinoPreferido();
        int ingresos = c.getIngresos();        
        boolean trabaja = c.getTrabaja();
        boolean independizado = c.getIndependizado();
        boolean ninos = c.getNinos();

        // 1) Menor de edad → Pajarillo
        if (edad < 18) {
            if (frecuencia >= 6) {
                return new Tarifa("Pajarillo", 0.10);
            } else {
                return null;
            }
        }

        if (edad >= 18 && edad <= 25 && !trabaja) {
            // simplificación: consideramos "al menos 12 viajes/año en turista"
            if (clase == tipoViaje.TURISTA && frecuencia >= 12 && (destino.equals(c.getDomicilio()) || destino.equals(c.getUniversidad())) {
                return new Tarifa("Gorrión", 0.15);
            }
        }

        // 3) 18–25, trabaja
        if (edad >= 18 && edad <= 25 && trabaja) {
            
            if (clase == tipoViaje.TURISTA && frecuencia >= 3) {
                if (!independizado) {
                    return new Tarifa("Viaja ahora que puedes", 0.05);
                } else {
                    return new Tarifa("Atreviéndose a saltar del Nido", 0.25);
                }
            }
        }

        // 4) >25 años, ingresos entre 20k y 35k, 6 viajes/año en turista dentro de Europa
        if (edad > 25 && ingresos > 20000 && ingresos < 35000) {
            if (clase == tipoViaje.TURISTA && frecuencia >= 6 && paisDestino.equalsIgnoreCase("europa")) {
                if (ninos) {
                    return new Tarifa("Conoce Europa con tus peques", 0.10);
                } else {
                    return new Tarifa("Conoce Europa", 0.15);
                }
            }
        }

        // 5) >25 años, ingresos >35k, 6 viajes/año en business a Asia o América
        if (edad > 25 && ingresos > 35000) {
            if (clase == tipoViaje.BUSINESS && frecuencia >= 6 &&
                (paisDestino.equalsIgnoreCase("asia") || paisDestino.equalsIgnoreCase("america"))) {

                if (ninos) {
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

