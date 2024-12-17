package esi.uclm.BC06_P2;

public class Determinar_Cuenta {
	
	public String determinar_cuenta(Cliente cliente){
		String salida= "";
		// COMPROBACIÓN 1: Cliente menor de 18 años, estudia y vive con sus padres
		if(cliente.getEdadd() < 18 && cliente.isEstudiaa() && cliente.isViveconPadres()) {
			salida= "Cuenta Confort";
			return salida;
			// COMPROBACIÓN 2: Cliente menor de 25 años, estudia y no vive con sus padres
		} else if (cliente.getEdadd() < 25 && cliente.isEstudiaa() && !cliente.isViveconPadres()) {
			salida= "Cuenta_vamos_que_tu_Puedes";	
			return salida;
			// COMPROBACIÓN 3: Cliente mayor o igual de 18 años y trabaja
		} else if(cliente.getEdadd() >= 18 && !cliente.isEstudiaa()) {
			if (cliente.getEdadd() <= 25) {
				if (cliente.isViveconPadres()) {
					salida="Cuenta_Ahorra_ahora_que_Puedes";
					return salida;
				} else {
					salida= "Cuenta_saltando_del_Nido";
					return salida;
			    }
				// COMPROBACION 4 Y 5: Cliente mayor de 25 años
			} else { 
				if (cliente.isViveconPadres()) {
					salida="Cuenta_Independizate_que_va_siendo_hora";
					return salida;	
				} else {
					salida="Cuenta_Bienvenido_Vida_Adulta";
					return salida;
				}
			}
		}
		salida="Condicion no válida para determinar un tipo de cuenta";
		return salida;
	}
}
