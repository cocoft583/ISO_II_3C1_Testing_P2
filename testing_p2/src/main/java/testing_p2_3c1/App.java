package testing_p2_3c1;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        // ===== Cliente 1: candidato a "Pajarillo" =====
        Cliente c1 = new Cliente(
                16,                         // edad < 18
                "turista",                  // preferenciaClase
                "París",                    // destinoPreferido
                800,                        // disponibilidadFinanciera
                false,                      // ninos
                false,                      // trabaja
                false,                      // independizado
                0,                          // ingresos
                "Calle Mayor 1, Albacete",  // domicilio
                ""                          // universidad
        );

        // Si tu frecuenciaViajes se deriva de la lista de viajes, añade 6 viajes
        for (int i = 0; i < 6; i++) {
            Viaje v = new Viaje();
            v.setOrigen(c1.getDomicilio());
            v.setDestino("Madrid");
            v.setTipo(tipoBillete.TURISTA);
            v.setFecha(LocalDate.of(2025, 3, 10 + i));
            c1.getViajes().add(v);
        }

        mostrarTarifa("Cliente 1 (Pajarillo esperado)", c1);

        // ===== Cliente 2: candidato a "Gorrión" =====
        Cliente c2 = new Cliente(
                20,                                      // edad entre 18 y 25
                "turista",
                "Ciudad Real",
                600,
                false,
                false,                                   // no trabaja -> lo interpretas como estudiante
                false,
                0,
                "Calle Mayor 1, Albacete",
                "UCLM, Ciudad Real"                     // universidad en otra ciudad
        );

        // Viajes durante el curso domicilio <-> universidad en TURISTA
        // septiembre–junio, uno por mes
        for (int mes = 9; mes <= 12; mes++) {           // sep–dic
            c2.getViajes().add(crearViajeCurso(c2, mes));
        }
        for (int mes = 1; mes <= 6; mes++) {            // ene–jun
            c2.getViajes().add(crearViajeCurso(c2, mes));
        }

        mostrarTarifa("Cliente 2 (Gorrión esperado)", c2);

        // ===== Cliente 3: candidato a "Viaja ahora que puedes" =====
        Cliente c3 = new Cliente(
                23,
                "turista",
                "Roma",
                1000,
                false,
                true,                                   // trabaja
                false,                                  // vive con padres
                1200,
                "Calle Mayor 1, Albacete",
                "UCLM, Ciudad Real"
        );

        // 3 viajes de placer: destino distinto de domicilio y universidad
        for (int i = 0; i < 3; i++) {
            Viaje v = new Viaje();
            v.setOrigen(c3.getDomicilio());
            v.setDestino("Roma");
            v.setTipo(tipoBillete.TURISTA);
            v.setFecha(LocalDate.of(2025, 7, 5 + i));
            // si tienes un campo motivo, puedes marcar PLACER
            // v.setMotivo("PLACER");
            c3.getViajes().add(v);
        }

        mostrarTarifa("Cliente 3 (Viaja ahora que puedes esperado)", c3);

        // Aquí podrías añadir más clientes para probar "Conoce Europa", "Conoce el Mundo", etc.
    }

    private static Viaje crearViajeCurso(Cliente c, int mes) {
        Viaje v = new Viaje();
        v.setOrigen(c.getDomicilio());
        v.setDestino(c.getUniversidad());
        v.setTipo(tipoBillete.TURISTA);
        v.setFecha(LocalDate.of(2025, mes, 15));
        return v;
    }

    private static Viaje crearViajeEjemplo(Cliente c) {
    Viaje v = new Viaje();

    v.setOrigen(c.getDomicilio());

    v.setDestino(c.getDestinoPreferido());

    v.setTipo(c.getPreferenciaClase());

    v.setPaisDestino("europa");

    v.setFecha(LocalDate.of(2025, 1, 15));
    v.setConNinos(false);

    return v;
}

    private static void mostrarTarifa(String label, Cliente c) {

        Viaje v = crearViajeEjemplo(c);
        Tarifa t = Tarifa.calcularTarifa(c, v);

        if (t != null) {
            System.out.println(label + " -> " + t.getNombre()
                    + " (" + (t.getDescuento() * 100) + "%)");
        } else {
            System.out.println(label + " -> sin tarifa aplicable");
        }
    }
}