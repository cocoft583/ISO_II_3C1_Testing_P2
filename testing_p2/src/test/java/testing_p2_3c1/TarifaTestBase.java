package testing_p2_3c1;

import java.time.LocalDate;


public abstract class TarifaTestBase {

    protected static final String DOMICILIO = "Calle Mayor, 1, Albacete, España";
    protected static final String UNIVERSIDAD = "UCLM, Ciudad Real, España";

    protected Cliente crearEscenario(int edad, int frecuencia, int ingresos, String claseStr, 
                                     boolean trabaja, boolean independizado, boolean viajaCurso) {
        
        String clase = (claseStr == null || claseStr.equals("null") || claseStr.isEmpty()) ? "turista" : claseStr;

        Cliente c = new Cliente(
            edad,
            clase,
            "DestinoX",
            1000,
            false,
            trabaja,
            independizado,
            ingresos,
            DOMICILIO,
            UNIVERSIDAD
        );

        for (int i = 0; i < frecuencia; i++) {
            Viaje v = new Viaje();
            v.setOrigen("A"); 
            v.setDestino("B"); 
            v.setTipo(tipoBillete.TURISTA);
            c.getViajes().add(v);
        }

        if (viajaCurso) {
            c.getViajes().clear();
            int[] meses = {9, 10, 11, 12, 1, 2, 3, 4, 5};
            for (int m : meses) {
                Viaje vc = new Viaje();
                vc.setOrigen(DOMICILIO); 
                vc.setDestino(UNIVERSIDAD);
                vc.setTipo(tipoBillete.TURISTA);
                vc.setFecha(LocalDate.of(2025, m, 15));
                c.getViajes().add(vc);
            }
            for (int i = 9; i < frecuencia; i++) {
                 Viaje v = new Viaje();
                 v.setOrigen("A"); v.setDestino("B"); v.setTipo(tipoBillete.TURISTA);
                 c.getViajes().add(v);
            }
        }
        
        return c;
    }

    protected Viaje crearViajeEvaluacion(String paisDestino, boolean conNinos) {
        Viaje v = new Viaje();
        String pais = (paisDestino == null || paisDestino.equals("null")) ? null : paisDestino;
        v.setPaisDestino(pais);
        v.setConNinos(conNinos);
        return v;
    }

    protected Tarifa calcularTarifaSafe(Cliente c, Viaje v) {
        try {
            return Tarifa.calcularTarifa(c, v);
        } catch (Exception e) {
            return null;
        }
    }
}