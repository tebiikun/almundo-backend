package almundo.ejerciciobackend;

import java.util.ArrayList;
import java.util.List;

import almundo.ejerciciobackend.entities.Director;
import almundo.ejerciciobackend.entities.Operador;
import almundo.ejerciciobackend.entities.Supervisor;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {	
    	int idEmpl = 1;
    	
    	Integer numeroOperadores = Constants.NUMERO_OPERADORES;
    	Integer numeroSupervisores = Constants.NUMERO_SUPERVISORES;
    	Integer numeroDirectores = Constants.NUMERO_DIRECTORES;
    	Integer numeroLlamadas = Constants.NUMERO_LLAMADAS_CONCURRENTES;
    	
    	List<Operador> operadores = new ArrayList<Operador>();
    	List<Supervisor> supervisores = new ArrayList<Supervisor>();
    	List<Director> directores = new ArrayList<Director>();
    	
    	Dispatcher dispatcher = Dispatcher.getInstance();
    	
    	/* INSTANCE EMPLOYEE */
        for(int i = 0; i < numeroOperadores; i++) {
        	operadores.add(new Operador(idEmpl));
        	idEmpl++;
        }
        
        for(int i = 0; i < numeroSupervisores; i++) {
        	supervisores.add(new Supervisor(idEmpl));
        	idEmpl++;
        }
        
        for(int i = 0; i < numeroDirectores; i++) {
        	directores.add(new Director(idEmpl));
        	idEmpl++;
        }
        
        dispatcher.setOperadoresLibres(operadores);
    	dispatcher.setSupervisoresLibres(supervisores);
    	dispatcher.setDirectoresLibres(directores);
    	
        /* INSTANCE THREADS */
        
        for(int i = 0; i < numeroLlamadas; i++) {
        	new Thread(new ExecutionThread(dispatcher, i)).start();
        }
    }
}
