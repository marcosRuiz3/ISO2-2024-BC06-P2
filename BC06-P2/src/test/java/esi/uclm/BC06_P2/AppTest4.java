package esi.uclm.BC06_P2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class AppTest4 {

	@TestFactory
	List<DynamicTest> generateTests() {
		int[] edades = { -1, 15, 23, 30, 0, 1, 18, 17, 19, 26, 300 };
		Object[] estudia = { true, false, " " }; // Agregamos la conjetura de error aquí
		Object[] viveConPadres = { true, false, 4000 }; // Agregamos la conjetura de error aquí
		List<DynamicTest> tests = new ArrayList<>();

		for (int edad : edades) {
			for (Object estudio : estudia) {
				for (Object vive : viveConPadres) {
					boolean estudioBool = estudio instanceof Boolean ? (Boolean) estudio : false;
					boolean viveConPadresBool = vive instanceof Boolean ? (Boolean) vive : false;
					Cliente cliente = new Cliente(edad, estudioBool, viveConPadresBool);
					Determinar_Cuenta determinarCuenta = new Determinar_Cuenta();
					String resultado = determinarCuenta.determinar_cuenta(cliente);
					DynamicTest test = DynamicTest.dynamicTest(
							String.format("Edad: %d, Estudia: %s, ViveConPadres: %s", edad, estudioBool,
									viveConPadresBool),
							() -> assertEquals(resultado, determinarCuenta.determinar_cuenta(cliente)));
					tests.add(test);
				}
			}
		}
		return tests;
	}
}
