package  TT_Ejercicio2;

public class Cliente {
	
	private int edad;
	private boolean estudia;
	private boolean trabaja;
	private boolean vive_con_padres;
	
	// Constructor
	public Cliente(int edad, boolean estudia, boolean trabaja, boolean vive_con_padres) {
		this.edad = edad;
		this.estudia = estudia;
		this.trabaja = trabaja;
		this.vive_con_padres = vive_con_padres;
	}
	
	public int getEdadd() {
		return edad;
	}

	public boolean isEstudiaa() {
		return estudia;
	}
	
	public boolean isTrabajaa() {
		return trabaja;
	}
	
	public boolean isViveconPadres() {
		return vive_con_padres;
	}
}
