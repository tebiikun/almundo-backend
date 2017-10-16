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
    	List<Operador> operadores = new ArrayList<Operador>();
    	List<Supervisor> supervisores = new ArrayList<Supervisor>();
    	List<Director> directores = new ArrayList<Director>();
    	
    	operadores.add(new Operador(1));
    	operadores.add(new Operador(2));
    	operadores.add(new Operador(3));
    	operadores.add(new Operador(4));
    	operadores.add(new Operador(5));
    	supervisores.add(new Supervisor(6));
    	supervisores.add(new Supervisor(7));
    	supervisores.add(new Supervisor(8));
    	supervisores.add(new Supervisor(9));
    	directores.add(new Director(10));
    	Dispatcher dispatcher = Dispatcher.getInstance();
    	
    	dispatcher.setOperadoresLibres(operadores);
    	dispatcher.setSupervisoresLibres(supervisores);
    	dispatcher.setDirectoresLibres(directores);
    	
    	new Thread(new ExecutionThread(dispatcher, 1)).start();
    	new Thread(new ExecutionThread(dispatcher, 2)).start();
    	new Thread(new ExecutionThread(dispatcher, 3)).start();
    	new Thread(new ExecutionThread(dispatcher, 4)).start();
    	new Thread(new ExecutionThread(dispatcher, 5)).start();
    	new Thread(new ExecutionThread(dispatcher, 6)).start();
    	new Thread(new ExecutionThread(dispatcher, 7)).start();
    	new Thread(new ExecutionThread(dispatcher, 8)).start();
    	new Thread(new ExecutionThread(dispatcher, 9)).start();
    	new Thread(new ExecutionThread(dispatcher, 10)).start();
    	new Thread(new ExecutionThread(dispatcher, 11)).start();
    	new Thread(new ExecutionThread(dispatcher, 12)).start();
    	new Thread(new ExecutionThread(dispatcher, 13)).start();
    	new Thread(new ExecutionThread(dispatcher, 14)).start();
    	new Thread(new ExecutionThread(dispatcher, 15)).start();
    	new Thread(new ExecutionThread(dispatcher, 16)).start();
    	new Thread(new ExecutionThread(dispatcher, 17)).start();
    	new Thread(new ExecutionThread(dispatcher, 18)).start();
    	new Thread(new ExecutionThread(dispatcher, 19)).start();
    	new Thread(new ExecutionThread(dispatcher, 20)).start();
    	new Thread(new ExecutionThread(dispatcher, 21)).start();
    	new Thread(new ExecutionThread(dispatcher, 22)).start();
    	new Thread(new ExecutionThread(dispatcher, 23)).start();
    	new Thread(new ExecutionThread(dispatcher, 24)).start();
    	new Thread(new ExecutionThread(dispatcher, 25)).start();
    	
    }
}
