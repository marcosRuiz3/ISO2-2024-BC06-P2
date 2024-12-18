package esi.uclm.BC06_P2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class AppTest4 {

    @TestFactory
    List<DynamicTest> generateTests() {
        int[] edades = {-1, 15, 23, 30, 0, 1, 18, 17, 19, 26, 300};
        Object[] estudia = {true, false, " "}; // Agregamos la conjetura de error aquí
        Object[] viveConPadres = {true, false, 4000}; // Agregamos la conjetura de error aquí
        List<DynamicTest> tests = new ArrayList<>();

        for (int edad : edades) {
            for (Object estudio : estudia) {
                for (Object vive : viveConPadres) {
                    boolean estudioBool = estudio instanceof Boolean ? (Boolean) estudio : false;
                    boolean viveConPadresBool = vive instanceof Boolean ? (Boolean) vive : false;
                    Cliente cliente = new Cliente(edad, estudioBool, viveConPadresBool);
                    Determinar_Cuenta determinarCuenta = new Determinar_Cuenta();
                    String resultado = determinarCuenta.determinar_cuenta(cliente);
                    String expected = getExpectedResult(edad, estudioBool, viveConPadresBool);

                    DynamicTest test = DynamicTest.dynamicTest(
                            String.format("Edad: %d, Estudia: %s, ViveConPadres: %s", edad, estudio, vive),
                            () -> assertEquals(expected, resultado)
                    );
                    tests.add(test);
                }
            }
        }
        return tests;
    }

    private String getExpectedResult(int edad, boolean estudia, boolean viveConPadres) {
        if (edad < 18 && estudia && viveConPadres) {
            return "Cuenta Confort";
        } else if (edad < 25 && estudia && !viveConPadres) {
            return "Cuenta_vamos_que_tu_Puedes";
        } else if (edad >= 18) {
            if (edad <= 25) {
                if (viveConPadres) {
                    return "Cuenta_Ahorra_ahora_que_Puedes";
                } else {
                    return "Cuenta_saltando_del_Nido";
                }
            } else {
                if (viveConPadres) {
                    return "Cuenta_Independizate_que_va_siendo_hora";
                } else {
                    return "Cuenta_Bienvenido_Vida_Adulta";
                }
            }
        }
        return "Condicion no válida para determinar un tipo de cuenta";
    }
}
