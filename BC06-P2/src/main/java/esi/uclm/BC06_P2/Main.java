package esi.uclm.BC06_P2;

public class Main {
	
	public static void main(String[] args) {
		
		// Crear Cliente
		Cliente cliente = new Cliente(17, true, true, true);
		
		// Crear Instrancia
		Determinar_Cuenta determinador = new Determinar_Cuenta();
		
		// Obtener Resultado
		String cuenta = determinador.determinar_cuenta(cliente);
		System.out.println("Resultado: " + cuenta);
		
	}
}
