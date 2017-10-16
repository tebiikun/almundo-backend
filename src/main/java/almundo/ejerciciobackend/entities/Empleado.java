package almundo.ejerciciobackend.entities;

import java.util.Random;

public abstract class Empleado {
	
	private Integer idEmpleado;
	
	public Empleado() {
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public void usarEmpleado() throws InterruptedException {
		Random r = new Random();
		Thread.sleep(r.nextInt(5000) + 5000);
	}
}
