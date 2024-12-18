package esi.uclm.BC06_P2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class EachUse {

    @TestFactory
    List<DynamicTest> generateEachUseTests() {
        List<Object[]> cases = List.of(
            new Object[]{-1, true, true},
            new Object[]{15, false, false},
            new Object[]{23, " ", 4000},
            new Object[]{30, true, true},
            new Object[]{0, false, false},
            new Object[]{1, " ", 4000},
            new Object[]{18, true, true},
            new Object[]{17, false, false},
            new Object[]{19, " ", 4000},
            new Object[]{26, true, true},
            new Object[]{300, false, false}
        );

        List<DynamicTest> tests = new ArrayList<>();

        for (Object[] caso : cases) {
            int edad = (int) caso[0];
            boolean estudia = caso[1] instanceof Boolean ? (boolean) caso[1] : false;
            boolean viveConPadres = caso[2] instanceof Boolean ? (boolean) caso[2] : false;

            Cliente cliente = new Cliente(edad, estudia, viveConPadres);
            Determinar_Cuenta determinarCuenta = new Determinar_Cuenta();
            String resultado = determinarCuenta.determinar_cuenta(cliente);

            DynamicTest test = DynamicTest.dynamicTest(
                String.format("Edad: %d, Estudia: %s, ViveConPadres: %s", edad, caso[1], caso[2]),
                () -> assertEquals(resultado, determinarCuenta.determinar_cuenta(cliente))
            );
            tests.add(test);
        }

        return tests;
    }
}
