

public class Determinar_Cuenta {
	
	public String determinar_cuenta(Cliente cliente){
		
		if(cliente.getEdadd() < 18 && cliente.isEstudiaa() && cliente.isViveconPadres()) {
			return "Cuenta Confort";
		} else if (cliente.getEdadd() < 25 && cliente.isEstudiaa() && !cliente.isViveconPadres()) {
			return "Cuenta_vamos_que_tu_Puedes";	
		} else if(cliente.getEdadd() >= 18 && !cliente.isEstudiaa()) {
			if (cliente.getEdadd() <= 25) {
				if (cliente.isViveconPadres()) {
					return "Cuenta_Ahorra_ahora_que_Puedes";
				} else {
					return "Cuenta_saltando_del_Nido";
			    }
			} else { 
				if (cliente.isViveconPadres()) {
					return "Cuenta_Independizate_que_va_siendo_hora";	
				} else {
					return "Cuenta_Bienvenido_Vida_Adulta";
				}
			}
		}
		return "Condicion no válida para determinar un tipo de cuenta";
	}
}
