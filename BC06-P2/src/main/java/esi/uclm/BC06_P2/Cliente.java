package esi.uclm.BC06_P2;

public class Cliente {

	private int edad;
	private boolean estudia;
	private boolean vive_con_padres;

	// Constructor
	public Cliente(int edad, boolean estudia, boolean vive_con_padres) {
		this.edad = edad;
		this.estudia = estudia;
		this.vive_con_padres = vive_con_padres;
	}

	public int getEdadd() {
		return edad;
	}

	public boolean isEstudiaa() {
		return estudia;
	}

	public boolean isViveconPadres() {
		return vive_con_padres;
	}
}
