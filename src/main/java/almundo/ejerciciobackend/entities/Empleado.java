package almundo.ejerciciobackend.entities;

import java.util.Random;

public abstract class Empleado {
	
	private Integer idEmpleado;
	private boolean libre;
	
	public Empleado() {
		this.libre = true;
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	};
	
	public void usarEmpleado() throws InterruptedException {
		Random r = new Random();
		Thread.sleep(r.nextInt(5000));
	}
}
