package testing_p2_3c1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Apartado 6: Pruebas Each Use")
class TarifaEachUseTest extends TarifaTestBase {

    @ParameterizedTest(name = "CP{index}")
    @CsvSource({
        "-2, -5, -3, TURISTA, Europa, true, true, true, true",
        "16, 2, 19000, BUSINESS, Asia, false, false, false, false",
        "22, 4, 25000, null, America, true, true, true, true",
        "30, 7, 35000, null, Africa, false, false, false, false",
        "0, 3, 40000, TURISTA, '', true, true, true, true",
        "1, 5, 20000, BUSINESS, null, false, false, false, false",
        "17, 6, 20001, TURISTA, Europa, true, true, true, true",
        "26, 2000, 35001, BUSINESS, Asia, false, false, false, false",
        "18, 0, 0, TURISTA, America, true, true, true, true",
        "25, 0, 33554432, BUSINESS, Africa, false, false, false, false",
        "2000, 0, 0, TURISTA, Europa, true, true, true, true",
        "0, 2, 0, BUSINESS, Asia, false, false, false, false",
        "0, 4, 1111, TURISTA, America, true, true, true, true",
        "0, 7, 25000, BUSINESS, Europa, false, false, false, false"
    })
    void testEachUse(int edad, int frec, int ing, String clase, String pais, 
                     boolean trab, boolean indep, boolean ninos, boolean curso) {
        
        Cliente c = crearEscenario(edad, frec, ing, clase, trab, indep, curso);
        Viaje v = crearViajeEvaluacion(pais, ninos);
        
        Tarifa resultado = calcularTarifaSafe(c, v);
        
        if (edad == 17 && frec >= 6) {
            assertNotNull(resultado);
            assertEquals("Pajarillo", resultado.getNombre());
        }
    }
}