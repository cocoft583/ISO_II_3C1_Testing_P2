package testing_p2_3c1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

@DisplayName("Apartado 8 y 9: Decisiones y MC/DC")
class TarifaDecisionTest extends TarifaTestBase {

    @Nested
    @DisplayName("Bloque 1: Menor de Edad")
    class BloquePajarillo {
        @Test
        void casoVerdadero() {
            Cliente c = crearEscenario(17, 6, 0, "turista", false, false, false);
            Viaje v = crearViajeEvaluacion("ES", false);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Pajarillo", t.getNombre());
        }

        @Test
        void casoFalsoEdad() {
            Cliente c = crearEscenario(22, 6, 0, "turista", false, false, false);
            Viaje v = crearViajeEvaluacion("ES", false);
            assertNull(Tarifa.calcularTarifa(c, v));
        }
        
        @Test
        void casoFalsoFrecuencia() {
            Cliente c = crearEscenario(17, 2, 0, "turista", false, false, false);
            Viaje v = crearViajeEvaluacion("ES", false);
            assertNull(Tarifa.calcularTarifa(c, v));
        }
    }

    @Nested
    @DisplayName("Bloque 2: Estudiante")
    class BloqueGorrion {
        @Test
        void casoVerdadero() {
            Cliente c = crearEscenario(20, 0, 0, "turista", false, false, true);
            Viaje v = crearViajeEvaluacion("DE", false);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Gorrión", t.getNombre());
        }

        @Test
        void casoFalsoTrabaja() {
            Cliente c = crearEscenario(20, 0, 0, "business", true, false, true); 
            Viaje v = crearViajeEvaluacion("DE", false);
            assertNull(Tarifa.calcularTarifa(c, v));
        }

        @Test
        void casoFalsoViajes() {
            Cliente c = crearEscenario(20, 0, 0, "turista", false, false, false);
            Viaje v = crearViajeEvaluacion("DE", false);
            assertNull(Tarifa.calcularTarifa(c, v));
        }
    }

    @Nested
    @DisplayName("Bloque 3: Joven Trabajador")
    class BloqueJovenTrabajador {
        @Test
        void casoViajaAhora() {
            Cliente c = crearEscenario(22, 3, 1000, "turista", true, false, false);
            Viaje v = crearViajeEvaluacion("PT", false);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Viaja ahora que puedes", t.getNombre());
        }

        @Test
        void casoSaltarNido() {
            Cliente c = crearEscenario(22, 3, 1000, "turista", true, true, false);
            Viaje v = crearViajeEvaluacion("PT", false);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Atreviéndose a saltar del Nido", t.getNombre());
        }

        @Test
        void casoFalloClase() {
            Cliente c = crearEscenario(22, 3, 1000, "business", true, false, false);
            Viaje v = crearViajeEvaluacion("PT", false);
            assertNull(Tarifa.calcularTarifa(c, v));
        }
    }

    @Nested
    @DisplayName("Bloque 4: Conoce Europa")
    class BloqueConoceEuropa {
        @Test
        void casoSinNinos() {
            Cliente c = crearEscenario(30, 6, 25000, "turista", true, true, false);
            Viaje v = crearViajeEvaluacion("europa", false);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Conoce Europa", t.getNombre());
        }

        @Test
        void casoConNinos() {
            Cliente c = crearEscenario(30, 6, 25000, "turista", true, true, false);
            Viaje v = crearViajeEvaluacion("europa", true);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Conoce Europa con tus peques", t.getNombre());
        }

        @Test
        void casoFalloIngresos() {
            Cliente c = crearEscenario(30, 6, 15000, "turista", true, true, false);
            Viaje v = crearViajeEvaluacion("europa", false);
            assertNull(Tarifa.calcularTarifa(c, v));
        }
    }

    @Nested
    @DisplayName("Bloque 5: Conoce el Mundo")
    class BloqueConoceMundo {
        @Test
        void casoSinNinos() {
            Cliente c = crearEscenario(30, 6, 40000, "business", true, true, false);
            Viaje v = crearViajeEvaluacion("asia", false);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Conoce el Mundo", t.getNombre());
        }

        @Test
        void casoConNinos() {
            Cliente c = crearEscenario(30, 6, 40000, "business", true, true, false);
            Viaje v = crearViajeEvaluacion("america", true);
            Tarifa t = Tarifa.calcularTarifa(c, v);
            assertEquals("Conoce el Mundo con tus peques", t.getNombre());
        }
    }
}