package esi.uclm.BC06_P2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class Pairwaise {

	@TestFactory
	List<DynamicTest> generatePairwiseTests() {
		List<Object[]> cases = List.of(new Object[] { -1, true, true }, new Object[] { -1, false, false },
				new Object[] { -1, " ", 4000 }, new Object[] { 0, true, false }, new Object[] { 0, false, 4000 },
				new Object[] { 0, " ", true }, new Object[] { 1, true, 4000 }, new Object[] { 1, false, true },
				new Object[] { 1, " ", false }, new Object[] { 15, true, true }, new Object[] { 15, false, 4000 },
				new Object[] { 15, " ", false }, new Object[] { 17, true, false }, new Object[] { 17, false, true },
				new Object[] { 17, " ", 4000 }, new Object[] { 18, true, 4000 }, new Object[] { 18, false, false },
				new Object[] { 18, " ", true }, new Object[] { 19, true, false }, new Object[] { 19, false, 4000 },
				new Object[] { 19, " ", true }, new Object[] { 23, true, true }, new Object[] { 23, false, 4000 },
				new Object[] { 23, " ", false }, new Object[] { 26, true, false }, new Object[] { 26, false, true },
				new Object[] { 26, " ", 4000 }, new Object[] { 30, true, 4000 }, new Object[] { 30, false, true },
				new Object[] { 30, " ", false }, new Object[] { 300, true, false }, new Object[] { 300, false, true },
				new Object[] { 300, " ", 4000 });

		List<DynamicTest> tests = new ArrayList<>();

		for (Object[] caso : cases) {
			int edad = (int) caso[0];
			boolean estudio = caso[1] instanceof Boolean ? (boolean) caso[1] : false;
			boolean viveConPadres = caso[2] instanceof Boolean ? (boolean) caso[2] : false;

			Cliente cliente = new Cliente(edad, estudio, viveConPadres);
			Determinar_Cuenta determinarCuenta = new Determinar_Cuenta();
			String resultado = determinarCuenta.determinar_cuenta(cliente);
			DynamicTest test = DynamicTest.dynamicTest(
					String.format("Edad: %d, Estudia: %s, ViveConPadres: %s", edad, caso[1], caso[2]),
					() -> assertEquals(resultado, determinarCuenta.determinar_cuenta(cliente)));

			tests.add(test);
		}

		return tests;
	}

}
