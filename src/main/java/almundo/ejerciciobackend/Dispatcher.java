package almundo.ejerciciobackend;

import java.util.ArrayList;
import java.util.List;

import almundo.ejerciciobackend.entities.Director;
import almundo.ejerciciobackend.entities.Empleado;
import almundo.ejerciciobackend.entities.Operador;
import almundo.ejerciciobackend.entities.Supervisor;

public class Dispatcher{
	
	private static Dispatcher instance = null;
	
	private List<Operador> operadoresLibres = new ArrayList<Operador>();
	private List<Supervisor> supervisoresLibres = new ArrayList<Supervisor>();
	private List<Director> directoresLibres = new ArrayList<Director>();
	private List<Empleado> empleadosOcupados = new ArrayList<Empleado>();
	
	public static Dispatcher getInstance() {
		if(instance == null) {
			instance = new Dispatcher();
		}
		return instance;
	}
	
	public void dispatchCall(Integer threadId) throws InterruptedException {
		Empleado e = ocuparEmpleado(threadId);
		e.usarEmpleado();
		liberarEmpleado(e,threadId);
	}
	
	public synchronized Empleado ocuparEmpleado(Integer threadId) throws InterruptedException {
		if(operadoresLibres.size() == 0 && supervisoresLibres.size() == 0 && directoresLibres.size() == 0) {
			safePrintln("THREAD " + threadId + " --> NO HAY EMPLEADOS DISPONIBLES, ESPERANDO...");
			wait();
		}
		Empleado e = null;
		if(operadoresLibres.size() > 0) {
			e = operadoresLibres.get(0);
			operadoresLibres.remove(0);
			safePrintln("THREAD " + threadId + " --> USANDO OPERADOR " + e.getIdEmpleado());
			empleadosOcupados.add(e);
		}else if(supervisoresLibres.size() > 0) {
			e = supervisoresLibres.get(0);
			supervisoresLibres.remove(0);
			safePrintln("THREAD " + threadId + " --> NO HAY OPERADORES DISPONIBLES, USANDO SUPERVISOR " + e.getIdEmpleado());
			empleadosOcupados.add(e);
		} else if(directoresLibres.size() > 0) {
			e = directoresLibres.get(0);
			directoresLibres.remove(0);
			safePrintln("THREAD " + threadId + " --> NO HAY SUPERVISORES DISPONIBLES, USANDO DIRECTOR " + e.getIdEmpleado());
			empleadosOcupados.add(e);
		} 
		
		return e;
	}
	
	public synchronized void liberarEmpleado(Empleado e, Integer threadId) {
		if(e instanceof Operador ) {
			for(int i = 0; i < empleadosOcupados.size(); i++) {
				if(empleadosOcupados.get(i).getIdEmpleado().equals(e.getIdEmpleado())) {
					empleadosOcupados.remove(i);
					safePrintln("THREAD " + threadId + " --> LIBERANDO OPERADOR " + e.getIdEmpleado());
					operadoresLibres.add((Operador) e);
					notify();
				}
			}
		}else if(e instanceof Supervisor ) {
			for(int i = 0; i < empleadosOcupados.size(); i++) {
				if(empleadosOcupados.get(i).getIdEmpleado().equals(e.getIdEmpleado())) {
					empleadosOcupados.remove(i);
					safePrintln("THREAD " + threadId + " --> LIBERANDO SUPERVISOR " + e.getIdEmpleado());
					supervisoresLibres.add((Supervisor) e);
					notify();
				}
			}
		} else if(e instanceof Director ) {
			for(int i = 0; i < empleadosOcupados.size(); i++) {
				if(empleadosOcupados.get(i).getIdEmpleado().equals(e.getIdEmpleado())) {
					empleadosOcupados.remove(i);
					safePrintln("THREAD " + threadId + " --> LIBERANDO DIRECTOR " + e.getIdEmpleado());
					directoresLibres.add((Director) e);
					notify();
				}
			}
		}
		
	}

	public void safePrintln(String s) {
	  synchronized (System.out) {
	    System.out.println(s);
	  }
	}

	public List<Operador> getOperadoresLibres() {
		return operadoresLibres;
	}

	public void setOperadoresLibres(List<Operador> operadoresLibres) {
		this.operadoresLibres = operadoresLibres;
	}

	public List<Supervisor> getSupervisoresLibres() {
		return supervisoresLibres;
	}

	public void setSupervisoresLibres(List<Supervisor> supervisoresLibres) {
		this.supervisoresLibres = supervisoresLibres;
	}

	public List<Director> getDirectoresLibres() {
		return directoresLibres;
	}

	public void setDirectoresLibres(List<Director> directoresLibres) {
		this.directoresLibres = directoresLibres;
	}
	
	
	
}
