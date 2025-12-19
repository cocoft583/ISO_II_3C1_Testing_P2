package testing_p2_3c1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Apartado 7: Pruebas Pairwise")
class TarifaPairwiseTest extends TarifaTestBase {

    @ParameterizedTest(name = "PW{index}")
    @CsvSource({
        "-2, -5, -3, TURISTA, Europa, true, true, true, true",       
        "-2, 2, 19000, BUSINESS, Asia, false, false, false, false",  
        "-2, 4, 25000, null, America, true, true, true, true",       
        "-2, 3, 40000, TURISTA, '', true, true, true, true",         
        "16, 4, -3, BUSINESS, Asia, false, false, false, false",     
        "16, 7, 19000, '', America, true, true, true, true",         
        "16, 5, 35000, TURISTA, '', true, true, true, true",         
        "22, 6, 25000, TURISTA, '', true, true, true, true",         
        "30, 2000, 19000, TURISTA, '', true, true, true, true",      
        "30, -5, 20000, TURISTA, America, true, true, true, true"    
    })
    void testPairwise(int edad, int frec, int ing, String clase, String pais, 
                      boolean trab, boolean indep, boolean ninos, boolean curso) {
        
        Cliente c = crearEscenario(edad, frec, ing, clase, trab, indep, curso);
        Viaje v = crearViajeEvaluacion(pais, ninos);
        calcularTarifaSafe(c, v);
    }
}